package cn.acitrus.uni.service;

import cn.acitrus.uni.common.entities.Person;
import cn.acitrus.uni.common.nodes.Node;
import cn.acitrus.uni.repository.NodeRepository;
import cn.acitrus.uni.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
@Service
public class PersonRepositoryService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    NodeRepository nodeRepository;

    @Transactional(timeout = 10, rollbackFor = {Exception.class})
    public void test() {
        personRepository.save(new Person());
        nodeRepository.save(new Node());
    }
}