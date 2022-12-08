package site.codecare.domain.community.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.domain.community.dto.PostResponseDto;
import site.codecare.domain.community.entity.Post;
import site.codecare.domain.community.repository.PostRepository;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class PostServiceTests {

    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;


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

        postService.save(post);

        //Assert

        assertThat(postRepository.findById(1L)).isNotNull();

    }

    @DisplayName("게시물_조회된다")
    @Test
    void t2() throws Exception {
        //Arrange

        postService.save(Post.builder()
                .title("title")
                .content("content")
                .email("code-care@naver.com")
                .build());
        //Act

        PostResponseDto post = postService.findById(1L);


        //Assert

        assertThat(post.getTitle()).isEqualTo("title");

    }
}
