package fun.rpdk.mvcxmlx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("register")
    public String register(){
        return "register";
    }
}
