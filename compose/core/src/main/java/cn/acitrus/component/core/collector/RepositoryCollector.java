package cn.acitrus.component.core.collector;


import cn.acitrus.component.protocol.EventCollector;
import cn.acitrus.component.protocol.common.ComposeEvent;
import org.springframework.stereotype.Component;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/7/15
 **/
@Component
public class RepositoryCollector implements EventCollector {
    @Override
    public void collect(ComposeEvent<?> event) {

    }
}
