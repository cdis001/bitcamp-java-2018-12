package ch23.d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
  public static void main(String[] args) {
    
    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");
      
      while (true) {
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());) {
          
          System.out.println("클라이언트와 연결됨! 요청 처리중...");
          
          String[] input = in.readLine().split(" ");
          
          int a = 0;
          String op = null;
          int b = 0;
          int result = 0;
          
          try {
            a = Integer.parseInt(input[0]);
            op = input[1];
            b = Integer.parseInt(input[2]);
          } catch (Exception e ) {
            e.printStackTrace();
          }
          switch (op) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = a / b; break;
            case "%": result = a % b; break;
            default:
              out.printf("%s 연산자를 지원하지 않습니다.\n", op);
              out.flush();
              continue;
          }
          
          out.printf("결과는 %d 입니다.\n", result);
          out.flush();
        } catch (Exception e) {
          System.out.println("클라이언트와 통신중 오류 발생");
        }
        System.out.println("클라이언트와 연결 끊음");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
