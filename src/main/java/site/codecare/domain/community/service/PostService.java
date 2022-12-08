package site.codecare.domain.community.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.domain.community.dto.PostResponseDto;
import site.codecare.domain.community.entity.Post;
import site.codecare.domain.community.repository.PostRepository;

import java.util.NoSuchElementException;

// TODO : 사용자 추가, 댓글 기능 추가, VIEW 중복 방지 세션? 쿠키? @VALID 적용
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(Post post) {

        return postRepository.save(post).getId();
    }

    public PostResponseDto findById(Long id) {

        Post entity = postRepository.findById(id).orElseThrow(NoSuchElementException::new);
        updateView(id);
        return new PostResponseDto(entity);
    }

    @Transactional
    public void updateView(Long id) {
        this.postRepository.updateView(id);
    }
}
