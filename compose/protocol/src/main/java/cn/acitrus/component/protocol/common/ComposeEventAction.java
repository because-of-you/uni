package cn.acitrus.component.protocol.common;

import cn.acitrus.component.protocol.common.body.CollectFinishedBody;
import cn.acitrus.component.protocol.common.body.ListContainersBody;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/7/15
 **/
@AllArgsConstructor
@Getter
public enum ComposeEventAction {
    DEFAULT(ListContainersBody.class),
    LIST_CONTAINERS(ListContainersBody.class),
    COLLECT_FINISHED(CollectFinishedBody.class),
    ;
    private final Class<? extends ComposeEventBody> actionPolicy;

    public boolean isCollectionEvent() {
        switch (this) {
            case LIST_CONTAINERS, DEFAULT -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public boolean isExecuteEvent() {
        return !isCollectionEvent();
    }
}
