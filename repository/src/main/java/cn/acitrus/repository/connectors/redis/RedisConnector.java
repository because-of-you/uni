package cn.acitrus.repository.connectors.redis;

import cn.acitrus.common.entities.connector.ConnectorEntity;
import cn.acitrus.common.entities.connector.connection.RedisConnection;
import cn.acitrus.common.enums.permissions.ConnectorType;
import cn.acitrus.repository.connectors.ConnectorEntityRepository;
import cn.acitrus.repository.connectors.Connector;
import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
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
    private final ConnectorEntityRepository repository;

    @Bean(destroyMethod = "shutdown")
    protected RedissonClient redisson() {

        Example<ConnectorEntity> example = Example.of(ConnectorEntity.builder().connectorType(ConnectorType.REDIS).build());
        ConnectorEntity connector = repository.findOne(example).orElse(new ConnectorEntity());

        if (connector.getConnection() instanceof RedisConnection redisConnection) {
            int processors = Runtime.getRuntime().availableProcessors();
            Config config = new Config();
            config
                    .setThreads(processors * 2 + 1)
                    .setNettyThreads(processors * 2 + 1)
                    .useSingleServer()
                    .setAddress(redisConnection.getHost())
                    .setUsername(redisConnection.getUsername())
                    .setPassword(redisConnection.getPassword())
                    .setConnectionPoolSize(processors * 2 + 1)
                    .setConnectionMinimumIdleSize(processors)
                    .setClientName("uni-redis")
                    .setIdleConnectionTimeout((int) TimeUnit.SECONDS.toMillis(3))
                    .setConnectTimeout((int) TimeUnit.SECONDS.toMillis(3));

            return Redisson.create(config);
        }

        return Redisson.create();
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
