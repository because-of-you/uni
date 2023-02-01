package cn.acitrus.uni.test.common.edges;

import cn.acitrus.uni.test.UniServerApplicationTest;
import lombok.SneakyThrows;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

@Slf4j
class AbstractUniSimpleEdgeTest extends UniServerApplicationTest {

    @SneakyThrows
    @Synchronized
    public void print(){
        log.info("-------------------- 被锁的方法 -----------------");
        TimeUnit.SECONDS.sleep(4);
    }

    @Test
    @SneakyThrows
    public void t1(){
        new Thread(this::print).start();
        new Thread(this::print).start();
        new Thread(this::print).start();

        while (true){
            TimeUnit.SECONDS.sleep(5);
            log.info("=============================");
        }
    }
}