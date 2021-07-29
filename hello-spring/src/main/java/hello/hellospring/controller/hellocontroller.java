package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hellocontroller {
    //get방식으로 넘어온 /hello에 매핑시켜주는 것임.
    @GetMapping("hello")
    //요청이 오면 아래 메서드가 실행됨.
    //spring이 model을 만들어서 키:값을 넣음.
    public String Hello(Model model) {
        model.addAttribute("data", "hello!!");
        // resources/templates에 있는 hello.html에 렌더링하라는 의미, model을 가지고 가면서
        return "hello";


    }
}
