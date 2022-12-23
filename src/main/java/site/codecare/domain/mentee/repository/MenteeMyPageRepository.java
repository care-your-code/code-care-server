package site.codecare.domain.mentee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.codecare.domain.mentee.entity.Member;
import site.codecare.domain.mentee.MemberClass;

import java.util.List;
import java.util.Optional;

public interface MenteeMyPageRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    List<MemberClass> findClassByEmail(String email);
}
