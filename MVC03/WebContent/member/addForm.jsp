<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>�ű� ȸ��</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h3>�ű� ȸ�� ���� �Է�</h3>
<form action="add.do" method="post">
�̸��� : <input type=text name="email"><br>
��й�ȣ : <input type=password name="pwd"><br>
�̸� : <input type=text name="name"><br>
<input type=submit value="Ȯ��">
</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>