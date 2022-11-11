package site.codecare.domain.mentee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.codecare.domain.mentee.entity.Mentee;

public interface MenteeClassRepository extends JpaRepository<Mentee, Long> {
}
