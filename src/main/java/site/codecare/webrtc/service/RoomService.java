package site.codecare.webrtc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;
import site.codecare.webrtc.entity.Room;

import javax.annotation.Resource;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomService {

    @Cacheable(cacheNames = "webrtcRoom", key = "#name")
    public Optional<Room> findRoomByName(String name){
          log.info("해당 room name은 cache에 존재하지 않습니다.");
//        throw new RuntimeException("no room");
        return Optional.empty();
    }

    @CachePut(cacheNames = "webrtcRoom", key = "#name")
    public Room saveRoom(String name) {
        // 중복된 이름 방 체크
        Optional<Room> findRoom = ((RoomService) AopContext.currentProxy()).findRoomByName(name);
        if(findRoom.isPresent()) throw new RuntimeException("이미 존재하는 방 이름입니다.");

        // 방 생성
        Room saveRoom = new Room(name);
        return saveRoom;
    }

    @CachePut(cacheNames = "webrtcRoom", key = "#name")
    public Room addClient(String name, String email, WebSocketSession session) {
        log.info(name);
        // 이름에 맞는 방 찾음
        Room findRoom = ((RoomService) AopContext.currentProxy()).findRoomByName(name)
                .orElseThrow(() -> new RuntimeException("방이 존재하지 않습니다."));

        // 방에 client 정보 추가
        findRoom.getClients().put(email, session);

        return findRoom;
    }
}
