package cn.acitrus.connectors.mysql;

import com.mysql.cj.util.StringUtils;
import com.zaxxer.hikari.HikariConfig;

import java.util.concurrent.TimeUnit;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/24
 **/
public class MysqlDataSourceConfig extends HikariConfig {
    public MysqlDataSourceConfig(MysqlProperties properties) {
        // 自动提交从池中返回的连接
        super.setAutoCommit(true);

        // 等待来自池的连接的最大毫秒数
        super.setConnectionTimeout(TimeUnit.SECONDS.toMillis(30));

        // 连接允许在池中闲置的最长时间
        super.setIdleTimeout(TimeUnit.MINUTES.toMillis(10));

        // 池中连接最长生命周期
        super.setMaxLifetime(TimeUnit.MINUTES.toMillis(30));

        // 池中维护的最小最大空闲连接数
        super.setMinimumIdle(3);
        super.setMaximumPoolSize(100);

        // 连接池的用户定义名称，主要出现在日志记录和JMX管理控制台中以识别池和池配置
        super.setPoolName("A-CITRUS-|0.0|->");

        super.setUsername(properties.getUsername());
        super.setPassword(properties.getPassword());
        super.setJdbcUrl(String.format("jdbc:mysql://%s:%s/uni" +
                "?useUnicode=true" +
                "&characterEncoding=UTF-8" +
                "&autoReconnect=true" +
                "&autoReconnectForPools=true" +
                "&createDatabaseIfNotExist=true", properties.getHost(), properties.getPort()));
        if (!StringUtils.isNullOrEmpty(properties.getUrl())) {
            super.setJdbcUrl(properties.getUrl());
        }
    }
}
