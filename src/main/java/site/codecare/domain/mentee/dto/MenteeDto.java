package site.codecare.domain.mentee.dto;

import lombok.Getter;
import lombok.Setter;
import site.codecare.domain.mentee.entity.Mentee;
import site.codecare.domain.user.Role;


@Getter @Setter
public class MenteeDto {

    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private Role role;
    private String profile;

    public MenteeDto(Mentee mentee) {
        this.id = mentee.getId();
        this.email = mentee.getEmail();
        this.name = mentee.getName();
        this.phoneNumber = mentee.getPhoneNumber();
        this.role = mentee.getRole();
        this.profile = mentee.getProfile();
    }
}
