package site.codecare.domain.mentee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.codecare.domain.mentee.dto.MemberDto;
import site.codecare.domain.mentee.dto.MemberEmailRequest;
import site.codecare.domain.mentee.dto.UpdateMemberRequest;
import site.codecare.domain.mentee.dto.UpdateMemberResponse;
import site.codecare.domain.mentee.service.MenteeClassService;
import site.codecare.global.base.RsData;
import site.codecare.util.Ut;

import javax.validation.Valid;
import java.security.Principal;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usr/mypage", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class MenteeClassController {

    private final MenteeClassService menteeClassService;


//    /**
//     * 마이페이지로 이동
//     */
//    @GetMapping("")
//    public String mypage() {
//        return "";
//    }



    @Operation(description = "개인정보조회")
    @GetMapping("/info")
    public ResponseEntity<RsData<MemberResponse>> mypageInfo(@Parameter @Valid MemberEmailRequest request) {
        MemberDto memberDto = menteeClassService.findByEmail(request.getEmail());

        return Ut.sp.responseEntityOf(RsData.successOf(
                new MemberResponse(memberDto)));
    }


    @Operation(description = "개인정보수정")
    @PatchMapping("/info")
    public UpdateMemberResponse mypageInfo(@Parameter @PathVariable("id") Long id, @Parameter @Valid UpdateMemberRequest request) {
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
