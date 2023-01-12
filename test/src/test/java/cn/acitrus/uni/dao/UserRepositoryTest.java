package cn.acitrus.uni.dao;


import cn.acitrus.uni.UniServerApplicationTests;
import cn.acitrus.uni.entity.Neo4jAuthentication;
import cn.acitrus.uni.mysql.Neo4jAuthenticationRepository;
import cn.acitrus.uni.neo4j.UserRepository;
import cn.acitrus.uni.node.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
class UserRepositoryTest extends UniServerApplicationTests {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Neo4jAuthenticationRepository neo4jAuthenticationRepository;

    @Test
    public void addUser() {
        userRepository.deleteAll();
        User A = new User();
        A.setName("A");
        userRepository.save(A);
    }

    @Test
    public void listUser() {
        neo4jAuthenticationRepository.save(new Neo4jAuthentication());
        System.out.println(userRepository.findAll());
    }
}