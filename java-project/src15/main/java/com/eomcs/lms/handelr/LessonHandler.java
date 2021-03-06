package com.eomcs.lms.handelr;

import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import java.sql.Date;

public class LessonHandler {
  
  public Scanner keyboard;
  public LessonHandler (Scanner keyboard){
    this.keyboard = keyboard;
  }
  static final int LENGTH = 10;
  Lesson[] lessons = new Lesson[LENGTH];
  int lessonIdx = 0;
  
  public void lessonList() {
    for (int j = 0; j < this.lessonIdx; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          this.lessons[j].getNo(), this.lessons[j].getTitle(), 
          this.lessons[j].getStartDate(), this.lessons[j].getEndDate(),
          this.lessons[j].getTotalHours());}
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

      // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
      this.lessons[this.lessonIdx] = lesson;
      this.lessonIdx++;

      System.out.println("저장하였습니다.");
      
    }
}
