package site.codecare.domain.mentee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.codecare.domain.mentee.dto.*;
import site.codecare.domain.mentee.service.MenteeMyPageService;
import site.codecare.global.base.RsData;
import site.codecare.util.Ut;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usr/mypage", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@Tag(name = "MenteeMyPageController", description = "개인정보조회, 개인정보수정, 수강중인 클래스 정보 제공 기능을 담당")
public class MenteeMyPageController {

    private final MenteeMyPageService menteeMyPageService;


//    /**
//     * 마이페이지로 이동
//     */
//    @GetMapping("")
//    public String mypage() {
//        return "";
//    }



    @Operation(description = "개인정보조회")
    @GetMapping("/info")
    public ResponseEntity<RsData<MemberResponse>> menteeInfo(@Parameter @Valid MemberEmailRequest request) {
        MemberDto memberDto = menteeMyPageService.findByEmail(request.getEmail());

        return Ut.sp.responseEntityOf
                (RsData.successOf(new MemberResponse(memberDto)));
    }


    @Operation(description = "개인정보수정")
    @PatchMapping("/info")
    public UpdateMemberResponse menteeInfo(@Parameter @PathVariable("id") Long id, @Parameter @Valid UpdateMemberRequest request) {
        menteeMyPageService.update(id, request);
        MemberDto memberDto = menteeMyPageService.findById(id);
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
