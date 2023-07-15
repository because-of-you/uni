package cn.acitrus.component.protocol.common.body;

import cn.acitrus.component.protocol.common.ComposeEventBody;
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
public class ListContainersBody implements ComposeEventBody {
    private String name;
}
