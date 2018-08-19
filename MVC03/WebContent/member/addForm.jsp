<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>신규 회원</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h3>신규 회원 정보 입력</h3>
<form action="add.do" method="post">
이메일 : <input type=text name="email"><br>
비밀번호 : <input type=password name="pwd"><br>
이름 : <input type=text name="name"><br>
<input type=submit value="확인">
</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>