package id.co.asyst.wfm.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/identity")
    public String home(){
        return "home";
    }
}
