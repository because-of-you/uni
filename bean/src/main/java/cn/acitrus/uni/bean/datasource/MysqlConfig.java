package cn.acitrus.uni.bean.datasource;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.mysql.cj.util.StringUtils;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/10
 **/
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Data
@Slf4j
public class MysqlConfig {
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

    @Bean(name = {"hikariConfig"})
    protected HikariConfig hikariConfig() {
        log.info("-------------------------------------------");
        log.info("username:{}|------", username);
        log.info("password:{}|------", password);
        log.info("host:{}|------", host);
        log.info("port:{}|------", port);
        log.info("-------------------------------------------");
        HikariConfig uniDataSourceConfig = new HikariConfig();

        // 自动提交从池中返回的连接
        uniDataSourceConfig.setAutoCommit(true);

        // 等待来自池的连接的最大毫秒数
        uniDataSourceConfig.setConnectionTimeout(TimeUnit.SECONDS.toMillis(30));

        // 连接允许在池中闲置的最长时间
        uniDataSourceConfig.setIdleTimeout(TimeUnit.MINUTES.toMillis(10));

        // 池中连接最长生命周期
        uniDataSourceConfig.setMaxLifetime(TimeUnit.MINUTES.toMillis(30));

        // 池中维护的最小最大空闲连接数
        uniDataSourceConfig.setMinimumIdle(3);
        uniDataSourceConfig.setMaximumPoolSize(100);

        // 连接池的用户定义名称，主要出现在日志记录和JMX管理控制台中以识别池和池配置
        uniDataSourceConfig.setPoolName("uni-data-source-thread");

        uniDataSourceConfig.setUsername(username);
        uniDataSourceConfig.setPassword(password);
        uniDataSourceConfig.setJdbcUrl(String.format("jdbc:mysql://%s:%s/uni" +
                "?useUnicode=true" +
                "&characterEncoding=UTF-8" +
                "&autoReconnect=true" +
                "&autoReconnectForPools=true" +
                "&createDatabaseIfNotExist=true", host, port));
        if (!StringUtils.isNullOrEmpty(url)) {
            uniDataSourceConfig.setJdbcUrl(url);
        }

        return uniDataSourceConfig;
    }

    @Bean(name = {"dataSource"}, destroyMethod = "close")
    protected HikariDataSource dataSource(
            @Qualifier("hikariConfig") HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }
}
