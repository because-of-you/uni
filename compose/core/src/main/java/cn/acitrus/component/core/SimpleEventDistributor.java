package cn.acitrus.component.core;

import cn.acitrus.component.protocol.EventCoordinator;
import cn.acitrus.component.protocol.EventDistributor;
import cn.acitrus.component.protocol.common.ComposeEvent;
import cn.acitrus.component.protocol.common.EventFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/6/22
 **/
@Component
public class SimpleEventDistributor implements EventDistributor {

    private final List<EventCoordinator> eventCoordinators;

    public SimpleEventDistributor(List<EventCoordinator> eventCoordinators) {
        this.eventCoordinators = eventCoordinators;
    }

    @Override
    public ComposeEvent<?> distribute(String eventStream) {
        ComposeEvent<?> event = EventFactory.from(eventStream);
        if (ObjectUtils.isEmpty(event) || ObjectUtils.isEmpty(event.getMeta())) {
            // TODO: 2023/7/15 处理异常
        }

        for (EventCoordinator coordinator : eventCoordinators) {
            // 如果协调器不能协调该事件
            if (!coordinator.coordinate(event)) {
                continue;
            }

            // 分发协调器采集模块
            if (event.getMeta().getAction().isCollectionEvent()) {
                coordinator.coordinateCollect(event);
                return null;
            }

            // 分发协调器执行模块
            if (event.getMeta().getAction().isExecuteEvent()) {
                return coordinator.coordinateExecute(event);
            }
        }
        return null;
    }
}
