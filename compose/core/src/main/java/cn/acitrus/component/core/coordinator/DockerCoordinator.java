package cn.acitrus.component.core.coordinator;

import cn.acitrus.component.core.collector.RepositoryCollector;
import cn.acitrus.component.protocol.EventCoordinator;
import cn.acitrus.component.protocol.common.ComposeEvent;
import cn.acitrus.component.protocol.common.EventFactory;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import static cn.acitrus.component.protocol.common.ComponentLabel.Docker;
import static cn.acitrus.component.protocol.common.ComposeEventAction.COLLECT_FINISHED;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/7/15
 **/
@Component
public class DockerCoordinator implements EventCoordinator {
    @Resource
    RepositoryCollector repositoryCollector;

    @Override
    public ComposeEvent<?> coordinate(ComposeEvent<?> event) {
        repositoryCollector.collect(event);
        return EventFactory.createByAction(COLLECT_FINISHED);
    }

    @Override
    public boolean accept(ComposeEvent<?> event) {
        return ObjectUtils.nullSafeEquals(event.getMeta().getComponentName(), Docker);
    }
}
