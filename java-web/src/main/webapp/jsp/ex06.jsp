<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String[] names = {"홍길동", "임꺽정", "유관순"};
%>
<!DOCTYPE html>
<html>
<head>
<%!
public void jspInit() {
  System.out.println("ex06.jsp의 jspInit");
}

public void jspDestroy() {
  System.out.println("ex06.jsp의 jspDestroy");
}
%>
<meta charset="UTF-8">
<title>ex06</title>
</head>
<body>
<h1>선언부(declaration element)</h1>

100,000,000 입금 = <%=calculate(100000000) %>
</body>
<%!
double interest = 0.025;
private String calculate(long money) {
  return String.format("%.2f", money + (money * interest)) + "원 입니다.";
}
%>

</html>