package cn.acitrus.component.component;

import cn.acitrus.component.protocol.EventCollector;
import cn.acitrus.component.protocol.common.ComposeEvent;
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
    public void collect(ComposeEvent event) {
        // 内部事件采集器实现
    }
}