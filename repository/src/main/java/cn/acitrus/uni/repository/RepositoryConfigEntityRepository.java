package cn.acitrus.uni.repository;

import cn.acitrus.uni.common.entities.Person;
import cn.acitrus.uni.common.entities.repository.RepositoryConfigEntity;
import cn.acitrus.uni.common.enums.repository.RepositoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/29
 **/
public interface RepositoryConfigEntityRepository extends JpaRepository<RepositoryConfigEntity, UUID>, JpaSpecificationExecutor<Person> {
    /**
     * 查询数据库中存储的不通数据源的链接信息
     *
     * @param repositoryType 数据源类型
     * @return 数据源链接信息配置对象
     */
    RepositoryConfigEntity getRepositoryConfigEntityByRepositoryTypeEquals(RepositoryType repositoryType);
}
