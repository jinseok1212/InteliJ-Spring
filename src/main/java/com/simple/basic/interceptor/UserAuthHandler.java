package com.simple.basic.interceptor;

import com.simple.basic.command.UserVO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthHandler implements HandlerInterceptor {

    //1. 인터셉터로 동작을 하려면 HandlerInterceptor 상속
    //2. 인터셉터를 설정파일에 bean으로 등록하고, 인터셉터클래스로 등록
    //ctrl + i


    //컨트롤러 이전에 동작
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //세션 검사 -> 세션이 있으면 로그인된 유저이기에 컨트롤러로 연결
        //          -> 세션이 없으면 로그인이 안된 유저이기에 로그인페이지로
        System.out.println("컨트롤러 이전에 동작");
        HttpSession session = request.getSession();
        UserVO vo = (UserVO) session.getAttribute("userVO"); //로그인 성공시 저장해논 세션
        if(vo == null) { //세션이 없음
            response.sendRedirect("/user/login"); //로그인 페이지로
            return false;
        } else { //로그인이 되어있음
            return true;
        }


        
//        return true; //컨트롤러를 동작 시킴, false는 컨트롤러를 연결하지 않음
    }
    //컨트롤러 이후에 동작
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("컨트롤러 이후에 동작");
        
    }
}
