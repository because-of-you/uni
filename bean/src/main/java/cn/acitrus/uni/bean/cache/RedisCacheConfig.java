package cn.acitrus.uni.bean.cache;

import cn.acitrus.uni.common.entities.config.RepositoryConfigEntity;
import cn.acitrus.uni.common.enums.repository.RepositoryType;
import cn.acitrus.uni.repository.RepositoryConfigEntityRepository;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/29
 **/
@Configuration
@EnableCaching
public class RedisCacheConfig {
    @Bean(destroyMethod = "shutdown")
    protected RedissonClient redisson(
            RepositoryConfigEntityRepository repository
    ) {
        RepositoryConfigEntity redis = repository.getRepositoryConfigEntityByRepositoryTypeEquals(RepositoryType.REDIS);

        int processors = Runtime.getRuntime().availableProcessors();
        Config config = new Config();
        config
                .setThreads(processors * 2 + 1)
                .useSingleServer()
                .setAddress(redis.getHost())
                .setUsername(redis.getUsername())
                .setPassword(redis.getPassword())
                .setConnectionPoolSize(processors * 2 + 1)
                .setConnectionMinimumIdleSize(processors)
                .setClientName("uni-redis")
                .setIdleConnectionTimeout((int) TimeUnit.SECONDS.toMillis(3))
                .setConnectTimeout((int) TimeUnit.SECONDS.toMillis(3))
        ;
        return Redisson.create(config);
    }

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
