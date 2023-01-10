package cn.acitrus.uni.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/10
 **/
@Component
@Slf4j
public class UniThreadPool {
    final ThreadPoolExecutor commonThreadPoolExecutor;
    final ThreadPoolExecutor otherThreadPoolExecutor;

    public UniThreadPool(
            ThreadPoolExecutor commonThreadPoolExecutor,
            ThreadPoolExecutor otherThreadPoolExecutor) {
        this.commonThreadPoolExecutor = commonThreadPoolExecutor;
        this.otherThreadPoolExecutor = otherThreadPoolExecutor;
    }

}
