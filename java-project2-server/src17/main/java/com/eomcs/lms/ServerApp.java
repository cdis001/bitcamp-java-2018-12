package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.handler.Command;

public class ServerApp {

  ArrayList<ApplicationContextListener> listeners = new ArrayList<>();
  static HashMap<String,Object> context = new HashMap<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void service() throws Exception {

    try (ServerSocket ss = new ServerSocket(8888)) {

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
        } catch (Exception e) {
          System.out.println("실행 오류: " + e.getMessage());
        }
        out.println("!end!");
        out.flush();

      } catch (Exception e) {

        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
        e.printStackTrace();
      } 
    }
  }
}









