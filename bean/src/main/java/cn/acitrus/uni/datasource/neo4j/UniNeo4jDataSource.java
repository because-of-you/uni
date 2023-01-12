package cn.acitrus.uni.datasource.neo4j;

import cn.acitrus.uni.entity.Neo4jAuthentication;
import cn.acitrus.uni.mysql.Neo4jAuthenticationRepository;
import lombok.SneakyThrows;
import org.neo4j.driver.Driver;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.neo4j.ConfigBuilderCustomizer;
import org.springframework.boot.autoconfigure.neo4j.Neo4jAutoConfiguration;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.core.transaction.ReactiveNeo4jTransactionManager;
import org.springframework.data.neo4j.repository.config.ReactiveNeo4jRepositoryConfigurationExtension;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.URI;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/12
 **/
@EnableTransactionManagement
@Configuration
public class UniNeo4jDataSource extends Neo4jAutoConfiguration {
    final Neo4jAuthenticationRepository neo4jAuthenticationRepository;
    private Neo4jAuthentication neo4jAuthentication;

    public UniNeo4jDataSource(Neo4jAuthenticationRepository neo4jAuthenticationRepository) {
        this.neo4jAuthenticationRepository = neo4jAuthenticationRepository;
//        neo4jAuthenticationRepository.save(new Neo4jAuthentication());
        Iterable<Neo4jAuthentication> all = neo4jAuthenticationRepository.findAll();
        for (Neo4jAuthentication neo4jAuthentication : all) {
            this.neo4jAuthentication = neo4jAuthentication;
        }
    }

    @SneakyThrows
    @Bean
    public Driver neo4jDriver(
            Neo4jProperties properties,
            Environment environment,
            ObjectProvider<ConfigBuilderCustomizer> configBuilderCustomizers) {
        UniNeo4jDataSourceConfig config = new UniNeo4jDataSourceConfig();
        config.setAuthentication(neo4jAuthentication);
        config.setUri(new URI(neo4jAuthentication.getUri()));
        neo4jAuthenticationRepository.save(new Neo4jAuthentication());
        return super.neo4jDriver(config, environment, configBuilderCustomizers);
    }

    @Bean(name = ReactiveNeo4jRepositoryConfigurationExtension.DEFAULT_TRANSACTION_MANAGER_BEAN_NAME)
    public ReactiveNeo4jTransactionManager reactiveTransactionManager(
            Driver driver) {
        return new ReactiveNeo4jTransactionManager(driver);
    }
}
