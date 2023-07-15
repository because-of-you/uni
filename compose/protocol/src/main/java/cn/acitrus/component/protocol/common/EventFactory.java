package cn.acitrus.component.protocol.common;

import cn.acitrus.common.UniJsonUtil;
import cn.acitrus.component.protocol.common.body.CollectFinishedBody;
import cn.acitrus.component.protocol.common.body.EmptyBody;
import cn.acitrus.component.protocol.common.body.ListContainersBody;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/7/15
 **/
public class EventFactory {
    public static ComposeEvent<?> from(String content) {
        ComposeEvent<EmptyBody> convert = UniJsonUtil.convert(content, new TypeReference<>() {
        });

        switch (convert.getMeta().getAction()) {
            case DEFAULT -> {
                return convert;
            }
            case LIST_CONTAINERS -> {
                return UniJsonUtil.convert(content, new TypeReference<ComposeEvent<ListContainersBody>>() {
                });
            }
            default -> throw new RuntimeException("不能找到对应的实现类");
        }

    }

    public static ComposeEvent<?> createByAction(ComposeEventAction eventAction) {
        switch (eventAction) {
            case COLLECT_FINISHED -> {
                ComposeEvent<CollectFinishedBody> event = new ComposeEvent<>();
                event.setMeta(new ComposeEventMeta(ComposeEventAction.COLLECT_FINISHED));
                event.setBody(new CollectFinishedBody());
                return event;
            }
            default -> {
                return new ComposeEvent<>();
            }
        }
    }
}
