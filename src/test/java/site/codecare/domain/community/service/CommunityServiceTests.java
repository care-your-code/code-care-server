package site.codecare.domain.community.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class CommunityServiceTests {

    @Test
    @DisplayName("게시물_저장된다")
    void t1() throws Exception {

        //Arrange
        Post post = Post.builder()
                .title("title")
                .content("content")
                .email("code-care@naver.com")
                .build();
        //Act

        postRepository.save(post);

        //Assert

        assertThat(postRepository.findById(1L)).isNotNull();

    }
}
