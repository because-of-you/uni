package cn.acitrus.uni.repository.entities;

import cn.acitrus.uni.common.entities.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
@Repository
public interface PersonRepository extends JpaRepository<Person, UUID>, JpaSpecificationExecutor<Person> {
    List<Person> findAllByCreateByIsNotNullAndCreateByEqualsOrCreateByLike(String createBy, String like);

    @Query("select u from #{#entityName} u where u.createBy = :#{#createBy}")
    @Cacheable(value = "uni:cache:permissions", key = "#createBy")
    List<Person> costumList(@Param("createBy") String createBy);
}