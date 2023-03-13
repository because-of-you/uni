package cn.acitrus.uni.controller;


import cn.acitrus.uni.common.annotation.Test;
import cn.acitrus.uni.common.entities.Person;
import cn.acitrus.uni.common.nodes.Node;
import cn.acitrus.uni.repository.entities.PersonRepository;
import cn.acitrus.uni.repository.nodes.NodeRepository;
import cn.acitrus.uni.service.PersonRepositoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
@RestController
@Slf4j
@RequestMapping("api")
public class PersonController {
    final
    PersonRepositoryService personRepositoryService;
    final
    PersonRepository personRepository;
    private final NodeRepository nodeRepository;
    private final HttpServletRequest request;
    @Autowired
    ObjectMapper objectMapper;

    public PersonController(PersonRepositoryService personRepositoryService,
                            PersonRepository personRepository,
                            NodeRepository nodeRepository,
                            HttpServletRequest request) {
        this.personRepositoryService = personRepositoryService;
        this.personRepository = personRepository;
        this.nodeRepository = nodeRepository;
        this.request = request;
    }

    @GetMapping("test")
    @ResponseBody
    public void add() {
        personRepositoryService.test();
    }

    @GetMapping("list")
    @ResponseBody
    public List<Person> list(@RequestParam String test) {
        return personRepository.costumList(test);
    }

    @GetMapping("nodes")
    @ResponseBody
    public List<Node> nodes() {
        return nodeRepository.findAll();
    }

    @GetMapping("yace")
    @SneakyThrows
    public Mono<Person> testCon(String name) {
        Person person = new Person();
        person.setName(null);
        log.info("请求体 -> {}", objectMapper.writeValueAsString(request));
        return Mono.just(person);
    }
}
