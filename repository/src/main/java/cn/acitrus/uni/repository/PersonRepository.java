package cn.acitrus.uni.repository;

import cn.acitrus.uni.common.entities.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
public interface PersonRepository extends JpaRepository<Person, UUID>, JpaSpecificationExecutor<Person> {
    List<Person> findAllByCreateByIsNotNullAndCreateByEqualsOrCreateByLike(String createBy, String like);

    @Query("select u from #{#entityName} u where u.createBy=?#{[0]}")
    @Cacheable(value = "uni:cache:permissions", key = "#createBy")
    List<Person> costumList(String createBy);
}