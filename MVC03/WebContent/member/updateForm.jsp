<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="euc-kr"%>
<!-- <jsp:useBean id="member" scope="request" class="spms.vo.Member"/> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>ȸ������ ����</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h3>ȸ������ ����</h3>
<form action="update.do" method="post">
ȸ�� ��ȣ : <input type='text' name="mno" size='4' value='${member.mno}' readonly><br>
�̸� : <input type='text' name="name" size='6' value='${member.name}'><br>
�̸��� : <input type='text' name="email" value='${member.email}'><br>
������ : ${member.cdate}<br>
<input type=submit value="����">
<input type="button" value="����"
	onclick='location.href="delete.do?no=${member.mno}";'>
<input type="button" value="���" onclick='location.href="list.do";'>
</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>