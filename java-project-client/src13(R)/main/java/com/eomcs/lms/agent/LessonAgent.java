package com.eomcs.lms.agent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonAgent {

  String serverAddr;
  int port;
  String rootpath;

  public LessonAgent(String serverAddr, int port, String rootpath) {
    this.serverAddr = serverAddr;
    this.port = port;
    this.rootpath = rootpath;
  }

  @SuppressWarnings("unchecked")
  public List<Lesson> list () throws Exception {
    try(Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
      out.writeUTF("/lesson/list");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 찾지 못 하였습니다");

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("데이터 목록 가져오기 실패");
      }
      return (List<Lesson>) in.readObject();
    }
  }

  public void add(Lesson lesson) throws Exception{
    try(Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
      out.writeUTF("/lesson/add");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");
      out.writeObject(lesson);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버에서 저장 실패");
      }
    }
  }

  public Lesson get(int no) throws Exception{
    try(Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
      out.writeUTF("/lesson/detail");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");
      out.writeInt(no);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버에서 게시글 가져오기 실패");
      }
      return (Lesson) in.readObject();
    }
  }

  public void update(Lesson lesson) throws Exception {
    try(Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
      out.writeUTF("/lesson/update");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeObject(lesson);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK")) 
        throw new Exception("서버에서 변경하기 실패!");
    }
  }

  public void delete(int no) throws Exception{
    try(Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
      out.writeUTF("/lesson/delete");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");
      out.writeInt(no);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버에서 데이터 가져오기 실패");
      }
    }
  }

} // class
