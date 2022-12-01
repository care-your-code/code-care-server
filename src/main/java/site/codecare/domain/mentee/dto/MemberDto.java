package site.codecare.domain.mentee.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import site.codecare.domain.mentee.entity.Member;
import site.codecare.domain.user.Role;


@Getter @Setter
public class MemberDto {

    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private Role role;
    private String profile;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.phoneNumber = member.getPhoneNumber();
        this.role = member.getRole();
        this.profile = member.getProfile();
    }
}
