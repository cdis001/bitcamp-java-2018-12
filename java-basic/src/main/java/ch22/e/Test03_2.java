package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Test03_2 {
 
  public static void main(String[] args) {
    ArrayList<Score> students = new ArrayList<>();
    
    try(DataInputStream in2 = 
        new DataInputStream(new BufferedInputStream
            (new FileInputStream("score.data")))) {
      
      int len = in2.readInt();
      
      for(int i = 0; i < len; i++) {
        
      Score s = new Score();
      s.setName(in2.readUTF());
      s.setKor(in2.readInt());
      s.setEng(in2.readInt());
      s.setMath(in2.readInt());
      students.add(s);
      }
      
      for(Score s : students) {
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
          s.getName(), s.getKor(), s.getEng(), s.getMath(),
          s.getSum(), s.getAver());
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    
    System.out.println("출력완료!");
  }
    
  }


