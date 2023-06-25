package cn.acitrus.component.core;

import cn.acitrus.common.enums.TaskExecutorEnum;
import cn.acitrus.component.protocol.TaskExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/6/22
 **/
@Slf4j
public class TaskExecutorFactory {
    public static TaskExecutor createTaskExecutor(TaskExecutorEnum taskExecutorEnum) {
        switch (taskExecutorEnum) {
            case FILE_OPERATOR:
            default:
                return () -> {
                    log.warn("传递的操作类型是: {} 没有默认实现", taskExecutorEnum);
                };
        }
    }
}
