package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.domain.Board;

public class BoardDetailCommand implements Command {

  Scanner keyboard;
  BoardDaoImpl boardDao;
  
  public BoardDetailCommand(Scanner keyboard, BoardDaoImpl boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {   
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Board board = boardDao.findByNo(no);
      System.out.printf("내용: %s\n", board.getContents());
      System.out.printf("작성일: %s\n", board.getCreatedDate());
    }catch (Exception e) {
      System.out.printf("게시글 상세정보 출력 오류: &s\n",e.getMessage());
    }

  }

}
