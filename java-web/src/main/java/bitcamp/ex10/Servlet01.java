package bitcamp.ex10;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ex10/s1")
public class Servlet01 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Cookie c1 = new Cookie("name", "hong");

    Cookie c2 = new Cookie("age", "20");

    Cookie c3 = new Cookie("working", "true");

    Cookie c4 = new Cookie("name2", "홍길동");

    Cookie c5 = new Cookie("name3", URLEncoder.encode("홍길동", "UTF-8"));

    resp.addCookie(c1);
    resp.addCookie(c2);
    resp.addCookie(c3);
    resp.addCookie(c4);
    resp.addCookie(c5);

    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("쿠키를 보냈습니다! -/ex10/s1");
  }
}
