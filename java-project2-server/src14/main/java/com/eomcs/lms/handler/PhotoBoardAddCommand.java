package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardAddCommand extends AbstractCommand {

  PhotoBoardDao photoboardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.
  PhotoFileDao photoFileDao;

  public PhotoBoardAddCommand(
      PhotoBoardDao photoboardDao, PhotoFileDao photoFileDao) {
    this.photoboardDao = photoboardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void execute(Response response) throws Exception {

    PhotoBoard photoboard = new PhotoBoard();
    photoboard.setTitle(response.requestString("사진 제목?"));
    photoboard.setLessonNo(response.requestInt("레슨 번호?"));
    photoboardDao.insert(photoboard);

    response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
    response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

    
    int count = 0;
    while(true) {

      String filePath = response.requestString("사진 파일?");

      if (filePath.length() == 0) {
        if (count == 0) {
          response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
          continue;
        } else {
        break;
        }
      }
      PhotoFile file = new PhotoFile();
      file.setFilePath(filePath);
      file.setPhotoBoardNo(photoboard.getNo());

      photoFileDao.insert(file);
      count++;
    }
    
    response.println("저장하였습니다.");
    
//    ApplicationInitializer.con.commit();
  }
}
