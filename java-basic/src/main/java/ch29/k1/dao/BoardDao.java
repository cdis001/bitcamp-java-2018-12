// 프록시 패턴 적용 - BoardDao에서 인터페이스를 추출한다.
package ch29.k1.dao;

import java.util.List;
import ch29.k1.vo.Board;

public interface BoardDao {
  int insert(Board board);
  List<Board> findAll();
  Board findByNo(int no);
  void updateVw(int no);
  int update(Board board);
  int delete(int no);
}







