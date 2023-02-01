package cn.acitrus.uni.bean.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/2/1
 **/
@Slf4j
@Configuration
public class ThreadPoolConfig {
    @Bean(name = "commonThreadPoolExecutor", destroyMethod = "shutdown")
    ThreadPoolExecutor commonThreadPoolExecutor() {
        return new ThreadPoolExecutor(
                // 线程池的核心线程数量
                Runtime.getRuntime().availableProcessors() + 1,
                //线程池的最大线程数
                Runtime.getRuntime().availableProcessors() * 2 + 1,
                //当线程数大于核心线程数时，多余的空闲线程存活的最长时间
                30,
                //时间单位
                TimeUnit.SECONDS,
                //任务队列，用来储存等待执行任务的队列
                new ArrayBlockingQueue<>(10),
                //线程工厂，用来创建线程，一般默认即可
                Executors.defaultThreadFactory(),
                //拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

    @Bean(name = "otherThreadPoolExecutor", destroyMethod = "shutdown")
    ThreadPoolExecutor otherThreadPoolExecutor() {
        return new ThreadPoolExecutor(
                // 线程池的核心线程数量
                Runtime.getRuntime().availableProcessors() + 1,
                //线程池的最大线程数
                Runtime.getRuntime().availableProcessors() * 2 + 1,
                //当线程数大于核心线程数时，多余的空闲线程存活的最长时间
                30,
                //时间单位
                TimeUnit.SECONDS,
                //任务队列，用来储存等待执行任务的队列
                new ArrayBlockingQueue<>(10),
                //线程工厂，用来创建线程，一般默认即可
                Executors.defaultThreadFactory(),
                //拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
