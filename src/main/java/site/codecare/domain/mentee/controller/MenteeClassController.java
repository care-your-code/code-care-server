package site.codecare.domain.mentee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import site.codecare.domain.mentee.dto.MemberDto;
import site.codecare.domain.mentee.entity.Member;
import site.codecare.domain.mentee.service.MenteeClassService;

import java.security.Principal;

@Controller
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
    public String mypageInfo(Principal principal) {

        String email = principal.getName();
        MemberDto menteeDto = menteeClassService.findByEmail(email);

        return "";
    }


    /**
     * 개인정보 수정
     */
    @PatchMapping("/usr/mypage/info")
    public String mypageInfo() {

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