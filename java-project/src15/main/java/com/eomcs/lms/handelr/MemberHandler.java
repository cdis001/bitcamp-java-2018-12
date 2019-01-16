package com.eomcs.lms.handelr;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {
  
  public Scanner keyboard;
  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    //= new Scanner(System.in);
  }
  static final int LENGTH = 10;
  Member[] members = new Member[LENGTH];
  int memberIdx = 0;
  
  public void memberList() {
    for (int j = 0; j < this.memberIdx; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          this.members[j].getNo(), this.members[j].getName(), this.members[j].getEmail(), 
          this.members[j].getTel(), this.members[j].getRegisteredDate());}
  }
  public void memberAdd() {
    Member member = new Member();
    
    System.out.print("번호? ");
    member.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("이름? ");
    member.setName(keyboard.nextLine());
    
    System.out.print("이메일? ");
    member.setEmail(keyboard.nextLine());
    
    System.out.print("암호? ");
    member.setPassword(keyboard.nextLine());

    System.out.print("사진? ");
    member.setPhoto(keyboard.nextLine());

    System.out.print("전화? ");
    member.setTel(keyboard.nextLine());

    member.setRegisteredDate(new Date(System.currentTimeMillis())); 
    
    this.members[this.memberIdx] = member;
    this.memberIdx++;
    
    System.out.println("저장하였습니다.");
    
  }
}
