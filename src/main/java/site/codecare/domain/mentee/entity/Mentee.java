package site.codecare.domain.mentee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import site.codecare.domain.user.Role;
import site.codecare.global.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
public class Mentee extends BaseEntity {


    @Column(name = "email", unique = true)
    private String email;

    @Column()
    private String passWord;

    @Column()
    private String name;

    @Column()
    private String phoneNumber;

    @Column()
    private Role role;

    @Column(columnDefinition = "TEXT")
    private String profile;


    public void updateName(String name) {
        this.name = name;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateProfile(String profile) {
        this.profile = profile;
    }
}
