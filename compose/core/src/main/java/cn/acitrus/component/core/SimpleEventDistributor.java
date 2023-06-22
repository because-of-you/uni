package cn.acitrus.component.core;

import cn.acitrus.common.compose.Event;
import cn.acitrus.component.protocol.EventCollector;
import cn.acitrus.component.protocol.EventDistributor;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/6/22
 **/
@Component
public class SimpleEventDistributor implements EventDistributor {

    @Resource
    List<EventCollector> eventCollectors;

    @Override
    public void distribute() {
        for (EventCollector eventCollector : eventCollectors) {
            eventCollector.collect(new Event());
        }
    }
}
