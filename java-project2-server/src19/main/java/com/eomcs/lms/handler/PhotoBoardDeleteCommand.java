package com.eomcs.lms.handler;
import com.eomcs.lms.context.Component;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.mybatis.TransactionManager;

@Component("/photoboard/delete")
public class PhotoBoardDeleteCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  TransactionManager txManager;

  public PhotoBoardDeleteCommand(
      PhotoBoardDao photoBoardDao,
      PhotoFileDao photoFileDao,
      TransactionManager txManager) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.txManager = txManager;
  }

  @Override
  public void execute(Response response) throws Exception {
    
    txManager.beginTransaction();
    try {

      int no = response.requestInt("번호?");
      
      photoFileDao.deleteByPhotoBoardNo(no);

      if (photoBoardDao.delete(no) == 0) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }
      
      response.println("삭제했습니다.");
      txManager.commit();

    } catch (Exception e) {
      response.println(String.format("실행 오류! : %s\n", e.getMessage()));
      txManager.rollback();
    }
  }
}
