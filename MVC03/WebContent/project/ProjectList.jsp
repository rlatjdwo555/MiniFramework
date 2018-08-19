<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>프로젝트 목록</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h3>프로젝트 목록</h3>
<p><a href='add.do'>신규 프로젝트</a>
<table border="1">
<tr>
	<th><c:choose>
    <c:when test="${orderCond == 'PNO_ASC'}">
      <a href="list.do?orderCond=PNO_DESC">번호↑</a>
    </c:when>
    <c:when test="${orderCond == 'PNO_DESC'}">
      <a href="list.do?orderCond=PNO_ASC">번호↓</a>
    </c:when>
    <c:otherwise>
      <a href="list.do?orderCond=PNO_ASC">번호</a>
    </c:otherwise>
  </c:choose></th>
  <th><c:choose>
    <c:when test="${orderCond == 'TITLE_ASC'}">
      <a href="list.do?orderCond=TITLE_DESC">제목↑</a>
    </c:when>
    <c:when test="${orderCond == 'TITLE_DESC'}">
      <a href="list.do?orderCond=TITLE_ASC">제목↓</a>
    </c:when>
    <c:otherwise>
      <a href="list.do?orderCond=TITLE_ASC">제목</a>
    </c:otherwise>
  </c:choose></th>
  <th><c:choose>
    <c:when test="${orderCond == 'STARTDATE_ASC'}">
      <a href="list.do?orderCond=STARTDATE_DESC">시작일↑</a>
    </c:when>
    <c:when test="${orderCond == 'STARTDATE_DESC'}">
      <a href="list.do?orderCond=STARTDATE_ASC">시작일↓</a>
    </c:when>
    <c:otherwise>
      <a href="list.do?orderCond=STARTDATE_ASC">시작일</a>
    </c:otherwise>
  </c:choose></th>
  <th><c:choose>
    <c:when test="${orderCond == 'ENDDATE_ASC'}">
      <a href="list.do?orderCond=ENDDATE_DESC">종료일↑</a>
    </c:when>
    <c:when test="${orderCond == 'ENDDATE_DESC'}">
      <a href="list.do?orderCond=ENDDATE_ASC">종료일↓</a>
    </c:when>
    <c:otherwise>
      <a href="list.do?orderCond=ENDDATE_ASC">종료일</a>
    </c:otherwise>
  </c:choose></th>
  <th><c:choose>
    <c:when test="${orderCond == 'STATE_ASC'}">
      <a href="list.do?orderCond=STATE_DESC">상태↑</a>
    </c:when>
    <c:when test="${orderCond == 'STATE_DESC'}">
      <a href="list.do?orderCond=STATE_ASC">상태↓</a>
    </c:when>
    <c:otherwise>
      <a href="list.do?orderCond=STATE_ASC">상태</a>
    </c:otherwise>
  </c:choose></th>
  <th></th>
</tr>
<c:forEach var="project" items="${projects}">
<tr>
	<td>${project.no}</td>
	<td><a href='update.do?no=${project.no}'>${project.title}</a></td>
	<td>${project.startDate}</td>
	<td>${project.endDate}</td>
	<td>${project.state}</td>
	<td><a href='delete.do?no=${project.no}'>[삭제]</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>