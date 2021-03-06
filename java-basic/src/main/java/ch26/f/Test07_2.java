package ch26.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test07_2 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/f/mybatis-config.xml");

    SqlSessionFactory sqlSessionFactory = 
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();

    Scanner keyboard = new Scanner(System.in);
    HashMap<String, Object> params = new HashMap<>();

    System.out.print("정렬할 컬럼? ");
    String column = keyboard.nextLine();

    if(column.length() > 0) {

      switch (column) {
        case "title": 
        case "content": 
        case "created_date":
        case "view_count": 
          params.put("column", column);
          break;
        default:
          params.put("column", "board_id");
      }
      System.out.print("정렬방식? ");
      String sort = "asc";
      if(keyboard.nextLine().equalsIgnoreCase("desc")) {
        sort = "desc";
      }
      params.put("sort", sort);
    }
    keyboard.close();


    List<Board> boards = null;

    boards = sqlSession.selectList("board.select7_ok", params);

    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("--------------------------------");

  }
}
