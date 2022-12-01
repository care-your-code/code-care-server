package site.codecare.domain.mentee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.codecare.domain.mentee.entity.Member;

import java.util.Optional;

public interface MenteeMyPageRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

}
