package design_pattren.observer.after2;

public class BreakOilCarObserver extends AbstractCarObserver {

  @Override
  public void carStarted() {
    System.out.println("브레이크 오일 유무 검사");
    
  }


}
