package ch29.f;

import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {

    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/f/application-context-01.xml");
    
    System.out.println("---------------------------");
    
    System.out.println(iocContainer.getBean("c1"));

    Date obj = (Date) iocContainer.getBean("d1");
    System.out.println(obj);
  }
}






