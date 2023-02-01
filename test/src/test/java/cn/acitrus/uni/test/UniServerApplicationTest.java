package cn.acitrus.uni.test;


import cn.acitrus.uni.UniServerApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/2/1
 **/
@Slf4j
@SpringBootTest(
        classes = {UniServerApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UniServerApplicationTest {
}
