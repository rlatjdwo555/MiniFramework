<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 목록</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h2>회원 목록</h2>
<p><a href='add.do'>신규 회원 추가</a></p>
<table border="1">
	<tr>
		<th><c:choose>
		<c:when test="${compInfo == 'MNO_ASC' }">
			<a href="list.do?compInfo=MNO_DESC">번호 ↑</a></c:when>
		<c:when test="${compInfo == 'MNO_DESC' }">
			<a href="list.do?compInfo=MNO_ASC">번호 ↓</a></c:when>	
		<c:otherwise>
			<a href="list.do?compInfo=MNO_ASC">번호</a></c:otherwise>
		</c:choose></th>
		<th><c:choose>
		<c:when test="${compInfo == 'MNAME_ASC' }">
			<a href="list.do?compInfo=MNAME_DESC">이름 ↑</a></c:when>
		<c:when test="${compInfo == 'MNAME_DESC' }">
			<a href="list.do?compInfo=MNAME_ASC">이름 ↓</a></c:when>	
		<c:otherwise>
			<a href="list.do?compInfo=MNAME_ASC">이름</a></c:otherwise>
		</c:choose></th>
		<th>이메일</th>
		<th><c:choose>
		<c:when test="${compInfo == 'CREDATE_ASC' }">
			<a href="list.do?compInfo=CREDATE_DESC">가입일 ↑</a></c:when>
		<c:when test="${compInfo == 'CREDATE_DESC' }">
			<a href="list.do?compInfo=CREDATE_ASC">가입일 ↓</a></c:when>	
		<c:otherwise>
			<a href="list.do?compInfo=CREDATE_ASC">가입일</a></c:otherwise>
		</c:choose></th>
		<th></th>
	</tr>
	
<c:forEach var="member" items="${members}">
<tr>
	<td>${member.mno }</td>
	<td><a href='update.do?mno=${member.mno }'>${member.name}</a></td>
	<td>${member.email }</td> 
	<td>${member.cdate }</td>
	<td><a href='delete.do?mno=${member.mno }'>[삭제]</a></td>
</tr>
</c:forEach>
</table>
<jsp:include page="/Tail.jsp"/>
</body>
</html>