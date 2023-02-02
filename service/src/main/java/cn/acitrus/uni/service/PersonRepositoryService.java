package cn.acitrus.uni.service;

import cn.acitrus.uni.common.entities.Person;
import cn.acitrus.uni.common.nodes.Node;
import cn.acitrus.uni.repository.entities.PersonRepository;
import cn.acitrus.uni.repository.nodes.NodeRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
@Service
public class PersonRepositoryService {
    @Resource
    PersonRepository personRepository;
    @Resource
    NodeRepository nodeRepository;

    @Transactional(timeout = 10, rollbackFor = {Exception.class})
    public void test() {
        Person person = new Person();
        personRepository.deleteAll();
        personRepository.save(person);
        nodeRepository.deleteAll();
        Node node = new Node();
        nodeRepository.save(node);
        System.out.println(node);
    }
}