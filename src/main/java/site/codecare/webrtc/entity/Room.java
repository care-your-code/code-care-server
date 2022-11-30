package site.codecare.webrtc.entity;

import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Room {

    private final String name;

    private final Map<String, WebSocketSession> clients = new HashMap<>();


    public Room(String name) {
        this.name = name;
    }
}
