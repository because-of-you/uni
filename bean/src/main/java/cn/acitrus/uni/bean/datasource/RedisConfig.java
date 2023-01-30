package cn.acitrus.uni.bean.datasource;

import cn.acitrus.uni.common.entities.RepositoryConfigEntity;
import cn.acitrus.uni.common.entities.enums.RepositoryType;
import cn.acitrus.uni.repository.RepositoryConfigEntityRepository;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/29
 **/
@Configuration
@EnableCaching
public class RedisConfig {
    @Bean(destroyMethod = "shutdown")
    protected RedissonClient redisson(
            RepositoryConfigEntityRepository repository
    ) {
        RepositoryConfigEntity redis = repository.getRepositoryConfigEntityByRepositoryTypeEquals(RepositoryType.REDIS);

        Config config = new Config();
        config.useSingleServer()
                .setAddress(redis.getHost())
                .setUsername(redis.getUsername())
                .setPassword(redis.getPassword())
        ;
        return Redisson.create(config);
    }

    @Bean
    protected CacheManager cacheManager(
            RedissonClient redissonClient
    ) {
        return new RedissonSpringCacheManager(redissonClient);
    }
}
