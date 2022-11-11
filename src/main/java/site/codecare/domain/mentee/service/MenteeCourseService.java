package site.codecare.domain.mentee.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.domain.mentee.repository.MenteeCourseRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenteeCourseService {

    private final MenteeCourseRepository menteeCourseRepository;


}
