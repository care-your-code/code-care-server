package site.codecare.domain.mentee.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.domain.mentee.dto.MemberDto;
import site.codecare.domain.mentee.entity.Member;
import site.codecare.domain.mentee.repository.MenteeClassRepository;
import site.codecare.domain.user.Role;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MenteeClassServiceTest {

    @Autowired
    MenteeClassRepository menteeClassRepository;

    @Autowired
    MenteeClassService menteeClassService;


    /**
     * 멘티 개인정보 조회
     */
    @Test
    void find_mentee_info() throws Exception {

        //given
        Member mentee = Member.builder()
                .email("jun@gmail.com")
                .name("김준명")
                .passWord("1234")
                .role(Role.Mentee)
                .build();

        Member savedMentee = menteeClassRepository.save(mentee);


        //when
        Member foundMentee = menteeClassRepository.findByEmail(savedMentee.getEmail()).get();


        //then
        assertThat(mentee.getId()).isEqualTo(foundMentee.getId());
    }


    @Test
    void find_mentee_dto_info() throws Exception {

        //given
        Member mentee = Member.builder()
                .email("jun@gmail.com")
                .name("김준명")
                .passWord("1234")
                .role(Role.Mentee)
                .build();

        Member savedMentee = menteeClassRepository.save(mentee);

        //when
        MemberDto foundMenteeDto = menteeClassService.findByEmail(savedMentee.getEmail());

        //then
        assertThat(mentee.getId()).isEqualTo(foundMenteeDto.getId());
    }


    /**
     * 멘티 개인정보 수정
     */




    /**
     * 멘티 수강중인 클래스 조회
     */






}