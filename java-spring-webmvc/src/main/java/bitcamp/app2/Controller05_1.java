package bitcamp.app2;

import java.sql.Date;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

@Controller
@RequestMapping("/c05_1")
public class Controller05_1 {

  ArrayList<Board> list = new ArrayList<>();

  public Controller05_1() {
    list.add(new Board(1, "제목입니다1", "내용1", "홍길동1", 10, Date.valueOf("2019-05-01")));
    list.add(new Board(2, "제목입니다2", "내용2", "홍길동2", 11, Date.valueOf("2019-05-02")));
    list.add(new Board(3, "제목입니다3", "내용3", "홍길동3", 12, Date.valueOf("2019-05-03")));
    list.add(new Board(4, "제목입니다4", "내용4", "홍길동4", 13, Date.valueOf("2019-05-04")));
    list.add(new Board(5, "제목입니다5", "내용5", "홍길동5", 14, Date.valueOf("2019-05-05")));
    list.add(new Board(6, "제목입니다6", "내용6", "홍길동6", 15, Date.valueOf("2019-05-06")));
    list.add(new Board(7, "제목입니다7", "내용7", "홍길동7", 16, Date.valueOf("2019-05-07")));
    list.add(new Board(8, "제목입니다8", "내용8", "홍길동8", 17, Date.valueOf("2019-05-08")));
    list.add(new Board(9, "제목입니다9", "내용9", "홍길동9", 18, Date.valueOf("2019-05-09")));
    list.add(new Board(10, "제목입니다10", "내용10", "홍길동10", 19, Date.valueOf("2019-05-10")));
    list.add(new Board(11, "제목입니다11", "내용11", "홍길동11", 20, Date.valueOf("2019-05-11")));
    list.add(new Board(12, "제목입니다12", "내용12", "홍길동12", 21, Date.valueOf("2019-05-12")));
    list.add(new Board(13, "제목입니다13", "내용13", "홍길동13", 22, Date.valueOf("2019-05-13")));
  }

  // http://localhost:8080/java-spring-webmvc/app2/c05_1/h1
  @GetMapping("h1")
  public void handler1(Model model) {
    model.addAttribute("list", this.list);
  }

  // http://localhost:8080/java-spring-webmvc/app2/c05_1/h2
  @GetMapping(value = "h2", produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2() {
    return new Gson().toJson(this.list);
  }

  // http://localhost:8080/java-spring-webmvc/app2/c05_1/h3
  @GetMapping(value = "h3")
  @ResponseBody
  public Object handler3() {
    return this.list;
  }
}
