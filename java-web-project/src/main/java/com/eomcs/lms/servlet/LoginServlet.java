package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@WebServlet("/auth/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

  static final String REFERER_URL = "refererURL";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession();
    session.setAttribute(REFERER_URL, request.getHeader("Referer"));

    Cookie[] cookies = request.getCookies();
    String email = "";
    if (cookies != null) {
      for (Cookie c : cookies) {
        if (c.getName().equals("email")) {
          email = c.getValue();
          break;
        }
      }
    }

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>로그인</title></head>");
    out.println("<body>");
    out.println("<h1>로그인</h1>");
    out.println("<form action='login' method='post'>");
    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("  <th>이메일</th>");
    out.printf("  <td><input type='email' name='email' value='%s'></td>\n", email);
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>암호</th>");
    out.println("  <td><input type='password' name='password'></td>");
    out.println("</tr>");
    out.println("</table>");
    out.println("<input type='checkbox' name='saveEmail' value='value'> 이메일 저장");
    out.println("<p>");
    out.println("  <button type='submit'>등록</button>");
    out.println("  <a href='../'>목록</a>");
    out.println("</p>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");


  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Cookie cookie;
    if (request.getParameter("saveEmail") != null) {
      cookie = new Cookie("email", request.getParameter("email"));
      cookie.setMaxAge(60 * 60 * 24 * 15);
    } else {
      cookie = new Cookie("email", "");
      cookie.setMaxAge(0);
    }
    response.addCookie(cookie);

    System.out.println(request.getHeader("Referer"));

    MemberService memberService =
        ((ApplicationContext) this.getServletContext().getAttribute("iocContainer"))
            .getBean(MemberService.class);

    Member member =
        memberService.get(request.getParameter("email"), request.getParameter("password"));

    if (member == null) {
      response.setHeader("Refresh", "2;url=login");
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      out.println("<html><head><title>로그인 실패</title></head><body>");
      out.println("<h1>로그인 오류</h1>");
      out.println("<p>이메일 또는 암호가 맞지 않습니다</p>");
      out.println("</body></html>");
      return;
    }

    HttpSession session = request.getSession();

    session.setAttribute("loginUser", member);


    String refererUrl = (String) session.getAttribute(REFERER_URL);

    if (refererUrl == null) {
      response.sendRedirect("../");
    } else {
      response.sendRedirect(refererUrl);
    }


  }

}

