package ch22.f;

import java.io.Serializable;

public class Score3 implements Serializable {
  
  private static final long serialVersionUID = 100L;
  
  private String name;
  private String tel;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;
  
  
  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Score3() {
    System.out.println("Score()");
  }
  
  public Score3(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    compute();
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
    this.compute();
  }


  public int getKor() {
    return kor;
  }


  public void setKor(int kor) {
    this.kor = kor;
    this.compute();
  }


  public int getEng() {
    return eng;
  }


  public void setEng(int eng) {
    this.eng = eng;
    this.compute();
  }


  public int getMath() {
    return math;
  }


  public void setMath(int math) {
    this.math = math;
    this.compute();
  }


  public int getSum() {
    return sum;
  }


  public float getAver() {
    return aver;
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = sum / 3f;
  }

  @Override
  public String toString() {
    return "Score2 [name=" + name + ", tel=" + tel + ", kor=" + kor + ", eng=" + eng + ", math="
        + math + ", sum=" + sum + ", aver=" + aver + "]";
  }



}
