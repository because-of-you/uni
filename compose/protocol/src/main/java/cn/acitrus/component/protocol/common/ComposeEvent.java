package cn.acitrus.component.protocol.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/7/15
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComposeEvent<T extends ComposeEventBody> {
    private ComposeEventHeader header;
    private ComposeEventMeta meta;
    private T body;
}

