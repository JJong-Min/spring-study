package hello.hellospring.controller;

import hello.hellospring.service.Memberservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// controller애노테이션을 보고 스프링이 membercontroller 객체를 생성해서 들고 있음.
// 이를 스프링 컨테이너에서 스프링 빈이 관리된다고 표현
@Controller
//membercontroller가 memberservice를 통해 회원가입 조회를 하는데 이를 의존관계가 있다고 함.(membercontoller -> memberservice)
public class MemberController {

    private final Memberservice memberservice;

    // autowired 애노테이션은 스프링 컨테이너에 있는 memberservice와 자동으로 연결을 시켜줌
    @Autowired
    public MemberController(Memberservice memberservice) {
        this.memberservice = memberservice;
    }
    /* 이렇게 new로 memberservice객체를 생성하면 membercontroller이외의 controller가 meberservice객체를 사용할 수 있는 문제가 발생
    private final Memberservice memberservice = new Memberservice();
    */
}
