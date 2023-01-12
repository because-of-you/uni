package cn.acitrus.uni.datasource.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/10
 **/
@Configuration
@EnableTransactionManagement
public class UniDataSource {
    @Bean(name = {"hikariConfig"})
    protected HikariConfig hikariConfig() {
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
        uniDataSourceConfig.setMaximumPoolSize(10);

        // 连接池的用户定义名称，主要出现在日志记录和JMX管理控制台中以识别池和池配置
        uniDataSourceConfig.setPoolName("uni-data-source-thread");

        uniDataSourceConfig.setUsername("root");
        uniDataSourceConfig.setPassword("wfy");
        uniDataSourceConfig.setJdbcUrl("jdbc:mysql://localhost:3306/uni" +
                "?useUnicode=true" +
                "&characterEncoding=UTF-8" +
                "&autoReconnect=true" +
                "&autoReconnectForPools=true");

        return uniDataSourceConfig;
    }

    @Bean(name = {"dataSource"}, destroyMethod = "close")
    protected HikariDataSource dataSource(
            @Qualifier("hikariConfig") HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager transactionManager(
            HikariDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new JpaTransactionManager();
//    }
}
