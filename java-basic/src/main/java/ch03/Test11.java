package ch03;

public class Test11 {
  public static void main(String[] args) {
  //배열을 가르킬 레퍼런스 생성
    int[] arr1; //자바 스타일. 
    int arr2[]; //C언어 스타일. C에서는 []안에 값을 바로 지정해서 만듦; 자바에서는 오류
  //arr0[0] = 100; <-초기화 하지 않고 사용했기 때문에 생기는 오류
    
    arr1 = null; //null = 0 특정 메모리를 가리키지 않는 상태를 표시함
    arr1[0] = 100; //
    
  //배열을 만들지도 않고 레퍼런스를 사용하면 오류
    
    
  //배열을 생성하고 그 주소를 레퍼런스에 담음
    arr1 = new int[5];
    arr2 = new int[5];
  
  //배열에 값을 담기 -배열 레퍼런스를 사용하여 메모리를 지정함
    arr1[0] = 100;
    arr1[1] = 90;
    arr1[2] = 80;
    arr1[3] = 70;
    arr1[4] = 60;
    //arr1[-1] = 120; 배열의 인덱스가 범위를 벗어난 예외발생 오류!
  
  }
}
