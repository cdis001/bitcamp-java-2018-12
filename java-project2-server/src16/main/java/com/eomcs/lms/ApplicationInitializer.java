package com.eomcs.lms;

import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.context.ApplicationContextException;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberSearchCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;
import com.eomcs.lms.handler.PhotoBoardAddCommand;
import com.eomcs.lms.handler.PhotoBoardDeleteCommand;
import com.eomcs.lms.handler.PhotoBoardDetailCommand;
import com.eomcs.lms.handler.PhotoBoardListCommand;
import com.eomcs.lms.handler.PhotoBoardSearchCommand;
import com.eomcs.lms.handler.PhotoBoardUpdateCommand;
import com.eomcs.mybatis.DaoFactroy;
import com.eomcs.mybatis.SqlSessionFactoryProxy;
import com.eomcs.mybatis.TransactionManager;

public class ApplicationInitializer implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    try {
      SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(
            Resources.getResourceAsStream(
                "com/eomcs/lms/conf/mybatis-config.xml"));
      
      SqlSessionFactoryProxy sqlSessionFactoryProxy = 
          new SqlSessionFactoryProxy(sqlSessionFactory);
      
      TransactionManager txManager = new TransactionManager(sqlSessionFactoryProxy);
      
      DaoFactroy daoFactory = new DaoFactroy(sqlSessionFactoryProxy);
      
      BoardDao boardDao = daoFactory.create(BoardDao.class);
      LessonDao lessonDao = daoFactory.create(LessonDao.class);
      MemberDao memberDao = daoFactory.create(MemberDao.class);
      PhotoBoardDao photoBoardDao = daoFactory.create(PhotoBoardDao.class);
      PhotoFileDao photoFileDao = daoFactory.create(PhotoFileDao.class);
      
      context.put("/lesson/add", new LessonAddCommand(lessonDao));
      context.put("/lesson/list", new LessonListCommand(lessonDao));
      context.put("/lesson/detail", new LessonDetailCommand(lessonDao));
      context.put("/lesson/update", new LessonUpdateCommand(lessonDao));
      context.put("/lesson/delete", 
          new LessonDeleteCommand(lessonDao, 
              photoBoardDao, 
              photoFileDao,
              txManager));

      
      context.put("/member/add", new MemberAddCommand(memberDao));
      context.put("/member/list", new MemberListCommand(memberDao));
      context.put("/member/detail", new MemberDetailCommand(memberDao));
      context.put("/member/update", new MemberUpdateCommand(memberDao));
      context.put("/member/delete", new MemberDeleteCommand(memberDao));
      context.put("/member/search", new MemberSearchCommand(memberDao));
      
      context.put("/board/add", new BoardAddCommand(boardDao));
      context.put("/board/list", new BoardListCommand(boardDao));
      context.put("/board/detail", new BoardDetailCommand(boardDao));
      context.put("/board/update", new BoardUpdateCommand(boardDao));
      context.put("/board/delete", new BoardDeleteCommand(boardDao));
      
      context.put("/photoboard/add", 
          new PhotoBoardAddCommand(photoBoardDao, photoFileDao, txManager));
      context.put("/photoboard/list", 
          new PhotoBoardListCommand(photoBoardDao));
      context.put("/photoboard/detail", 
          new PhotoBoardDetailCommand(photoBoardDao, photoFileDao));
      context.put("/photoboard/update", 
          new PhotoBoardUpdateCommand(photoBoardDao, photoFileDao, txManager));
      context.put("/photoboard/delete", 
          new PhotoBoardDeleteCommand(photoBoardDao, photoFileDao, txManager));
      context.put("/photoboard/search", 
          new PhotoBoardSearchCommand(photoBoardDao));
      
    } catch (Exception e) {
      throw new ApplicationContextException(e);
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
  }
}






