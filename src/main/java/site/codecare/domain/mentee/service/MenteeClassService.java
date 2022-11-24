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

    @Transactional
    public void update(Long id, UpdateMemberRequest request) {
        Optional<Member> optionalMember = menteeClassRepository.findById(id);
        Member member = optionalMember.orElseThrow(
                () -> new RuntimeException(id + " memberId is not found."));

        member.update(request.getName());
        member.updatePhoneNumber(request.getPhoneNumber());
        member.updateProfile(request.getProfile());
    }


    public MemberDto findByEmail(String email) {
        Member member = findMemberByEmail(email);
        return new MemberDto(member);
    }

    private Member findMemberByEmail(String email) {
        return menteeClassRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(email + " email is not found."));
    }


    public MemberDto findById(Long id) {
        Member member = findMemberById(id);
        return new MemberDto(member);
    }

    private Member findMemberById(Long id) {
        return menteeClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " memberId is not found."));
    }

}
