package site.codecare.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class RootController {

    @RequestMapping("/")
    public String homeRedirect() {
        return "redirect:/swagger-ui.html";
    }

}
