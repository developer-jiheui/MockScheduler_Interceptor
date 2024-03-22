package com.gdu.prj07.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setContentType("text/html; charset=UTF-8");

        Object user = request.getSession().getAttribute("user");

            PrintWriter out = response.getWriter();

        if (user == null) {
            out.println("<script>");
            out.println("alert('로그인을 해주세요')");
            out.println("history.back()");
            out.println("</script>");


            return false;  // 컨트롤러로 요청이 전달되지 않는다.
        }
        out.println("alert('"+user.toString()+"이 로그인했습니다')");
        return true;
    }
}
