package site.codecare.domain.mentee.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import site.codecare.domain.mentee.entity.Mentee;
import site.codecare.domain.mentee.repository.MenteeClassRepository;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MenteeClassServiceTest {

    @Autowired
    private MenteeClassRepository menteeClassRepository;

    @Autowired
    private MenteeClassService menteeClassService;


    @Test
    void test1() throws Exception {

        Mentee mentee = new Mentee();
        mentee.setUsername("김준명");



    }


}