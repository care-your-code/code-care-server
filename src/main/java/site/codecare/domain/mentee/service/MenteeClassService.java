package site.codecare.domain.mentee.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.domain.mentee.entity.Member;
import site.codecare.domain.mentee.repository.MenteeClassRepository;

import java.security.Principal;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenteeClassService {

    private final MenteeClassRepository menteeClassRepository;

    public Member findByEmail(String email) {
        return menteeClassRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(email + " email is not found."));
    }



}
