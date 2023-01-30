package cn.acitrus.uni.service;

import cn.acitrus.uni.common.entities.Person;
import cn.acitrus.uni.common.nodes.Node;
import cn.acitrus.uni.repository.NodeRepository;
import cn.acitrus.uni.repository.PersonRepository;
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
        personRepository.save(new Person());
        nodeRepository.deleteAll();
        nodeRepository.save(new Node());
    }
}