package site.codecare.domain.mentee.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.domain.mentee.repository.MenteeClassRepository;

import java.security.Principal;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenteeClassService {

    private final MenteeClassRepository menteeClassRepository;

    public void findByEmail(String email) {
        menteeClassRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(email + " email is not found."));
    }



}
