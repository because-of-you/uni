package cn.acitrus.uni.repository;

import cn.acitrus.uni.common.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
public interface PersonRepository extends JpaRepository<Person, UUID>, JpaSpecificationExecutor<Person> {
}