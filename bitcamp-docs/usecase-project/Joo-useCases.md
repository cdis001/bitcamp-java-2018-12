# 유스 케이스

## Actors

### 비회원
 - 시스템에 로그인 하지 않은 사용자
 
### 회원
 - 시스템에 로그인 한 사용자
 
### 기업
 - 기업에 등록된 로그인 사용자

### 일반회원
 - 일반회원로 등록된 로그인 사용자
 
### 관리자
 - 관리자로 등록된 로그인 사용자


## Use-Cases

### 매뉴얼 등록(기업, 관리자)
 - 기업 회원이 매뉴얼을 등록하는 것

### 매뉴얼 조회(비회원, 회원)
 - 비회원 및 회원이 매뉴얼을 조회하는 것
 
### 매뉴얼 수정(기업, 관리자)
 - 비회원 및 회원이 자신이 질문한 것을 변경하는 것
 - 매니저가 질문을 변경하는 것
  
### 매뉴얼 삭제(기업, 관리자)
 - 비회원 및 회원이 자신이 질문한 것을 변경하는 것
 - 매니저가 질문을 변경하는 것
 
### 댓글 관리(회원)
 - 회원이 매뉴얼 디테일 폼 안에서 댓글을 등록, 조회, 수정, 삭제, 추천, 신고하는 것
 
### 공지사항 관리(비회원, 회원, 관리자)
 - 공지사항을 등록, 수정, 삭제하는 것(관리자)
 - 공지사항을 조회하는 것(비회원, 회원)

### 매뉴얼 마이페이지(회원)
 - 회원이 마음에 드는 제품의 매뉴얼을 마이페이지에 등록, 조회, 삭제하는 것
 
### 매뉴얼 관리자 페이지(관리자)
 - 관리자가 매뉴얼 페이지에서 매뉴얼이나 댓글을 등록, 조회, 수정, 삭제하는 것

### Q&A 관리(회원, 관리자, 기업)
 - Q&A를 등록, 조회, 수정, 삭제하는 것
  
### 회원가입(비회원)
- 비회원이 로그인을 위해 회원에 가입하는 것.

### 회원탈퇴(회원)
- 회원이 서비스에서 탈퇴하는 것.

### 검색하기(비회원)
- 비회원이 등록된 게시물을 열람하기 위하여 검색하는 것

### 가이드 관리(비회원, 관리자)
- 비회원이 사이트의 이용방법을 알아내기 위해 가이드를 열람하는 것
- 관리자가 사이트의 이용방법을 설명해주기 위해 가이드를 등록, 수정, 삭제 하는 것