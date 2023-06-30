package cn.acitrus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.neo4j.config.EnableNeo4jAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangfeiyu
 */
@EnableJpaAuditing
@EnableNeo4jAuditing
@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UniServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniServerApplication.class, args);
    }

}
