package ch22.e;

public class Score {
  
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;
  
  
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public int getKor() {
    return kor;
  }


  public void setKor(int kor) {
    this.kor = kor;
  }


  public int getEng() {
    return eng;
  }


  public void setEng(int eng) {
    this.eng = eng;
  }


  public int getMath() {
    return math;
  }


  public void setMath(int math) {
    this.math = math;
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
    return "Test01 [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
        + sum + ", aver=" + aver + "]";
  }


}
