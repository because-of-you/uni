package cn.acitrus.web.socket;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static jakarta.websocket.CloseReason.CloseCodes.TRY_AGAIN_LATER;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/7/5
 **/
@Slf4j
@ServerEndpoint(value = "/compose/{token}")
@Component
public class ComposeEventSocket {
    private static final String path = "token";
    Map<String, Session> sessions = new ConcurrentHashMap<>();


    @SneakyThrows
    @OnOpen
    public void onOpen(Session session, @PathParam(path) String token) {
        if (ObjectUtils.isEmpty(token)) {
            session.getAsyncRemote().sendText("token 不能为空 such as: compose/0000-0000-");
            session.close(new CloseReason(TRY_AGAIN_LATER, "token 不能为空 such as: compose/0000-0000-"));
            return;
        }
        log.info("接收到消息");
        sessions.put(token, session);
    }

    @OnClose
    public void onClose(Session session, @PathParam(path) String token) {

    }

    @OnError
    public void onError(Session session, @PathParam(path) String token, Throwable throwable) {
    }

    @OnMessage
    public void onMessage(Session session, String message, @PathParam(path) String token) {
        log.info("接受消息:{}", message);
        session.getAsyncRemote().sendText("收到收到！");
    }

}
