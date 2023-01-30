package cn.acitrus.uni.controller;

import cn.acitrus.uni.common.entities.Person;
import cn.acitrus.uni.repository.PersonRepository;
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

    public PersonController(PersonRepositoryService personRepositoryService,
                            PersonRepository personRepository) {
        this.personRepositoryService = personRepositoryService;
        this.personRepository = personRepository;
    }

    @GetMapping("test")
    public void add() {
        personRepositoryService.test();
    }

    @GetMapping("list")
    public List<Person> list(@RequestParam String test) {
        return personRepository.costumList(test);
    }
}
