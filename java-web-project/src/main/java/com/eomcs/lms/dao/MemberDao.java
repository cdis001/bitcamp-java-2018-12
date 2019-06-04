// 프록시 패턴 적용 - MemberDao에서 인터페이스를 추출한다.
package com.eomcs.lms.dao;

import java.util.List;
import java.util.Map;
import com.eomcs.lms.domain.Member;

public interface MemberDao {
  int insert(Member member);

  List<Member> findAll(Map<String, Object> params);

  List<Member> findBykeyword(String keyword);

  Member findByNo(int no);

  Member findByEmailPassword(Map<String, Object> paramMap);

  Member findByEmail(String email);

  int update(Member member);

  int delete(int no);

  int countAll();
}


