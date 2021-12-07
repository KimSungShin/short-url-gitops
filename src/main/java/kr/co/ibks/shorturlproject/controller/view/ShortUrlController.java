package kr.co.ibks.shorturlproject.controller.view;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/view/short-urls")
@Controller
public class ShortUrlController {

    @GetMapping("/list")
    public String viewList(ModelAndView mav) {
        return "short-urls/list";
    }

    @GetMapping("/register")
    public String viewRegist(ModelAndView mav) {
        return "short-urls/regist";
    }

}
