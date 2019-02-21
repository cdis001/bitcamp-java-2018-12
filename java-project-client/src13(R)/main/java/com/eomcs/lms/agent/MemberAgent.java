package com.eomcs.lms.agent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberAgent {

  String serverAdds;
  int port;
  String rootpath;

  public MemberAgent(String serverAdds, int port, String rootpath) {
    this.serverAdds = serverAdds;
    this.port = port;
    this.rootpath = rootpath;
  }

  @SuppressWarnings("unchecked")
  public List<Member> list() throws Exception {
    try(Socket socket = new Socket(this.serverAdds, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
      out.writeUTF("/member/list");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버에서 목록 가져오기 실패");

      }
      return (List<Member>) in.readObject();
    }
  }

  public void add(Member member) throws Exception{
    try(Socket socket = new Socket(this.serverAdds, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
      out.writeUTF("/member/add");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");
      out.writeObject(member);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버의 데이터 저장 실패!");
      }
    }
  }

  public Member get(int no) throws Exception{
    try(Socket socket = new Socket(this.serverAdds, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
      out.writeUTF("/member/detail");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");
      out.writeInt(no);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버에서 게시글 가져오기 실패");
      }
      return (Member) in.readObject();
    }
  }

  public void update(Member member) throws Exception{
    try(Socket socket = new Socket(this.serverAdds, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
      out.writeUTF("/member/update");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeObject(member);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) 
        throw new Exception("서버에서 게시글 변경하기 실패!");
    }
  }

  public void delete(int no) throws Exception{
    try(Socket socket = new Socket(this.serverAdds, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
      out.writeUTF("/member/delete");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");
      out.writeInt(no);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버에서 게시글 가져오기 실패");
      }
    }
  }

} // class
