package ch26.e;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
  
  public static void main(String[] args) throws Exception {
    
    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/e/mybatis-config.xml");
    
    SqlSessionFactory sqlSessionFactory = 
        new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    List<Board> boards = sqlSession.selectList("board.select1");
    
    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("--------------------------------");
    
    Board board = sqlSession.selectOne("board.select2", 11);
    
    System.out.println(board);
    
    System.out.println("--------------------------------");
    
    List<Board> boards2 = sqlSession.selectList("board.select3","a");
    
    for (Board b : boards2) {
      System.out.println(b);
    }
    System.out.println("--------------------------------");
    
  }
}
