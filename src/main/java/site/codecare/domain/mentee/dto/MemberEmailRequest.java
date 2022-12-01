package site.codecare.domain.mentee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberEmailRequest {

    @Schema(description = "이메일", example = "member1@gmail.com")
    private String email;
}
