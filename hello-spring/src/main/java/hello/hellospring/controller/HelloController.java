package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //첫 진입점
public class HelloController {

    @GetMapping("hello") //hello 라는 메소드 호출
    public String hello(Model model){
        model.addAttribute("data","hello ~~~!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name,Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
}
