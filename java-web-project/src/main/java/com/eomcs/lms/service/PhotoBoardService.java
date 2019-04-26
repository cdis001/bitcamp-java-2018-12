package com.eomcs.lms.service;

import java.util.List;
import com.eomcs.lms.domain.PhotoBoard;

public interface PhotoBoardService {
  List<PhotoBoard> list(int lessonNo, String searchWord, int pageNo, int pageSize);

  int add(PhotoBoard photoBoard);

  PhotoBoard get(int no);

  int update(PhotoBoard PhotoBoard);

  int delete(int no);

  int size();
}
