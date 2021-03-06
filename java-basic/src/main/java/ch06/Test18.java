package ch06;

public class Test18 {
  public static void main(String[] args) {
    java.util.Properties props = System.getProperties();
    
    java.util.Set<Object> keySet = props.keySet(); //키가 들어있는 집합 리턴
    
    for (Object key : keySet) {
      String value = System.getProperty((String)key);
      System.out.printf("%s=%s\n", key, value);
    }
  }
}

