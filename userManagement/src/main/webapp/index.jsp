<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 
  "/" 메인페이지 요청시 index.jsp가 매핑되는데
  바로 "/main"이라는 요청을 처리하는 Servlet으로 요청 위임
 --%>
<jsp:forward page="/main"/>