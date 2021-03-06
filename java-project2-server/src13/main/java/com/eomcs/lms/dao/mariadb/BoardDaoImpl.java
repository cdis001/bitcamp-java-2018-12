// DBMS 적용
package com.eomcs.lms.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.DataSource;

public class BoardDaoImpl implements BoardDao {

  DataSource dataSource;
  SqlSessionFactory sqlSessionFactory;
  
  public BoardDaoImpl (DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  public BoardDaoImpl (SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  public List<Board> findAll() {
    
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      return sqlSession.selectList("BoardMapper.findAll");
    }
  }

  public void insert(Board board) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      sqlSession.update("BoardMapper.insert", board);
      sqlSession.commit();
    }
  }

  public Board findByNo(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      sqlSession.update("BoardMapper.updateVw", no);
      sqlSession.commit();
      return sqlSession.selectOne("BoardMapper.findByNo", no);
    }
  }

  public int update(Board board) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      int count = sqlSession.update("BoardMapper.update", board);
      sqlSession.commit();
      return count;
    } 
  }

  public int delete(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      int count = sqlSession.delete("BoardMapper.delete", no);
      sqlSession.commit();
      return count;
    }
  }
}









