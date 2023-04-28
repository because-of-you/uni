package cn.acitrus.common.entities.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/16
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractUniEntity extends AbstractUniSimpleEntity {
    @CreatedDate
    @Column(updatable = false, nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Comment("创建时间")
    public Date createdDate;

    @CreatedBy
    @Column(updatable = false, nullable = false)
    @Comment("创建人")
    @Builder.Default
    public String createBy = "";

    @LastModifiedDate
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @Comment("最新修改时间")
    public Date lastModifiedDate;

    @LastModifiedBy
    @Column(nullable = false)
    @Comment("最新修改人")
    @Builder.Default
    public String lastModifiedBy = "";

    @Version
    @Column(nullable = false)
    @Comment("版本号")
    public Integer version;
}
