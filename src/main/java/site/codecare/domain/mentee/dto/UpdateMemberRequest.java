package site.codecare.domain.mentee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateMemberRequest {

    private String name;
    private String phoneNumber;
    private String profile;
}
