package cn.acitrus;

import cn.acitrus.repositorys.RepositoryConfigEntityRepository;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author wangfeiyu
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class UniServerApplication {
    @Resource
    RepositoryConfigEntityRepository repositoryConfigEntityRepository;

    public static void main(String[] args) {
        SpringApplication.run(UniServerApplication.class, args);
    }

}
