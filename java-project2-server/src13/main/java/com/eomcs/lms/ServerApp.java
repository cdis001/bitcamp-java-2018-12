// 1단계: 클라이언트 요청에 응답하는 서버 프로그램으로 전환하기
//
//클라이언트와 서버 사이의 통신 규칙
//
//규칙1) 단순한 명령어 전송과 실행 결과 수신
//[클라이언트]                                        [서버]
//서버에 연결 요청        -------------->           연결 승인
//명령(CRLF)              -------------->           명령처리
//화면 출력               <--------------           응답(CRLF)
//화면 출력               <--------------           응답(CRLF)
//명령어 실행 완료        <--------------           !end!(CRLF)
//
//규칙2) 사용자 입력을 포함하는 경우
//[클라이언트]                                        [서버]
//서버에 연결 요청        -------------->           연결 승인
//명령(CRLF)              -------------->           명령처리
//화면 출력               <--------------           응답(CRLF)
//사용자 입력 요구        <--------------           !{}!(CRLF)
//입력값(CRLF)            -------------->           입력 값 처리
//화면 출력               <--------------           응답(CRLF)
//사용자 입력 요구        <--------------           !{}!(CRLF)
//입력값(CRLF)            -------------->           입력 값 처리
//명령어 실행 완료        <--------------           !end!(CRLF)
//
package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.handler.Command;
import com.eomcs.util.DataSource;

public class ServerApp {

  // ApplicationContextListener(옵저버) 목록을 보관할 객체
  ArrayList<ApplicationContextListener> listeners = new ArrayList<>();
  static HashMap<String,Object> context = new HashMap<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void service() throws Exception {

    try (ServerSocket ss = new ServerSocket(8888)) {

      // App에서 사용할 객체를 보관하는 저장소


      // 애플리케이션을 시작할 때, 등록된 리스너에게 알려준다.
      for (ApplicationContextListener listener : listeners) {
        listener.contextInitialized(context);
      }

      System.out.println("서버 실행 중...");

      while (true) {

        new RequestHandlerThread(ss.accept()).start();

      } // while

      // 애플리케이션을 종료할 때, 등록된 리스너에게 알려준다.
      /*
      for (ApplicationContextListener listener : listeners) {
        listener.contextDestroyed(context);
      }
       */
    } catch (Exception e) {
      e.printStackTrace();
    } // try(ServerSocket)

  }

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp();

    // App이 실행되거나 종료될 때 보고를 받을 옵저버를 등록한다.
    app.addApplicationContextListener(new ApplicationInitializer());

    // App 을 실행한다.
    app.service();
  }

  static class RequestHandlerThread extends Thread {

    Socket socket;

    public RequestHandlerThread(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {

      DataSource dataSource = (DataSource) context.get("dataSource");

      Connection con = dataSource.getConnection();
      
      try (Socket socket = this.socket;
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream())) {

        // 클라이언트의 요청 읽기
        String request = in.readLine();

        Command commandHandler = (Command) context.get(request);
        if (commandHandler == null) {
          out.println("실행할 수 없는 명령입니다.");
          out.println("!end!");
          out.flush();
          return;
        }

        try {
          commandHandler.execute(in, out);
          con.commit();
        } catch (Exception e) {
          try {
            con.rollback();
          } catch (SQLException e1) {
          }
          out.println("실행 오류: " + e.getMessage());
        }
        out.println("!end!");
        out.flush();

      } catch (Exception e) {

        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
        e.printStackTrace();
      } finally {
        dataSource.returnConnection(con);
      }
    }
  }
}









