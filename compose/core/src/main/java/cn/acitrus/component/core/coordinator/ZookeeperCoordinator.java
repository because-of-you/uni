package cn.acitrus.component.core.coordinator;

import cn.acitrus.component.core.collector.RepositoryCollector;
import cn.acitrus.component.protocol.EventCoordinator;
import cn.acitrus.component.protocol.common.ComposeEvent;
import cn.acitrus.component.protocol.common.EventFactory;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import static cn.acitrus.component.protocol.common.ComponentLabel.Zookeeper;
import static cn.acitrus.component.protocol.common.ComposeEventAction.COLLECT_FINISHED;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/7/15
 **/
@Component
public class ZookeeperCoordinator implements EventCoordinator {

    @Override
    public ComposeEvent<?> coordinate(ComposeEvent<?> event) {
        // TODO: 2023/7/15 执行的逻辑
        return EventFactory.createByAction(COLLECT_FINISHED);
    }

    @Override
    public boolean accept(ComposeEvent<?> event) {
        return ObjectUtils.nullSafeEquals(event.getMeta().getComponentName(), Zookeeper);
    }
}
