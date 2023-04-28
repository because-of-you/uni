package cn.acitrus.transfer.mapper.config;

import cn.acitrus.common.entities.config.ConnectorEntity;
import cn.acitrus.transfer.object.config.ConnectorEntityDto;
import cn.acitrus.transfer.projection.config.ConnectorEntityInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConnectorEntityMapper {
    ConnectorEntity toEntity(ConnectorEntityDto connectorEntityDto);

    ConnectorEntityDto toDto(ConnectorEntity connectorEntity);

    ConnectorEntityDto infoToDto(ConnectorEntityInfo connectorEntityInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ConnectorEntity partialUpdate(ConnectorEntityDto connectorEntityDto, @MappingTarget ConnectorEntity connectorEntity);

    ConnectorEntity toEntity1(ConnectorEntityDto connectorEntityDto);
}