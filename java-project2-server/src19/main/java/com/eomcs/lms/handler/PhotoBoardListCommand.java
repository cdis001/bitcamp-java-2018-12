package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.context.Component;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

@Component("/photoboard/list")
public class PhotoBoardListCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardListCommand(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void execute(Response response) throws Exception {

    List<PhotoBoard> boards = photoBoardDao.findAll(null);

    for (PhotoBoard photoboard : boards) {
      response.println(
          String.format("%3d, %-20s, %s, %d, %d", 
              photoboard.getNo(), photoboard.getTitle(), 
              photoboard.getCreatedDate(), photoboard.getViewCount(),
              photoboard.getLessonNo()));
    }

  }

}
