package bitcamp.app2;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/c03_2")
@SessionAttributes({/* "name", "age", */"name2", "age2"})
public class Controller03_2 {

  // http://localhost:8080/java-spring-webmvc/app2/c03_2/h1
  @GetMapping(value = "h1", produces = "text/plain;charset=utf-8")
  @ResponseBody
  public String handler1(Model model) {

    model.addAttribute("name2", "임꺽정");
    model.addAttribute("age2", 30);
    model.addAttribute("tel2", "1111-2222");
    return "세션에 값 보관!";
  }

  // http://localhost:8080/java-spring-webmvc/app2/c03_2/h2
  @GetMapping(value = "h2", produces = "text/plain;charset=utf-8")
  @ResponseBody
  public String handler2(HttpSession session) {

    return String.format("name2: %s, age2: %s, tel2: %s \n", session.getAttribute("name2"),
        session.getAttribute("age2"), session.getAttribute("tel2"));
  }


  // http://localhost:8080/java-spring-webmvc/app2/c03_2/h3
  // http://localhost:8080/java-spring-webmvc/app2/c03_2/h3?tel2=1111-1111
  @GetMapping(value = "h3", produces = "text/plain;charset=utf-8")
  @ResponseBody
  public String handler3(@ModelAttribute("name2") String name2, @ModelAttribute("age2") String age2,
      @ModelAttribute("tel2") String tel2) {

    return String.format("name2: %s, age2: %s, tel2: %s \n", name2, age2, tel2);
  }

  // 1. http://localhost:8080/java-spring-webmvc/app2/c03_1/h1
  // 2. http://localhost:8080/java-spring-webmvc/app2/c03_2/h1
  // 3. http://localhost:8080/java-spring-webmvc/app2/c03_2/h4
  @GetMapping(value = "h4", produces = "text/plain;charset=utf-8")
  @ResponseBody
  public String handler4(@ModelAttribute("name") String name, @ModelAttribute("age") String age,
      @ModelAttribute("name2") String name2, @ModelAttribute("age2") String age2) {

    return String.format("name: %s, age: %s, name2: %s, age2: %s \n", name, age, name2, age2);
  }
}
