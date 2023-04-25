package cn.acitrus.connectors.mysql;

import cn.acitrus.connectors.Connector;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/24
 **/
@Slf4j
@Component
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class MysqlConnector implements Connector {
    private final MysqlProperties mysqlProperties;

    /**
     * 初始化mysql数据库连接(connector)的bean
     *
     * @return 数据库连接池对象
     */
    @Bean(name = {"dataSource"}, destroyMethod = "close")
    protected HikariDataSource dataSource() {
        MysqlDataSourceConfig dataSourceConfig = new MysqlDataSourceConfig(mysqlProperties);
        if (log.isDebugEnabled()) {
            log.debug("-------------------------------------------");
            log.debug("username:{}|------", mysqlProperties.getUsername());
            log.debug("password:{}|------", mysqlProperties.getPassword());
            log.debug("host:{}|------", mysqlProperties.getHost());
            log.debug("port:{}|------", mysqlProperties.getPort());
            log.debug("-------------------------------------------");
        }
        return new HikariDataSource(dataSourceConfig);
    }
}
