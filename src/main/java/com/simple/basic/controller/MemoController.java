package com.simple.basic.controller;

import com.simple.basic.command.MemoVO;
import com.simple.basic.memo.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/memo")
public class MemoController {
    
    
    //insert기능 - 유효성검사
    //select기능 - 화면처리

    @Autowired
    @Qualifier("memoService")
    MemoService memoService;

    @GetMapping("/memoWrite")
    public String memoWrite(Model model) {
        model.addAttribute("vo", new MemoVO());
        return "memo/memoWrite";
    }
    @PostMapping("/memoForm")
    public String memoForm(@Valid @ModelAttribute("vo") MemoVO vo, BindingResult result) {
        if(result.hasErrors()) {

            return "memo/memoWrite"; //유효성 검사 실패인 경우
        }

        memoService.insertMemo(vo);

        return "redirect:/memo/memoList";
    }
    @GetMapping("/memoList")
    public String memoList(Model model) {

        //select
        ArrayList<MemoVO> list = memoService.getList();
        model.addAttribute("list", list);
        return "memo/memoList";
    }

}
