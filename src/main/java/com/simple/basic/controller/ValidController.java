package com.simple.basic.controller;

import com.simple.basic.command.MemberVO;
import com.simple.basic.command.ValidVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.lang.reflect.Member;
import java.util.List;

@Controller
@RequestMapping("/valid")
public class ValidController {

    @GetMapping("/view")
    public String view(Model model) {
        //이 화면에 진입할 떄 vo가 없으면 에러가 남
        model.addAttribute("vo", new ValidVO());
        return "valid/view";
    }

    @PostMapping("/actionForm")
    public String actionForm(@Valid @ModelAttribute("vo") ValidVO vo, BindingResult result) {
        
        //@valid는 유효성검사를 하겠다는 의미
        //만약 유효성 검사에 통과하지 못하면, 통과하지 못한 멤버변수 내역이 BindingResult에 저장됨
        
        if(result.hasErrors()) { //내역이 있으면 true, 없으면 false
//            System.out.println("유효성 검사 실패");
//        }
//        List<FieldError> list = binding.getFieldErrors();
//        for(FieldError err : list){
//            System.out.println(err.getField());//유효성 검사에 실패한 필드명
//            System.out.println(err.getDefaultMessage());//유효성 검사에 실패한 내역의 메세지 값
            return "valid/view"; //다시 원래 화면으로
        }

        
        //처리
        //System.out.println(vo.toString());

        vo.getSalary();
        return "valid/result";
    }

    @GetMapping("/quiz01")
    public String quiz01(Model model) {
        //이 화면에 진입할 떄 vo가 없으면 에러가 남
        model.addAttribute("vo", new MemberVO());
        return "valid/quiz01";
    }

    @PostMapping("/quizForm")
    public String actionForm(@Valid @ModelAttribute("vo") MemberVO vo, BindingResult result) {


        if(result.hasErrors()) { //유효성 실패시

            return "valid/quiz01"; //다시 원래 화면으로
        } else {
            return "valid/quiz01_result";
        }

    }



}
