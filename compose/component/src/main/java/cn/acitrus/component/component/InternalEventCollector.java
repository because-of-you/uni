package cn.acitrus.component.component;

import cn.acitrus.common.compose.Event;
import cn.acitrus.component.core.TaskExecutorFactory;
import cn.acitrus.component.protocol.EventCollector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/6/22
 **/
@Component(value = "InternalEventCollector")
@AllArgsConstructor
public class InternalEventCollector implements EventCollector {
    @Override
    public void collect(Event event) {
        // 内部事件采集器实现
    }
}