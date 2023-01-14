package cn.acitrus.uni.service;

import cn.acitrus.uni.common.entities.Person;
import cn.acitrus.uni.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
@Service
public class PersonRepositoryService {
    @Autowired
    PersonRepository personRepository;
    public void test(){
        personRepository.save(new Person());
    }
}