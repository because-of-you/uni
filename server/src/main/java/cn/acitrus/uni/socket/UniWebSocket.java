package cn.acitrus.uni.socket;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/3
 **/
@ServerEndpoint(value = "/ws")
@Component
public class UniWebSocket {
    Map<String, Session> sessions = new ConcurrentHashMap<>();

    @Autowired
    DataSource dataSource;

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        sessions.put("username", session);
    }

    @OnClose
    public void onClose(Session session, @PathParam("username") String username) {
        sessions.remove(username);
        broadcast("User " + username + " left");
    }

    @OnError
    public void onError(Session session, @PathParam("username") String username, Throwable throwable) {
        sessions.remove(username);
        broadcast("User " + username + " left on error: " + throwable);
    }

    @OnMessage
    public void onbin(byte[] messages, Session session) {
        System.out.println(messages);
    }

    @OnMessage
    public void onMessage(Session session, String message, @PathParam("username") String username) {
        if (message.equalsIgnoreCase("_ready_")) {
            broadcast("User " + username + " joined");
        } else {
            broadcast(">> " + username + ": " + message);
        }
    }

    @SneakyThrows
    private void broadcast(String message) {
        sessions.values().forEach(s -> {
            s.getAsyncRemote().sendObject(message, result -> {
                if (result.getException() != null) {
                    System.out.println("Unable to send message: " + result.getException());
                }
            });

            //发送字符串信息的 byte数组
            ByteBuffer bf = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));
            s.getAsyncRemote().sendBinary(bf);
        });
    }
}
