package com.eomcs.lms.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@RequestMapping("/board")
@Controller
public class BoardController {

  @Autowired
  BoardService boardService;

  @GetMapping("form")
  public void form() throws Exception {}

  @PostMapping("add")
  public String add(Board board) throws Exception {

    boardService.add(board);

    return "redirect:.";
  }

  @GetMapping("delete/{no}")
  public String delete(@PathVariable int no) throws Exception {

    if (boardService.delete(no) == 0) {
      throw new RuntimeException("해당 번호의 게시물이 없습니다.");
    }
    return "redirect:../";
  }


  @GetMapping("{no}")
  public String detail(@PathVariable int no, Model model) throws Exception {

    Board board = boardService.get(no);

    model.addAttribute("board", board);

    return "board/detail";
  }


  @GetMapping
  public String list(Model model) throws Exception {

    List<Board> boards = boardService.list();

    model.addAttribute("list", boards);

    return "board/list";
  }

  @PostMapping("update")
  public String update(Board board) throws Exception {

    if (boardService.update(board) == 0) {
      throw new Exception("해당 번호의 게시물이 없습니다.");
    }
    return "redirect:.";
  }
}


