package site.codecare.domain.mentee.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.codecare.domain.mentee.dto.MemberDto;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {
    private MemberDto memberDto;
}
