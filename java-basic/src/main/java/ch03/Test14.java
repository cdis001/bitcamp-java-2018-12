package ch03;

public class Test14 {
  public static void main(String[] args) {
    
    int[] arr1 = {101, 102, 103, 104, 105};
    int[] arr2 = {81, 82, 83, 84, 85};
    
    arr2 = arr1; //arr2의 주소값은 garbage가 됨
    
    System.out.printf("%d, %d\n", arr1[1], arr2[2]);
    
    arr1[1] = 500;
    
    System.out.printf("%d, %d\n", arr1[1], arr2[1]);
    
    
  }
  

}
