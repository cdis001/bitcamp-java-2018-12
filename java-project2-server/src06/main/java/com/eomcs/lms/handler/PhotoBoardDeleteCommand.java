package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;

public class PhotoBoardDeleteCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardDeleteCommand(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void execute(Response response) throws Exception {

    try {

      int no = response.requestInt("번호?");

      if (photoBoardDao.delete(no) == 0) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }
      response.println("삭제했습니다.");

    } catch (Exception e) {
      response.println(String.format("실행 오류! : %s\n", e.getMessage()));
    }
  }
}
