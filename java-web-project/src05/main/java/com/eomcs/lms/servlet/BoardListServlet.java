package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@WebServlet("/board/list")
@SuppressWarnings("serial")
public class BoardListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BoardService boardService =
        ((ApplicationContext) this.getServletContext().getAttribute("iocContainer"))
            .getBean(BoardService.class);

    List<Board> boards = boardService.list();

    request.setAttribute("list", boards);

    response.setContentType("text/html;charset=UTF-8");

    RequestDispatcher rd = request.getRequestDispatcher("/board/list.jsp");
    rd.include(request, response);
  }

}


