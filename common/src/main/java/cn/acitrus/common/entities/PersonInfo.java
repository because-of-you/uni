package cn.acitrus.common.entities;

import java.util.Date;
import java.util.UUID;

/**
 * A Projection for the {@link Person} entity
 */
public interface PersonInfo {
    UUID getId();

    Date getCreatedDate();

    String getCreateBy();

    Date getLastModifiedDate();

    String getLastModifiedBy();

    Integer getVersion();

    String getName();
}