package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.proxy.BoardDaoProxy;

public class BoardUpdateCommand implements Command {

  Scanner keyboard;
  BoardDaoProxy boardDao;
  
  public BoardUpdateCommand(Scanner keyboard, BoardDaoProxy boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Board board = boardDao.findByNo(no);

      // 기존 값 복제
      Board temp = board.clone();

      System.out.printf("내용? ");
      String input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setContents(input);

      boardDao.update(temp);

      System.out.println("게시글을 변경했습니다.");

    } catch (Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
  }
}
