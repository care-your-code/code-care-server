package site.codecare.domain.mentee.dto;

import lombok.Getter;
import lombok.Setter;
import site.codecare.domain.mentee.entity.Member;
import site.codecare.domain.user.Role;


@Getter @Setter
public class MemberDto {

    private Long id;
    private String email;
    private String passWord;
    private Role role;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.passWord = member.getPassWord();
        this.role = member.getRole();
    }
}
