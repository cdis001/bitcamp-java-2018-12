package com.eomcs.lms.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller("/auth/login")
public class LoginController implements PageController {

  static final String REFERER_URL = "refererURL";

  @Autowired
  MemberService memberService;

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    if (request.getMethod().equals("GET")) {
      HttpSession session = request.getSession();
      session.setAttribute(REFERER_URL, request.getHeader("Referer"));
      return "/auth/login.jsp";
    }

    ServletContext sc = request.getServletContext();

    Cookie cookie;
    if (request.getParameter("saveEmail") != null) {
      cookie = new Cookie("email", request.getParameter("email"));
      cookie.setMaxAge(60 * 60 * 24 * 15);
    } else {
      cookie = new Cookie("email", "");
      cookie.setMaxAge(0);
    }

    response.addCookie(cookie);

    Member member =
        memberService.get(request.getParameter("email"), request.getParameter("password"));

    if (member == null) {
      return "/auth/fail.jsp";
    }

    HttpSession session = request.getSession();

    session.setAttribute("loginUser", member);


    String refererUrl = (String) session.getAttribute(REFERER_URL);

    if (refererUrl == null) {
      return "redirect:" + sc.getContextPath();
    } else {
      return "redirect:" + refererUrl;
    }
  }

}


