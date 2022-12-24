package site.codecare.domain.mentee.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.domain.mentee.MenteeClass;
import site.codecare.domain.mentee.MenteeClassDto;
import site.codecare.domain.mentee.dto.UpdateMenteeRequest;
import site.codecare.domain.mentee.dto.MenteeDto;
import site.codecare.domain.mentee.entity.Mentee;
import site.codecare.domain.mentee.repository.MenteeMyPageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenteeMyPageService {

    private final MenteeMyPageRepository menteeMyPageRepository;

    @Transactional
    public void update(Long id, UpdateMenteeRequest request) {
        Mentee mentee = findMemberById(id);

        if(!mentee.getName().equals(request.getName())) {
            mentee.updateName(request.getName());
        }

        if(!mentee.getPhoneNumber().equals(request.getPhoneNumber())) {
            mentee.updatePhoneNumber(request.getPhoneNumber());
        }

        if(!mentee.getProfile().equals(request.getProfile())) {
            mentee.updateProfile(request.getProfile());
        }
    }


    public MenteeDto findByEmail(String email) {
        Mentee mentee = findMemberByEmail(email);
        return new MenteeDto(mentee);
    }

    private Mentee findMemberByEmail(String email) {
        return menteeMyPageRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(email + " email is not found."));
    }


    public MenteeDto findById(Long id) {
        Mentee mentee = findMemberById(id);
        return new MenteeDto(mentee);
    }

    private Mentee findMemberById(Long id) {
        return menteeMyPageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " memberId is not found."));
    }

    public List<MenteeClassDto> findClassByEmail(String email) {
        List<MenteeClass> memberClasses = menteeMyPageRepository.findClassByEmail(email);

        List<MenteeClassDto> classDtos = memberClasses.stream()
                .map(o -> new MenteeClassDto(o))
                .collect(Collectors.toList());

        return classDtos;
    }
}
