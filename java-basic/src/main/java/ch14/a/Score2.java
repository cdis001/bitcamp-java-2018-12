package ch14.a;

public class Score2 extends Score {
  protected int music;
  protected int art;
  
  @Override
  public void compute() {
    this.sum = this.kor + this.eng + this.math + this.art + this.music;
    this.aver = this.sum / 5f;
  }
}
