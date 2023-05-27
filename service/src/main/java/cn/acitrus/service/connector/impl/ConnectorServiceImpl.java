package cn.acitrus.service.connector.impl;

import cn.acitrus.repository.connectors.ConnectorEntityRepository;
import cn.acitrus.service.connector.ConnectorService;
import cn.acitrus.transfer.mapper.connector.ConnectorEntityMapper;
import cn.acitrus.transfer.object.connector.ConnectorEntityDto;
import cn.acitrus.transfer.projection.connector.ConnectorEntityInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/28
 **/
@Service
@RequiredArgsConstructor
public class ConnectorServiceImpl implements ConnectorService {
    private final ConnectorEntityRepository connectorEntityRepository;
    private final ConnectorEntityMapper connectorEntityMapper;

    @Override
    public List<ConnectorEntityDto> list() {
        List<ConnectorEntityInfo> list = connectorEntityRepository.findAllByConnectionIsNotNull();
        return list.stream().map(connectorEntityMapper::infoToDto).collect(Collectors.toList());
    }
}
