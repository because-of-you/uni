package cn.acitrus;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/24
 **/
@EnableJpaRepositories(basePackages = "cn.acitrus")
@ComponentScan(basePackages = {"cn.acitrus"})
public class Config {
}
