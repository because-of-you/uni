package cn.acitrus.component.protocol.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/7/15
 **/
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ComposeEventMeta {
    private ComposeEventAction action;
    private ComponentLabel componentName;
}
