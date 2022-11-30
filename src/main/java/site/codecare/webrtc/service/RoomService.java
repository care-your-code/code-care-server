package site.codecare.webrtc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import site.codecare.webrtc.entity.Room;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomService {
    private static final Room EMPTY_DATA = new Room("");

    @Cacheable(cacheNames = "webrtcRoom", key = "#name")
    public Optional<Room> findRoomByName(String name){
//        log.info("해당 room name은 cache에 존재하지 않습니다.");
//        throw new RuntimeException("no room");
        return Optional.empty();
    }

    @CachePut(cacheNames = "webrtcRoom", key = "#name")
    public Room saveRoom(String name) {
        // 중복된 이름 방 체크
        Optional<Room> room = findRoomByName(name);
        if(room.isPresent()) throw new RuntimeException("이미 존재하는 방 이름입니다.");

        // 방 생성
        Room saveRoom = new Room(name);
        return saveRoom;
    }
}
