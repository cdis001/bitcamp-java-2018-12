package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDetailApp {
  // 다음과 같이 게시물을 조회하는 프로그램을 작성하라!
  // ----------------------------
  // 번호? 1
  // 제목: aaa
  // 내용: aaaaa
  // 등록일: 2019-1-1
  // 조회수: 2
  // 
  // 번호? 100
  // 해당 번호의 게시물이 존재하지 않습니다.
  //----------------------------
  public static void main(String[] args) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      try (Statement stmt = con.createStatement();
          Scanner keyboard = new Scanner(System.in)) {
        System.out.print("번호? ");
        int no = keyboard.nextInt();
        
          try (ResultSet rs = stmt.executeQuery(
            "select * from x_board where board_id = " + no)) {
            if (rs.next()) {
              System.out.printf("제목: %s\n", rs.getString("title"));
              System.out.printf("내용: %s\n", rs.getString("contents"));
              System.out.printf("등록일: %s\n", rs.getString("created_date"));
              System.out.printf("조회수: %s\n", rs.getInt("view_count"));
            } else {
              System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
            }
        } catch (Exception e) {
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
