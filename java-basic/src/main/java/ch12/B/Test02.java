//캡슐화의 필요성
package ch12.B;

public class Test02 {
  public static void main(String[] args) {
    //클래스를 만든 개발자의 의도에 따라 잘 사용한 예
    Score s1 = new Score();
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 80;
    s1.compute();
    System.out.printf("총점: %d, 평균: %.1f\n", s1.getSum(), s1.getAver());
    
    
    
    //클래스를 만든 개발자의 의도에 벗어나 사용한 예
    Score s2 = new Score();
    s2.name = "홍길동";
    s2.kor = 100;
    s2.eng = 90;
    s2.math = 80;
    s2.compute();
    
    //s2.aver = 95.5f;
        
    System.out.printf("총점: %d, 평균: %.1f\n", s2.getSum(), s2.getAver());    
  }

}
