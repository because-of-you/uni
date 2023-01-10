package cn.acitrus.uni;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = {UniServerApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UniServerApplicationTests {

    @Test
    void contextLoads() {
    }

}
