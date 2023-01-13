package cn.acitrus.uni.datasource.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/10
 **/
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"cn.acitrus.uni.*"})
@Configuration
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

        uniDataSourceConfig.setAutoCommit(true);

        return uniDataSourceConfig;
    }

    @Bean(name = {"dataSource"}
//            , destroyMethod = "close"
    )
    protected DataSource dataSource(
            @Qualifier("hikariConfig") HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//            HikariDataSource dataSource) {
//
//        // Hibernate jpa 实现
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        vendorAdapter.setShowSql(true);
//
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//
//        // 使用Hibernate作为JPA实现
//        factory.setJpaVendorAdapter(vendorAdapter);
//
//        // 注入自定义的数据源
//        factory.setDataSource(dataSource);
//
//        // 自定义包
//        factory.setPackagesToScan("cn.acitrus.uni.*");
//
//        // 自定义jpa属性
//        factory.setJpaProperties(getUniJpaProperties());
//
//        factory.setJpaDialect(new HibernateJpaDialect());
//        return factory;
//    }
//
//    private Properties getUniJpaProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.format_sql", true);
//        properties.put("hibernate.ddl-auto", "update");
//        return properties;
//    }
//
//    @Bean(name = {"jpaTransactionManager"})
//    @Primary
//    public PlatformTransactionManager transactionManager(
//            HikariDataSource dataSource,
//            LocalContainerEntityManagerFactoryBean entityManagerFactory)
//    {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(entityManagerFactory.getObject());
//        txManager.afterPropertiesSet();
//        return txManager;
//    }
//
//
//    @Bean(name = {"transactionManager"})
//    @Primary
//    public PlatformTransactionManager dataSourceTransactionManager(HikariDataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
