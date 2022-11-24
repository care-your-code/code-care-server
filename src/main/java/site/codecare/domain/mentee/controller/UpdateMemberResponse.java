package site.codecare.domain.mentee.controller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class UpdateMemberResponse {

    private Long id;
    private String name;
    private String phoneNumber;
    private String profile;
}
