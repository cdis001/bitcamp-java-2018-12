package ch26.d;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
  
  public static void main(String[] args) throws Exception {
    
    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/d/mybatis-config.xml");
    
    SqlSessionFactory sqlSessionFactory = 
        new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    List<Board> list = sqlSession.selectList("board.select1");
    
    for (Board b : list) {
      System.out.printf("%d, %s, %s, %s, %d \n",
          b.getBoardId(),
          b.getTitle(),
          b.getContents(),
          b.getCreated_date(),
          b.getView_count());
    }
    
    System.out.println("----------------------");
    
    //Board board = sqlSession.selectOne("board.select1");
    Board board = sqlSession.selectOne("board.select2");
    
    System.out.println(board);
  }
}
