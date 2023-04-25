package cn.acitrus.socket;

import cn.acitrus.repository.RepositoryConfigEntityRepository;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/3
 **/
@Configuration
public class WebSocketConfig {
    @Resource
    RepositoryConfigEntityRepository repositoryConfigEntityRepository;

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        System.out.println(repositoryConfigEntityRepository.findAll());
        return new ServerEndpointExporter();
    }
}
