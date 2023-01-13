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
    @Transactional
    public void save() {
        Neo4jAuthentication authentication = new Neo4jAuthentication();
        authentication.setUsername("------");
        neo4jAuthenticationRepository.save(authentication);
        neo4jAuthenticationRepository.save(new Neo4jAuthentication());
        log.info("{}", authentication);
        Neo4jAuthentication neo4jAuthentication = new Neo4jAuthentication();
        neo4jAuthenticationRepository.findAll();
        neo4jAuthentication.setPassword("cglnZ25hsEMiI6_NXcbwMN5ZzALTcoMpkk2K5uhZ1Yw");
        neo4jAuthentication.setUsername("neo4j");
        neo4jAuthentication.setUri("neo4j+s://8b0b1ed3.databases.neo4j.io");
        neo4jAuthenticationRepository.save(neo4jAuthentication);
//        userRepository.save(new User());
//        throw new RuntimeException();
    }
}
