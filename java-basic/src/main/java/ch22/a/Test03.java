package ch22.a;

import java.io.File;

public class Test03 {
  public static void main(String[] args) throws Exception {
    
    File dir = new File("temp");
    if (dir.mkdir()) {
      System.out.println("디렉토리 생성 성공!");
    } else {
      System.out.println("디렉토리 생성 실패");
    }
    
    dir = new File("temp2/ok");
    if (dir.mkdir()) {
      System.out.println("ok 디렉토리 생성 성공!");
    } else {
      System.out.println("ok 디렉토리 생성 실패");
    }
    
  }
}
