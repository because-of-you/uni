package cn.acitrus.common.entities.base;

import com.github.f4b6a3.ulid.Ulid;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/16
 * <a href="https://github.com/f4b6a3/ulid-creator">该id的使用方法</a>
 **/
@Data
@NoArgsConstructor
public class UniIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Ulid ulid = Ulid.fast();
        return ulid.toUuid();
    }
}
