package ch28.b;

import java.lang.annotation.Annotation;

@MyAnnotation
@MyAnnotation2
@MyAnnotation3
public class Test01 {
  public static void main(String[] args) {
    Class<?> clazz = Test01.class;
    Annotation[] annotation = clazz.getAnnotations();
    
    for (Annotation a : annotation) {
      System.out.println(a.annotationType().getName());
    }
  }
}
