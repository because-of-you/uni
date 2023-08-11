package cn.acitrus.web.connertor;

import cn.acitrus.service.connector.ConnectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/28
 **/
@RestController
@RequestMapping(
        path = "/api/connector",
        headers = {},
        method = {GET, POST, PUT, DELETE}
)
@RequiredArgsConstructor
public class ConnectorController {

    private final ConnectorService connectorService;

    @GetMapping
    public Map<String, List<Map<String, Object>>> get(
            @RequestParam(required = false, name = "page") Integer page,
            @RequestParam(required = false, name = "page_size", defaultValue = "100") Integer pageSize,
            @RequestParam(required = false, name = "end_page") Integer endPage,
            @RequestParam(required = false, name = "data_path", defaultValue = "data") String dataPath) {


        if (null != page && Objects.equals(page, endPage)) {
            return Map.of(dataPath, new ArrayList<>());
        }


        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < pageSize; i++) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("data_string", "字符串文本");
            map.put("data_int", 111);
            map.put("data_int_quote", "111");
            map.put("data_double", 111.111);
            map.put("data_double_quote", "111.111");
            map.put("data_date", "2023-08-11");
            map.put("data_timestamp", "2023-08-11 12:00:00");
            list.add(map);
        }

        return Map.of(dataPath, list);
    }
}
