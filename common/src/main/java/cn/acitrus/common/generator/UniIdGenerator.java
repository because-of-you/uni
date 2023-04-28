package cn.acitrus.common.generator;

import com.github.f4b6a3.ulid.Ulid;
import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.data.neo4j.core.schema.IdGenerator;

import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/16
 * <a href="https://github.com/f4b6a3/ulid-creator">该id的使用方法</a>
 **/
@Data
@NoArgsConstructor
public class UniIdGenerator implements IdentifierGenerator, IdGenerator<UUID> {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Ulid ulid = Ulid.fast();
        return ulid.toUuid();
    }

    @Nonnull
    @Override
    public UUID generateId(@Nonnull String primaryLabel, @Nonnull Object entity) {
        return Ulid.fast().toUuid();
    }
}
