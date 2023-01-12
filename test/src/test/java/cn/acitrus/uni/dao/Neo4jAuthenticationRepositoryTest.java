package cn.acitrus.uni.dao;

import cn.acitrus.uni.UniServerApplicationTests;
import cn.acitrus.uni.entity.Neo4jAuthentication;
import cn.acitrus.uni.mysql.Neo4jAuthenticationRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/12
 **/
@Slf4j
public class Neo4jAuthenticationRepositoryTest extends UniServerApplicationTests {
    @Autowired
    Neo4jAuthenticationRepository neo4jAuthenticationRepository;

    @Test
    @Transactional(value = "transactionManager")
    public void save() {
        Neo4jAuthentication neo4jAuthentication = new Neo4jAuthentication();
        neo4jAuthenticationRepository.deleteAll();
        neo4jAuthentication.setPassword("neo4j");
        neo4jAuthentication.setUsername("neo4j");
        neo4jAuthentication.setUri("neo4j+s://localhost");
        neo4jAuthenticationRepository.save(neo4jAuthentication);
        System.out.println("------------");
    }
}
