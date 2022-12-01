package site.codecare.domain.mentee.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.domain.mentee.dto.UpdateMemberRequest;
import site.codecare.domain.mentee.dto.MemberDto;
import site.codecare.domain.mentee.entity.Member;
import site.codecare.domain.mentee.repository.MenteeMyPageRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenteeMyPageService {

    private final MenteeMyPageRepository menteeMyPageRepository;

    @Transactional
    public void update(Long id, UpdateMemberRequest request) {
        Member member = findMemberById(id);

        if(!member.getName().equals(request.getName())) {
            member.updateName(request.getName());
        }

        if(!member.getPhoneNumber().equals(request.getPhoneNumber())) {
            member.updatePhoneNumber(request.getPhoneNumber());
        }

        if(!member.getProfile().equals(request.getProfile())) {
            member.updateProfile(request.getProfile());
        }
    }


    public MemberDto findByEmail(String email) {
        Member member = findMemberByEmail(email);
        return new MemberDto(member);
    }

    private Member findMemberByEmail(String email) {
        return menteeMyPageRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(email + " email is not found."));
    }


    public MemberDto findById(Long id) {
        Member member = findMemberById(id);
        return new MemberDto(member);
    }

    private Member findMemberById(Long id) {
        return menteeMyPageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " memberId is not found."));
    }

}
