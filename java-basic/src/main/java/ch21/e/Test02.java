package ch21.e;

import java.util.Scanner;

public class Test02 {
  
  public static void main(String[] args) throws Exception {
    Scanner keyboard = null;
    
    try {
      keyboard = new Scanner(System.in);
      System.out.println("값1? ");
      int a = Integer.parseInt(keyboard.nextLine());
      
      int result = sum(a);
      System.out.println(result);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      keyboard.close();
    }
  }
 static int sum (int value) {
   if (value == 1) {
     return 1;
   }
   return value + sum(value - 1);
 }
}






