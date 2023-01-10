package cn.acitrus.uni.dao;


import cn.acitrus.uni.UniServerApplicationTests;
import cn.acitrus.uni.model.User;
import cn.acitrus.uni.neo4j.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
class UserRepositoryTest extends UniServerApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    public void addUser() {
        userRepository.deleteAll();
        User A = new User();
        A.setName("A");
        userRepository.save(A);
    }

    @Test
    public void listUser() {
        log.info("展示用户 -> {}", userRepository.findAll());
    }
}