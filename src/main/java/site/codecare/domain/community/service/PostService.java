package site.codecare.domain.community.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.domain.community.entity.Post;
import site.codecare.domain.community.repository.PostRepository;

@Transactional
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(Post post) {

        return postRepository.save(post).getId();
    }
}
