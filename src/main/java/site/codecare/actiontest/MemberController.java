package site.codecare.actiontest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/api/v1/member")
    public ResponseEntity<Member> showMain() {

        Member member = Member.builder()
                .id(1L)
                .name("sangwon")
                .address("seoul")
                .build();

        memberRepository.save(member);

        return ResponseEntity.status(HttpStatus.OK)
                            .body(member);
    }
}
