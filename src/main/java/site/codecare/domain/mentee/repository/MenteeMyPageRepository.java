package site.codecare.domain.mentee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.codecare.domain.mentee.entity.Mentee;
import site.codecare.domain.mentee.MenteeClass;

import java.util.List;
import java.util.Optional;

public interface MenteeMyPageRepository extends JpaRepository<Mentee, Long> {

    Optional<Mentee> findByEmail(String email);

    List<MenteeClass> findClassByEmail(String email);
}
