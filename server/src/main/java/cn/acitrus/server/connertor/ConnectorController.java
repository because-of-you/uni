package cn.acitrus.server.connertor;

import cn.acitrus.service.connector.ConnectorService;
import cn.acitrus.transfer.object.connector.ConnectorEntityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/28
 **/
@RestController
@RequestMapping(
        path = "connector",
        headers = {},
        method = {GET, POST, PUT, DELETE}
)
@RequiredArgsConstructor
public class ConnectorController {

    private final ConnectorService connectorService;

    @GetMapping
    public List<ConnectorEntityDto> get() {
        return connectorService.list();
    }
}
