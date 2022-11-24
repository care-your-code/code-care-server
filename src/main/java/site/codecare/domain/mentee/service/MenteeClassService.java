package site.codecare.domain.mentee.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.domain.mentee.controller.UpdateMemberRequest;
import site.codecare.domain.mentee.dto.MemberDto;
import site.codecare.domain.mentee.entity.Member;
import site.codecare.domain.mentee.repository.MenteeClassRepository;

import java.security.Principal;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenteeClassService {

    private final MenteeClassRepository menteeClassRepository;

    public MemberDto findByEmail(String email) {
        Optional<Member> optionalMember = menteeClassRepository.findByEmail(email);
        return optionalMember.map(o -> new MemberDto(o))
                .orElseThrow(() -> new RuntimeException(email + " email is not found."));
    }


    @Transactional
    public void update(Long id, UpdateMemberRequest request) {
        Optional<Member> optionalMember = menteeClassRepository.findById(id);
        Member member = optionalMember.orElseThrow(
                () -> new RuntimeException(id + " memberId is not found."));

        member.update(request.getName());
        member.updatePhoneNumber(request.getPhoneNumber());
        member.updateProfile(request.getProfile());
    }

    public MemberDto findById(Long id) {
        Optional<Member> optionalMember = menteeClassRepository.findById(id);
        return optionalMember.map(o -> new MemberDto(o))
                .orElseThrow(() -> new RuntimeException(id + " memberId is not found."));
    }
}
