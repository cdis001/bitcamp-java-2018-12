package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;

public class Response {

  PrintWriter out;
  BufferedReader in;
  
  public Response(BufferedReader in, PrintWriter out) {
    this.out = out;
    this.in = in; 
    
  }
  
  public void println(String message) {
    out.println(message);
    out.flush();
  }
  
  public String requestString(String title) throws Exception {
    out.println(title);
    out.println("!{}!");
    out.flush();
    return in.readLine();
  }
  
  public int requestInt(String title) throws Exception {
    return Integer.parseInt(this.requestString(title));
  }
  
  public Date requestDate(String title) throws Exception {
    return Date.valueOf(this.requestString(title));
  }
  
}
