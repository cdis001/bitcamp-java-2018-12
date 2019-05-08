<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<title>수업 조회</title>
<jsp:include page="../commonCss.jsp" />
</head>
<body>
 <jsp:include page="../header.jsp" />
 <div class="container">
 <h1>수업 조회</h1>
 <c:choose>
  <c:when test="${empty lesson}">
   <p>해당 번호의 수업이 없습니다.</p>
  </c:when>
  <c:otherwise>
   <form action='update' method='post'>
   <div class="form-group row">
    <label for="no" class="col-sm-2 co-form-label">번호</label>
    <div class="col-sm-10">
    <input type="text" class="form-control-plaintext" id="no"
    name='no' value='${lesson.no }' readonly>
    </div>
   </div>
   
   <div class="form-group row">
    <label for="title" class="col-sm-2 co-form-label">제목</label>
    <div class="col-sm-10">
    <textarea class="form-control" id="title" 
                name='title' rows='1'>${lesson.title}</textarea>
    </div>
   </div>
   
     <div class="form-group row">
    <label for="contents" class="col-sm-2 co-form-label">내용</label>
    <div class="col-sm-10">
    <textarea class="form-control" id="contents" 
                name='contents' rows='1'>${lesson.contents}</textarea>
    </div>
   </div>
   
   <div class="form-group row">
    <label for="startDate" class="col-sm-2 co-form-label">시작일</label>
    <div class="col-sm-10">
    <textarea class="form-control" id="startDate" 
                name='startDate' rows='1'>${lesson.startDate}</textarea>
    </div>
   </div>
   
   <div class="form-group row">
    <label for="endDate" class="col-sm-2 co-form-label">종료일</label>
    <div class="col-sm-10">
    <textarea class="form-control" id="endDate" 
                name='endDate' rows='1'>${lesson.endDate}</textarea>
    </div>
   </div>
   
   <div class="form-group row">
    <label for="totalHours" class="col-sm-2 co-form-label">총 수업시간</label>
    <div class="col-sm-10">
    <textarea class="form-control" id="totalHours" 
                name='totalHours' rows='1'>${lesson.totalHours}</textarea>
    </div>
   </div>
   
   <div class="form-group row">
    <label for="dayHours" class="col-sm-2 co-form-label">일 수업시간</label>
    <div class="col-sm-10">
    <textarea class="form-control" id="dayHours" 
                name='dayHours' rows='1'>${lesson.dayHours}</textarea>
    </div>
   </div>
   
   <div class="form-group row">
    <div class="col-sm-10">
      <a class="btn btn-primary" href='.'>목록</a> 
      <a class="btn btn-primary" href='delete/${lesson.no}'>삭제</a> 
      <button class="btn btn-primary">변경</button>
    </div>
  </div>
   </form>
  </c:otherwise>
 </c:choose>
 </div>
 <jsp:include page="../javascript.jsp" />
</body>
</html>

