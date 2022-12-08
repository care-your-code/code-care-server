package site.codecare.domain.community.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.codecare.domain.community.service.PostService;

@RequiredArgsConstructor
@RequestMapping("/community")
@Controller
public class PostController {

    private final PostService postService;


}
