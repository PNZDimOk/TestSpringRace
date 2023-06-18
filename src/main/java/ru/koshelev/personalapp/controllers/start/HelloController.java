package ru.koshelev.personalapp.controllers.start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/start")
    public String start(){
        return "hello/start";
    }

    @GetMapping("/info")
    public String info(){
        return "hello/info";
    }

}
