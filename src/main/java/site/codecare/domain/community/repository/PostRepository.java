package site.codecare.domain.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.codecare.domain.community.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
