package bitcamp.app2;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c04_1")
public class Controller04_1 {

  // http://localhost:8080/java-spring-webmvc/app2/c04_1/h1
  @GetMapping("h1")
  public String handler1(HttpSession session) {
    System.out.println("c04_1.handler1() 호출!");
    return "c04_1";
  }

  // http://localhost:8080/java-spring-webmvc/app2/c04_1/a/h2
  @GetMapping("a/h2")
  public String handler2(HttpSession session) {
    System.out.println("c04_2.handler1() 호출!");
    return "c04_1";
  }

  // http://localhost:8080/java-spring-webmvc/app2/c04_1/b/h3
  @GetMapping("b/h3")
  public String handler3(HttpSession session) {
    System.out.println("c04_3.handler1() 호출!");
    return "c04_1";
  }
}
