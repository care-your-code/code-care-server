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
@RequestMapping("")
public class MenteeClassController {

    private final MenteeClassService menteeClassService;


//    /**
//     * 마이페이지로 이동
//     */
//    @GetMapping("/usr/mypage")
//    public String mypage() {
//        return "";
//    }


    /**
     * 개인정보 조회
     */
    @GetMapping("/usr/mypage/info")
    public MemberDto mypageInfo(Principal principal) {
        String email = principal.getName();
        return menteeClassService.findByEmail(email);
    }


    /**
     * 개인정보 수정
     */
    @PatchMapping("/usr/mypage/info")
    public String mypageInfo(@PathVariable("id") Long id, @RequestBody @Valid UpdateMemberRequest request) {


        return "";
    }


//    /**
//     * 수강중인 클래스 조회
//     */
//    @GetMapping("/usr/mypage/info")
//    public String mypageClass() {
//
//        return "";
//    }

}
