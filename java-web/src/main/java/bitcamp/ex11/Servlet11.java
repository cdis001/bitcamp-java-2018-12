package bitcamp.ex11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ex11/s11")
public class Servlet11 extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<html><head><title>페이지1</title></head><body>");
    out.println("<form action='s12' method='post'>");
    out.println("이름: <input type='text' name='name'><br>");
    out.println("<button>다음</button>");
    out.println("</form>");
    out.println("</body></html>");
  }
}
