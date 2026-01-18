package com.llb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

    @GetMapping("/greet")
    public String greet(){
        return "Hello World...";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to this World...";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact @7549662926";
    }

}
