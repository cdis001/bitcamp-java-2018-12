package com.eomcs.lms.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDaoImpl implements PhotoBoardDao {

  SqlSessionFactory sqlSessionFactory;

  public PhotoBoardDaoImpl (SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<PhotoBoard> findAll() {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("PhotoBoardMapper.findAll");
    }
  }

  @Override
  public void insert(PhotoBoard photoBoard) {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      sqlSession.update("PhotoBoardMapper.insert", photoBoard);
      sqlSession.commit();
    }
  }

  @Override
  public PhotoBoard findByNo(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      sqlSession.update("PhotoBoardMapper.updateVw", no);
      sqlSession.commit();
      return sqlSession.selectOne("PhotoBoardMapper.findByNo", no);
    }
  }
  
  @Override
  public PhotoBoard findByNoWithFile(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      sqlSession.update("PhotoBoardMapper.updateVw", no);
      sqlSession.commit();
      return sqlSession.selectOne("PhotoBoardMapper.findByNoWithFile", no);
    }
  }


  @Override
  public int update(PhotoBoard photoBoard) {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      int count = sqlSession.update("PhotoBoardMapper.update", photoBoard);
      sqlSession.commit();
      return count;
    } 
  }

  @Override
  public int delete(int no) {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      int count = sqlSession.delete("PhotoBoardMapper.delete", no);
      sqlSession.commit();
      return count;
    }
  }
}
