package cn.acitrus.component.core.distributor;

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
        for (EventCoordinator coordinator : eventCoordinators) {
            // 如果协调器接收事件
            if (coordinator.accept(event)) {
                return coordinator.coordinate(event);
            }
        }
        return null;
    }
}
