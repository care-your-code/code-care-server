package site.codecare.webrtc;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.WebSocketSession;
import site.codecare.webrtc.entity.Room;
import site.codecare.webrtc.service.RoomService;

import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
@EnableAspectJAutoProxy(exposeProxy=true)
public class RoomServiceTest {

    @Autowired private RoomService roomService;

    private static String email;
    private static String roomName;
    private static WebSocketSession session;

    @BeforeAll
    public static void setup() {
        email = "test1@test.com";
        session = mock(WebSocketSession.class);
    }

    @Test
    public void 과외방_생성_및_확인(){
        // Arrange
        roomName = "교육 방1";
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

    @Test
    public void 과외방_중복_생성(){
        Assertions.assertThrows(
                // Assert
                RuntimeException.class,
                () -> {
                    // Arrange
                    roomName = "교육 방2";
                    Room room = new Room(roomName);

                    // Act
                    roomService.saveRoom(roomName);

                    roomService.saveRoom(roomName);
                });
    }


    @Test
    public void 과외방에_인원_추가_및_확인(){
        // Arrange
        roomName = "교육 방3";
        roomService.saveRoom(roomName);

        // Act
        // select room
        roomService.addClient(roomName, email, session);

        // select room
        Room findRoom = roomService.findRoomByName(roomName)
                .orElseThrow(() -> new RuntimeException("괴외방 추가 및 확인 error"));


        //Assert
        assertThat(findRoom)
                .isNotNull();
        assertThat(findRoom.getClients().get(email))
                .isSameAs(session);
    }

    @Test
    public void 과외방에_인원_나감_및_확인(){
        // Arrange
        roomName = "교육 방4";
        roomService.saveRoom(roomName);
        roomService.addClient(roomName, email, session);

        // Act
        roomService.removeClient(roomName, email);

        // select room
        Room findRoom = roomService.findRoomByName(roomName)
                .orElseThrow(() -> new RuntimeException("괴외방 나감 및 확인 error"));

        // Assert
        assertThat(findRoom)
                .isNotNull();
        assertThat(findRoom.getClients().get(email))
                .isNull();
    }

    @Test
    public void 과외방_제거_및_확인(){
        // Arrange
        roomName = "교육 방5";
        roomService.saveRoom(roomName);
        roomService.addClient(roomName, email, session);

        // Act
        roomService.removeRoom(roomName);

        Room findRoom = roomService.findRoomByName(roomName)
                .orElse(null);

        // Assert
        assertThat(findRoom)
                .isNull();
    }

    @Test
    public void 과외방_존재하지_않는키_제거_및_확인(){
        // Arrange
        roomName = "교육 방6";
        Room room = new Room(roomName);
        roomService.saveRoom(roomName);

        // Act
        boolean result = roomService.removeRoom("임시 방");
        System.out.println(result);

        Room findRoom = roomService.findRoomByName(roomName)
                .orElse(null);

        // Assert
        assertThat(findRoom)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(room);
    }

    @Test
    public void 괴외방_모든인원_가져오기_및_확인(){
        // Arrange
        roomName = "교육 방7";;
        roomService.saveRoom(roomName);
        roomService.addClient(roomName, email, session);
        roomService.addClient(roomName, "test2@test.com", mock(WebSocketSession.class));

        Room room = roomService.findRoomByName(roomName).orElse(null);

        // Act
        Map<String, WebSocketSession> clients = roomService.findClients(roomName);

        // Assert
        assertThat(clients)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(Objects.requireNonNull(room).getClients());
    }
}
