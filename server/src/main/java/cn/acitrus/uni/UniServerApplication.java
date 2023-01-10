package cn.acitrus.uni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * @author wangfeiyu
 */
@EnableNeo4jRepositories
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class UniServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniServerApplication.class, args);
    }

}
