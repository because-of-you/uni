package cn.acitrus.uni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.config.EnableReactiveNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangfeiyu
 */
@EnableJpaRepositories
@EnableReactiveNeo4jRepositories
@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UniServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniServerApplication.class, args);
    }

}
