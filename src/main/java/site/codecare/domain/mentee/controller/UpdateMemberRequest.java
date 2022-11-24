package site.codecare.domain.mentee.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateMemberRequest {

    private String name;
    private String phoneNumber;
    private String profile;
}
