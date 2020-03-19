package io.jgoerner.querygenerator.questions.adapter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlView {

    @GetMapping("/")
    public String index() {
        return "questions";
    }

}
