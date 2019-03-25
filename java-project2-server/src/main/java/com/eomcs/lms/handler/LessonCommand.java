package com.eomcs.lms.handler;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@Component
public class LessonCommand {

  LessonService lessonService;

  public LessonCommand(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/list")
  public void list(ServletRequest request, ServletResponse response) throws Exception {

    List<Lesson> lessons = lessonService.list();
    PrintWriter out = response.getWriter();

    out.println("<html><head><title>수업 목록</title></head>");
    out.println("<body><h1>수업 목록</h1>");
    out.println("<p><a href='/lesson/form'>새글</a></p>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th> <th>제목</th> <th>시작일</th> <th>종료일</th> <th>총수업시간</th> </tr>");
    for (Lesson lesson : lessons) {
      response.println(String.format(
          "<tr><td>%d</td> <td><a href='/lesson/detail?no=%1$d'>%s</a></td> <td>%s</td> <td>%s</td> <td>%d</td> </tr>",
          lesson.getNo(), lesson.getTitle(), lesson.getStartDate(), lesson.getEndDate(),
          lesson.getTotalHours()));
    }
  }

  @RequestMapping("/lesson/add")
  public void add(ServletRequest request, ServletResponse response) throws Exception {

    Lesson lesson = new Lesson();

    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));
    lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
    lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));

    lessonService.add(lesson);

    PrintWriter out = response.getWriter();
    out.println("<html><head>" + "<title>수업 등록</title>"
        + "<meta http-equiv='Refresh' content='1;url=/lesson/list'>" + "</head>");
    out.println("<body><h1>수업 등록</h1>");
    out.println("<p>저장하였습니다.</p>");
    out.println("</body></html>");
  }

  @RequestMapping("/lesson/detail")
  public void detail(ServletRequest request, ServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    Lesson lesson = lessonService.get(no);

    PrintWriter out = response.getWriter();
    out.println("<html><head><title>수업 조회</title></head>");
    out.println("<body><h1>수업 조회</h1>");

    if (lesson == null) {
      response.println("해당 번호의 수업이 없습니다.");
      return;
    }

    out.println("<form action='/lesson/update'>");
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
    out.println("<p><a href='/lesson/list'>목록</a>" + " <a href='/lesson/delete?no=" + lesson.getNo()
        + "'>삭제</a>" + " <button type='submit'>변경</button>" + "<p>");
    out.println("</form>");
    out.println("</body></html>");


  }

  @RequestMapping("/lesson/update")
  public void update(ServletRequest request, ServletResponse response) throws Exception {

    Lesson lesson = new Lesson();
    lesson.setNo(Integer.parseInt(request.getParameter("no")));
    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));
    lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
    lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));

    PrintWriter out = response.getWriter();
    out.println("<html><head>" + "<title>수업 정보 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=/lesson/list'>" + "</head>");
    out.println("<body><h1>수업 정보 변경</h1>");

    if (lessonService.update(lesson) == 0) {
      response.println("<p>해당 번호의 수업이 없습니다.</p>");
    } else {
      out.println("<p>변경했습니다.</p>");
    }
    out.println("</body></html>");

  }

  @RequestMapping("/lesson/delete")
  public void delete(ServletRequest request, ServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    PrintWriter out = response.getWriter();
    out.println("<html><head>" + "<title>수업 정보 삭제</title>"
        + "<meta http-equiv='Refresh' content='1;url=/lesson/list'>" + "</head>");
    out.println("<body><h1>수업 정보 삭제</h1>");

    if (lessonService.delete(no) == 0) {
      out.println("<p>해당 번호의 수업이 없습니다.</p>");
    } else {
      out.println("<p>삭제했습니다.</p>");
    }
    out.println("</body></html>");
  }

  @RequestMapping("/lesson/form")
  public void from(ServletRequest request, ServletResponse response) throws Exception {

    PrintWriter out = response.getWriter();


    out.println("<html>");
    out.println("<head><title>새 수업</title></head>");
    out.println("<body>");
    out.println("<h1>새 수업</h1>");
    out.println("<form action='/lesson/add'>");
    out.println("<table border='6'>");
    out.println("<tr>");
    out.println("  <th>수업</th>");
    out.println("  <td><input type='text' name='title'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>내용</th>");
    out.println("  <td><textarea name='contents' rows='5' cols='50'></textarea></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>시작일</th>");
    out.println("  <td><input type='date' name='startDate'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>종료일</th>");
    out.println("  <td><input type='date' name='endDate'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>총 교육시간</th>");
    out.println("  <td><input type='number' name='totalHours'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>일 교육시간</th>");
    out.println("  <td><input type='number' name='dayHours'></td>");
    out.println("</tr>");
    out.println("</tr>");
    out.println("</table>");
    out.println("<p>");
    out.println("  <button type='submit'>등록</button>");
    out.println("  <a href='/lesson/list'>목록</a>");
    out.println("</p>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");

  }
}
