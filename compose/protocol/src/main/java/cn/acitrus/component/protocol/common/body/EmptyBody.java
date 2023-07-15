package cn.acitrus.component.protocol.common.body;

import cn.acitrus.component.protocol.common.ComposeEventBody;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/7/15
 **/
@NoArgsConstructor
@Data
public class EmptyBody implements ComposeEventBody {
    private String emptyField = "";
}
