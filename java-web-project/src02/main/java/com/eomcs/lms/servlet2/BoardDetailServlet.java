package com.eomcs.lms.servlet2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@WebServlet("/board2/detail")
@SuppressWarnings("serial")
public class BoardDetailServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BoardService boardService = InitServlet.iocContainer.getBean(BoardService.class);

    int no = Integer.parseInt(request.getParameter("no"));

    Board board = boardService.get(no);

    PrintWriter out = response.getWriter();

    if (board == null) {
      out.println("<p>해당 번호의 게시물이 없습니다.</p>");
      return;
    }

    out.println("<form action='board2' method='post'>");
    out.println("<input type='hidden' name='command' value='update'>");
    out.println("<table border='1'>");
    out.printf("<tr>" + "<th>번호</th>" + "<td><input type='text' name='no' value='%d' readonly></td>"
        + "</tr>\n", no);
    out.println(
        String.format(
            "<tr> <th>내용</th> "
                + "<td><textarea name='contents' rows='3' cols='50'>%s</textarea></td> " + "</tr>",
            board.getContents()));
    out.println(String.format("<tr> <th>작성일</th> <td>%s</td> </tr>", board.getCreatedDate()));
    out.println(String.format("<tr> <th>조회수</th> <td>%d</td> </tr>", board.getViewCount()));

    out.println("</table>");
    out.println("<p><a href='board2?command=list'>목록</a>" + " <a href='board2?command=delete&no="
        + board.getNo() + "'>삭제</a>" + " <button type='submit'>변경</button>" + "<p>");
    out.println("</form>");
  }

}


