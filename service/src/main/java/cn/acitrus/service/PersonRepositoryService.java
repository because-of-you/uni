package cn.acitrus.service;

import cn.acitrus.repositorys.RepositoryConfigEntityRepository;

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
    RepositoryConfigEntityRepository repositoryConfigEntityRepository;

    @Transactional(timeout = 10, rollbackFor = {Exception.class})
    public void test() {
//        Person person = new Person();
//        personRepository.deleteAll();
//        personRepository.save(person);
//        nodeRepository.deleteAll();
//        Node node = new Node();
//        nodeRepository.save(node);
//        System.out.println(node);
    }
}