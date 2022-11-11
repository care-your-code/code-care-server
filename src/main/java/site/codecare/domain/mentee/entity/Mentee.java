package site.codecare.domain.mentee.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import site.codecare.domain.user.UserInfo;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter @Setter
public class Mentee extends UserInfo {


}
