package cn.acitrus.common.hash;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/30
 **/
@RedisHash
@Data
public class RedisEntity {
    @Id
    @Indexed
    private String id;
    private String name = " test ";
}
