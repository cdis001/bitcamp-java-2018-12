<%@page import="com.eomcs.lms.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><title>회원 조회</title></head>
<body>
 <jsp:include page="/header.jsp" />
<h1>회원 조회(JSP + EL + JSTL)</h1>
<jsp:useBean scope="request" id="member" type="com.eomcs.lms.domain.Member"/>
<c:choose>
<c:when test="${empty member}">
 <p>해당 번호의 회원이 없습니다</p>
 </c:when>
 <c:otherwise>
<form action='update' method='post' enctype='multipart/form-data'>
<table border='1'>
<tr>
  <th>번호</th>
  <td><input type='text' name='no' readonly value='${member.no}'></td>
</tr>
<tr>
  <th>이름</th>
  <td><input type='text' name='name' value='${member.name}'></td>
</tr>
<tr>
  <th>이메일</th>
  <td><input type='email' name='email' value='${member.email}'></td>
</tr>
<tr>
  <th>암호</th>
  <td><input type='password' name='password'></td>
</tr>
<tr>
  <th>사진</th>
  <td>
<c:set var="contextRootPath" value="${pageContext.servletContext.contextPath}"></c:set>
<c:if test="${empty member.photo}">
<img src='${contextRootPath}/images/default.jpg' style='height:80px'>
 </c:if>
 <c:if test="${not empty member.photo }">
 <img src='${contextRootPath }/upload/member/${member.photo} 'style='height:80px'>
</c:if>
        <input type='file' name='photo'></td>
</tr>
<tr>
  <th>전화</th>
  <td><input type='text' name='tel' value='${member.tel}'></td>
</tr>
<tr>
  <th>가입일</th>
  <td>${member.registeredDate}</td>
</tr>
</table>
<p><a href='list'>목록</a> <a href='delete?no=${member.no}'>삭제</a> <button type='submit'>변경</button><p>
</form>
</c:otherwise>
</c:choose>
</body>
</html>

