package site.codecare.domain.mentee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateMenteeRequest {

    @Schema(description = "이름", example = "도비")
    private String name;

    @Schema(description = "폰번호", example = "010-1234-1234")
    private String phoneNumber;

    @Schema(description = "프로필", example = "대학교 2학년")
    private String profile;

}
