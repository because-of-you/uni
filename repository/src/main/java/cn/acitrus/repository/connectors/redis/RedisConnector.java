package cn.acitrus.repository.connectors.redis;

import cn.acitrus.common.enums.repository.RepositoryType;
import cn.acitrus.repository.connectors.Connector;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/28
 **/
@Component
@RequiredArgsConstructor
public class RedisConnector implements Connector {
//    @Bean(destroyMethod = "shutdown")
//    protected RedissonClient redisson(
//            RepositoryConfigEntityRepository repository
//    ) {
//        RepositoryConfigEntity redis = repository.getRepositoryConfigEntityByRepositoryTypeEquals(RepositoryType.REDIS);
//
//        int processors = Runtime.getRuntime().availableProcessors();
//        Config config = new Config();
//        config
//                .setThreads(processors * 2 + 1)
//                .setNettyThreads(processors * 2 + 1)
//                .useSingleServer()
//                .setAddress(redis.getHost())
//                .setUsername(redis.getUsername())
//                .setPassword(redis.getPassword())
//                .setConnectionPoolSize(processors * 2 + 1)
//                .setConnectionMinimumIdleSize(processors)
//                .setClientName("uni-redis")
//                .setIdleConnectionTimeout((int) TimeUnit.SECONDS.toMillis(3))
//                .setConnectTimeout((int) TimeUnit.SECONDS.toMillis(3))
//        ;
//        return Redisson.create(config);
//    }

    @Bean
    protected CacheManager cacheManager(
            RedissonClient redissonClient
    ) {
        Map<String, CacheConfig> config = new ConcurrentHashMap<>(4);
        CacheConfig permissions = new CacheConfig();
        permissions.setMaxSize(100);
        permissions.setTTL(TimeUnit.MINUTES.toMillis(3));
        permissions.setMaxIdleTime(TimeUnit.MINUTES.toMillis(1));

        config.put("uni:cache:permissions", permissions);
        return new RedissonSpringCacheManager(redissonClient, config);
    }
}
