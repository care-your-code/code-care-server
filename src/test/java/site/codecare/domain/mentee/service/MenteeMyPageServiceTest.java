package site.codecare.domain.mentee.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.domain.mentee.dto.MenteeDto;
import site.codecare.domain.mentee.entity.Mentee;
import site.codecare.domain.mentee.repository.MenteeMyPageRepository;
import site.codecare.domain.user.Role;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
//@MockBean
class MenteeMyPageServiceTest {

    @Autowired
    MenteeMyPageRepository menteeMyPageRepository;

    @Autowired
    MenteeMyPageService menteeMyPageService;


    /**
     * 멘티 개인정보 조회
     */
    @Test
    void find_mentee_info() throws Exception {

        //arrange
        Mentee mentee = Mentee.builder()
                .email("jun@gmail.com")
                .name("김준명")
                .passWord("1234")
                .role(Role.Mentee)
                .build();

        Mentee savedMentee = menteeMyPageRepository.save(mentee);


        //act
        Mentee foundMentee = menteeMyPageRepository.findByEmail(savedMentee.getEmail()).get();


        //assert
        assertThat(mentee.getId()).isEqualTo(foundMentee.getId());
    }


    @Test
    void find_mentee_dto_info() throws Exception {

        //arrange
        Mentee mentee = Mentee.builder()
                .email("jun@gmail.com")
                .name("김준명")
                .passWord("1234")
                .role(Role.Mentee)
                .build();

        Mentee savedMentee = menteeMyPageRepository.save(mentee);

        //act
        MenteeDto foundMenteeDto = menteeMyPageService.findByEmail(savedMentee.getEmail());

        //assert
        assertThat(mentee.getId()).isEqualTo(foundMenteeDto.getId());
    }


    /**
     * 멘티 개인정보 수정
     */
//    @Test
//    void update_mentee_info() throws Exception {
//
//
//    }




    /**
     * 멘티 수강중인 클래스 조회
     */






}