package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public MemberUpdateCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }


  @Override
  public void execute(Response response) throws Exception {

    try(SqlSession sqlSession = sqlSessionFactory.openSession()) {

      MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
      int no = response.requestInt("번호?");

      Member member = memberDao.findByNo(no);
      if (member == null) {
        response.println("해당 번호의 회원이 없습니다.");
        return;
      }

      Member temp = new Member();
      temp.setNo(no);

      String input = response.requestString(String.format(
          "이름(%s)? ", member.getName()));
      if (input.length() > 0) 
        temp.setName(input);

      if ((input = response.requestString(String.format(
          "이메일(%s)? ", member.getEmail()))).length() > 0)
        temp.setEmail(input);

      if ((input = response.requestString(String.format(
          "암호(*필수입력*)? "))).length() > 0)
        temp.setPassword(input);

      if ((input = response.requestString(String.format(
          "사진(%s)? ", member.getPhoto()))).length() > 0)
        temp.setPhoto(input);

      if ((input = response.requestString(String.format(
          "전화(%s)? ", member.getTel()))).length() > 0)
        temp.setTel(input);

      if (temp.getName() != null
          ||temp.getEmail() != null
          ||temp.getPassword() != null
          ||temp.getPhoto() != null
          ||temp.getTel() != null) {

        memberDao.update(temp);
        sqlSession.commit();
        response.println("변경했습니다.");
      } else {
        response.println("변경을 취소하였습니다.");
      }
    }

  }
}
