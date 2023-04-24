package cn.acitrus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/2/21
 **/
@Slf4j
@RestController
public class LogController {
    @PostMapping("services/collector/event")
    public Mono<HashMap<Object, Object>> test(@RequestBody Map<String, Objects> map) {
        log.info("日志采集触发 -> {}", map);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", "Success");
        hashMap.put("code", 0);
        return Mono.just(hashMap);
    }

    @PostMapping("services/collector/event/1.0")
    public Mono<HashMap<Object, Object>> test1(@RequestBody Map<String, Objects> map) {
        log.info("日志采集触发 -> {}", map);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", "Success");
        hashMap.put("code", 0);
        return Mono.just(hashMap);
    }
}
