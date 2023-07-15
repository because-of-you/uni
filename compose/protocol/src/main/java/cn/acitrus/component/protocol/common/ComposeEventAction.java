package cn.acitrus.component.protocol.common;

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
    ;
    private final Class<? extends ComposeEventBody> actionPolicy;
}
