package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c01_1")
public class controller01_1 {

  @RequestMapping
  @ResponseBody
  public String handler1() {
    return "c01_1";
  }
/*
  @RequestMapping
  @ResponseBody
  public String handler2() {
    return "c01_1";
  }
  */
}
