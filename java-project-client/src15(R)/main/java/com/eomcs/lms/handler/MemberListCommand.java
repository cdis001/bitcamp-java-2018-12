package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.proxy.MemberDaoProxy;

public class MemberListCommand implements Command {
  
  Scanner keyboard;
  MemberDaoProxy memberDaoProxy;
  
  public MemberListCommand(Scanner keyboard, MemberDaoProxy memberDaoProxy) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    try {
      List<Member> members = memberDaoProxy.findAll();
    for (Member member : members) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          member.getNo(), member.getName(), 
          member.getEmail(), member.getTel(), member.getRegisteredDate());
    }
    } catch (Exception e) {
      System.out.printf("게시글 목록 출력 오류: &s\n",e.getMessage());
    }
  }
}
