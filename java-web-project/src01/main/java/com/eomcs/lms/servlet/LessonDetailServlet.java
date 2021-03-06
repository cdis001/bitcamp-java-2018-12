package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@WebServlet("/lesson/detail")
@SuppressWarnings("serial")
public class LessonDetailServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LessonService lessonService = InitServlet.iocContainer.getBean(LessonService.class);

    int no = Integer.parseInt(request.getParameter("no"));
    Lesson lesson = lessonService.get(no);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>수업 조회</title></head>");
    out.println("<body><h1>수업 조회</h1>");

    if (lesson == null) {
      out.println("해당 번호의 수업이 없습니다.");
      return;
    }

    out.println("<form action='update' method='post'>");
    out.println("<table border='6'>");
    out.printf("<tr>" + "<th>번호</th>" + "<td><input type='text' name='no' value='%d' readonly></td>"
        + "</tr>\n", no);
    out.println(
        String.format(
            "<tr>" + "<th>수업명</th>"
                + "<td><input type='text' name='title' value='%s' textarea></td> " + "</tr>",
            lesson.getTitle()));
    out.println(
        String.format(
            "<tr>" + "<th>내용</th>"
                + "<td><input type='text' name='contents' value='%s' textarea></td> " + "</tr>",
            lesson.getContents()));
    out.println(String.format(
        "<tr>" + "<th>시작일</th>"
            + "<td><input type='text' name='startDate' value='%s' textarea></td> " + "</tr>",
        lesson.getStartDate()));
    out.println(
        String.format(
            "<tr>" + "<th>종료일</th>"
                + "<td><input type='text' name='endDate' value='%s' textarea></td> " + "</tr>",
            lesson.getEndDate()));
    out.println(String.format(
        "<tr>" + "<th>총수업시간</th>"
            + "<td><input type='text' name='totalHours' value='%s' textarea></td> " + "</tr>",
        lesson.getTotalHours()));
    out.println(String.format(
        "<tr>" + "<th>일수업시간</th>"
            + "<td><input type='text' name='dayHours' value='%s' textarea></td> " + "</tr>",
        lesson.getDayHours()));
    out.println("</table>");
    out.println("<p><a href='list'>목록</a>" + " <a href='delete?no=" + lesson.getNo() + "'>삭제</a>"
        + " <button type='submit'>변경</button>" + "<p>");
    out.println("</form>");
    out.println("</body></html>");

  }

}
