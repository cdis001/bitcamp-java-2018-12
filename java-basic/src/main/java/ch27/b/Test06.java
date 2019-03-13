package ch27.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class Test06 {

  public static void main(String[] args) throws Exception {
    Class<?> clazz = String.class;
    
    Constructor[] constructors = clazz.getConstructors();
    for (Constructor c : constructors) {
      System.out.printf("%s()\n", c.getName());
      
      Parameter[] params = c.getParameters();
      for (Parameter p : params) {
        System.out.printf("%s:%s\n", 
            p.getName(),
            p.getType().getSimpleName());
      }
      System.out.println("------------------------------");
    }
    
  }
}