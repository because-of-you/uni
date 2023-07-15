package cn.acitrus.component.protocol;

import cn.acitrus.component.protocol.common.ComposeEvent;

/**
 * 分发器 -> 协调器 -> {采集器｜执行器}
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/7/15
 **/
public interface EventCoordinator {
    ComposeEvent<?> coordinate(ComposeEvent<?> event);

    boolean accept(ComposeEvent<?> event);
}
