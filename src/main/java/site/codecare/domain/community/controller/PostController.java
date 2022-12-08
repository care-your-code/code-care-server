package site.codecare.domain.community.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import site.codecare.domain.community.dto.PostResponseDto;
import site.codecare.domain.community.service.PostService;

@RequiredArgsConstructor
@RequestMapping("/community")
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping("/post/{id}")
    public ResponseEntity<PostResponseDto> findById(@PathVariable Long id) {

        PostResponseDto post = postService.findById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(post);
    }


}
