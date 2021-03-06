package ch23.b;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {

  public static void main(String[] args) {
    try (Socket socket = new Socket("192.168.0.54", 8888);
        DataOutputStream out = new DataOutputStream(
            new BufferedOutputStream(socket.getOutputStream()));
        Scanner in = new Scanner(socket.getInputStream());
        ) {

      System.out.println("서버와 연결됨");
      
      File file = new File("temp/test01.mp4");
      try(BufferedInputStream fileIn 
          = new BufferedInputStream(new FileInputStream(file))) {
        
        long fileLen = file.length(); 
        out.writeLong(fileLen);
        out.writeUTF("test01.mp4");
        out.flush();
        
        System.out.println("서버에 데이터를 보내는 중...");
        for(long i = 0; i < fileLen; i++) {
          out.write(fileIn.read());
        }
        out.flush();
      }
      
      System.out.println("서버에 데이터를 보냈음");
      
      System.out.println("서버의 응답을 기다리고 있음");
      String response = in.nextLine();
      System.out.println(response);
      
    } catch(Exception e) {
      e.printStackTrace();
    }

  }

}
