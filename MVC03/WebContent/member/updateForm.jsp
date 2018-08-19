<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="euc-kr"%>
<!-- <jsp:useBean id="member" scope="request" class="spms.vo.Member"/> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>회원정보 수정</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h3>회원정보 수정</h3>
<form action="update.do" method="post">
회원 번호 : <input type='text' name="mno" size='4' value='${member.mno}' readonly><br>
이름 : <input type='text' name="name" size='6' value='${member.name}'><br>
이메일 : <input type='text' name="email" value='${member.email}'><br>
가입일 : ${member.cdate}<br>
<input type=submit value="저장">
<input type="button" value="삭제"
	onclick='location.href="delete.do?no=${member.mno}";'>
<input type="button" value="취소" onclick='location.href="list.do";'>
</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>