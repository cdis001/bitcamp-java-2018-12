package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

  MemberDao memberDao;

  public MemberServiceImpl(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public List<Member> list(String searchWord, int pageNo, int pageSize) {

    if (searchWord == null) {
      HashMap<String, Object> params = new HashMap<String, Object>();
      params.put("size", pageSize);
      params.put("rowNo", (pageNo - 1) * pageSize);
      return memberDao.findAll(params);
    } else {
      return memberDao.findBykeyword(searchWord);
    }
  }

  @Override
  public int add(Member member) {
    return memberDao.insert(member);
  }

  @Override
  public Member get(int no) {
    return memberDao.findByNo(no);
  }

  @Override
  public int update(Member member) {
    return memberDao.update(member);
  }

  @Override
  public int delete(int no) {
    return memberDao.delete(no);
  }

  @Override
  public Member get(String email, String password) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("password", password);
    return memberDao.findByEmailPassword(paramMap);
  }

  @Override
  public int size() {
    return memberDao.countAll();
  }

  @Override
  public Member get(String email) {
    return memberDao.findByEmail(email);
  }

}
