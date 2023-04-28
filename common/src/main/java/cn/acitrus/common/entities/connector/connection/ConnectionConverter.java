package cn.acitrus.common.entities.connector.connection;

import cn.acitrus.common.UniJsonUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ConnectionConverter implements AttributeConverter<Connection, String> {

    @Override
    public String convertToDatabaseColumn(Connection connection) {
        return UniJsonUtil.toJson(connection);
    }

    @Override
    public Connection convertToEntityAttribute(String connection) {
        DefaultConnection defaultConnection = UniJsonUtil.convert(connection, DefaultConnection.class);
        return UniJsonUtil.convert(connection, defaultConnection.getConnectorType().getType());
    }
}
