package site.codecare.domain.mentee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.codecare.domain.mentee.dto.MemberDto;
import site.codecare.domain.mentee.entity.Member;
import site.codecare.domain.mentee.service.MenteeClassService;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usr/mypage")
public class MenteeClassController {

    private final MenteeClassService menteeClassService;


//    /**
//     * 마이페이지로 이동
//     */
//    @GetMapping("")
//    public String mypage() {
//        return "";
//    }


    /**
     * 개인정보 조회
     */
    @GetMapping("/info")
    public MemberDto mypageInfo(Principal principal, @RequestBody @Valid MemberRequest request) {
        String email = principal.getName();
        return menteeClassService.findByEmail(email);
    }


    /**
     * 개인정보 수정
     */
    @PatchMapping("/info")
    public UpdateMemberResponse mypageInfo(@PathVariable("id") Long id, @RequestBody @Valid UpdateMemberRequest request) {
        menteeClassService.update(id, request);
        MemberDto memberDto = menteeClassService.findById(id);
        return new UpdateMemberResponse(memberDto.getId(), memberDto.getName(), memberDto.getPhoneNumber(), memberDto.getProfile());
    }


//    /**
//     * 수강중인 클래스 조회
//     */
//    @GetMapping("/info")
//    public String mypageClass() {
//
//        return "";
//    }

}
