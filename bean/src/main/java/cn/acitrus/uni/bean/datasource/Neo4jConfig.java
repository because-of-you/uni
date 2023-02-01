package cn.acitrus.uni.bean.datasource;

import cn.acitrus.uni.common.entities.config.RepositoryConfigEntity;
import cn.acitrus.uni.common.enums.repository.RepositoryType;
import cn.acitrus.uni.repository.RepositoryConfigEntityRepository;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.net.URI;
import java.time.Duration;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
@Configuration
public class Neo4jConfig {
    @Bean
    @Primary
    @SneakyThrows
    Neo4jProperties neo4jProperties(
            RepositoryConfigEntityRepository repository
    ) {
        RepositoryConfigEntity entity = repository.getRepositoryConfigEntityByRepositoryTypeEquals(RepositoryType.NEO4J);
        Neo4jProperties neo4jProperties = new Neo4jProperties();
        neo4jProperties.getPool().setMetricsEnabled(false);
        neo4jProperties.getPool().setIdleTimeBeforeConnectionTest(Duration.ofMinutes(30));
        neo4jProperties.setUri(new URI(entity.getHost()));
        neo4jProperties.getAuthentication().setPassword(entity.getPassword());
        neo4jProperties.getAuthentication().setUsername(entity.getUsername());
        return neo4jProperties;
    }

//    @Bean
//    ReactiveNeo4jTransactionManager reactiveTransactionManager(Driver driver,
//                                                               ReactiveDatabaseSelectionProvider databaseSelectionProvider) {
//        return new ReactiveNeo4jTransactionManager(driver, databaseSelectionProvider);
//    }
}
