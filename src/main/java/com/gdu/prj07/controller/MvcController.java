package com.gdu.prj07.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Controller
public class MvcController {

    @GetMapping(value = {"/", "/main.do"})

    public String welcome(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("user", "로그인정보");
        log.info("{}", StringUtils.repeat("-", 80));                               //동작 이전
        log.info("{}", StringUtils.repeat("-", 80));                               //동작 이전
        log.info("{}", StringUtils.repeat("-", 80));                               //동작 이전

        log.info(session.getId() + " : " + session.toString());
        log.info((String) session.getAttribute("user"));
        log.info("{}", StringUtils.repeat("-", 80));                               //동작 이전
        log.info("{}", StringUtils.repeat("-", 80));                               //동작 이전
        log.info("{}", StringUtils.repeat("-", 80));                               //동작 이전

        return "index";
    }
}
