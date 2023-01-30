package cn.acitrus.uni.controller;

import cn.acitrus.uni.common.entities.Person;
import cn.acitrus.uni.common.nodes.Node;
import cn.acitrus.uni.repository.entities.PersonRepository;
import cn.acitrus.uni.repository.nodes.NodeRepository;
import cn.acitrus.uni.service.PersonRepositoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
@RestController
public class PersonController {
    final
    PersonRepositoryService personRepositoryService;
    final
    PersonRepository personRepository;
    private final NodeRepository nodeRepository;

    public PersonController(PersonRepositoryService personRepositoryService,
                            PersonRepository personRepository,
                            NodeRepository nodeRepository) {
        this.personRepositoryService = personRepositoryService;
        this.personRepository = personRepository;
        this.nodeRepository = nodeRepository;
    }

    @GetMapping("test")
    public void add() {
        personRepositoryService.test();
    }

    @GetMapping("list")
    public List<Person> list(@RequestParam String test) {
        return personRepository.costumList(test);
    }

    @GetMapping("nodes")
    public List<Node> nodes(){
        return nodeRepository.findAll();
    }
}
