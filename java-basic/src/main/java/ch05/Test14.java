package ch05;

public class Test14 {
  public static void main(String[] args) {
    String[] names = {"홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구"};
    
    for (int i = 0; i < names.length; i++) {
      System.out.print(names[i] + " ");
    }
    System.out.println();
    for (int i = 2; i < names.length; i++) {
      System.out.print(names[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < names.length; i+=2) {
      System.out.print(names[i] + " ");
    }
    System.out.println();
  } //end main
} //end class
