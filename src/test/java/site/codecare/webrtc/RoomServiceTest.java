package site.codecare.webrtc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.webrtc.entity.Room;
import site.codecare.webrtc.service.RoomService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class RoomServiceTest {

    @Autowired
    RoomService roomService;

    @Test
    public void 과외방_생성_및_확인(){
        // Arrange
        String roomName = "교육 방1";
        Room room = new Room(roomName);

        // Act
        // save room
        roomService.saveRoom(roomName);

        // select room
        Room findRoom = roomService.findRoomByName(roomName).
                orElseThrow(() -> new RuntimeException("괴외방 생성 및 확인 error"));

        //Assert
        assertThat(findRoom)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(room);
    }
}
