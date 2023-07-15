package cn.acitrus.component.protocol;


import cn.acitrus.component.protocol.common.ComposeEvent;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/6/22
 **/
public interface EventCollector {
    /**
     * 事件采集器 所有实现了该接口的类都会接收到事件响应
     *
     * @param event 事件
     */
    void collect(ComposeEvent event);
}
