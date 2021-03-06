package com.eomcs.lms.handler;
import com.eomcs.lms.context.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@Component("/board/detail")
public class BoardDetailCommand extends AbstractCommand {
  
  BoardDao boardDao;
  
  public BoardDetailCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    
    int no = response.requestInt("번호?");
    
      Board board = boardDao.findByNo(no);
      if (board == null) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }
      boardDao.updateVw(no);
      response.println(String.format("내용: %s", board.getContents()));
      response.println(String.format("작성일: %s", board.getCreatedDate()));
      response.println(String.format("조회수: %d\n", board.getViewCount()));

  }
}
