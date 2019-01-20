package com.eomcs.lms.handelr;

import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import java.sql.Date;

public class LessonHandler {
  
  public Scanner keyboard;
  public ArrayList list;
  public LessonHandler (Scanner keyboard){
    this.keyboard = keyboard;
    list = new ArrayList();
  }

  
  public void lessonList() {
    Object[] objs = list.toArray();
    for (Object obj : objs) {
      Lesson lesson = (Lesson)obj;
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson.getNo(), lesson.getTitle(), 
          lesson.getStartDate(), lesson.getEndDate(),
          lesson.getTotalHours());}
  }
    public void lessonAdd() {
      Lesson lesson = new Lesson();

      System.out.print("번호? ");
      lesson.setNo(Integer.parseInt(keyboard.nextLine()));

      System.out.print("수업명? ");
      lesson.setTitle(keyboard.nextLine());

      System.out.print("설명? ");
      lesson.setContents(keyboard.nextLine());

      System.out.print("시작일? ");
      lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

      System.out.print("종료일? ");
      lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

      System.out.print("총수업시간? ");
      lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

      System.out.print("일수업시간? ");
      lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

      list.add(lesson);

      System.out.println("저장하였습니다.");
      
    }
}
