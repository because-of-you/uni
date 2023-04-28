package cn.acitrus.service.config;


import cn.acitrus.transfer.object.config.ConnectorEntityDto;

import java.util.List;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/28
 **/
public interface ConnectorService {
    List<ConnectorEntityDto> list();
}
