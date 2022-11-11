package site.codecare.domain.mentee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.codecare.domain.mentee.service.MenteeCourseService;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class MenteeCourseController {

    private final MenteeCourseService menteeCourseService;

}
