package cn.acitrus.uni;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(
        classes = {UniServerApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UniServerApplicationTests {

    @Test
    void contextLoads() {
    }

}
