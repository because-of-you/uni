package cn.acitrus.connectors.mysql;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/24
 **/
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class MysqlProperties {
    @JsonSetter(nulls = Nulls.SKIP)
    private String url;
    @JsonSetter(nulls = Nulls.SKIP)
    private String host = System.getenv("DATASOURCE_HOST");
    @JsonSetter(nulls = Nulls.SKIP)
    private String port = System.getenv("DATASOURCE_PORT");
    @JsonSetter(nulls = Nulls.SKIP)
    private String username = System.getenv("DATASOURCE_USER");
    @JsonSetter(nulls = Nulls.SKIP)
    private String password = System.getenv("DATASOURCE_PASSWORD");
}
