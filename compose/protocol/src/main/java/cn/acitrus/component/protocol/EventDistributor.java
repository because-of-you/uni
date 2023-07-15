package cn.acitrus.component.protocol;

import cn.acitrus.component.protocol.common.ComposeEvent;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/6/22
 **/
public interface EventDistributor {
    /**
     * 事件分发器 事件只能被一个协调器消费
     *
     * @param eventStream 事件信息
     * @return 编排事件
     */
    ComposeEvent<?> distribute(String eventStream);
}
