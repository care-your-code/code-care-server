package site.codecare.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import site.codecare.domain.BaseEntity;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
public class User extends BaseEntity {

    private String username;

    private String passWord;

    private String phoneNumber;

    private String email;

    private Role role;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String profile;


}
