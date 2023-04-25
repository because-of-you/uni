package cn.acitrus;

import cn.acitrus.repository.RepositoryConfigEntityRepository;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author wangfeiyu
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UniServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniServerApplication.class, args);
    }

}
