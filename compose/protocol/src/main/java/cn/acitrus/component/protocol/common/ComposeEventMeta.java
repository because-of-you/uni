package cn.acitrus.component.protocol.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/7/15
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComposeEventMeta {
    private ComposeEventAction action;
}
