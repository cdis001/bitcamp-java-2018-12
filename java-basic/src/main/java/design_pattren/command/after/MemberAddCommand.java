package design_pattren.command.after;

public class MemberAddCommand implements Command {

  @Override
  public void execute() {
      System.out.println("회원 입력 처리!");
  }

}
