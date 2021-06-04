<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 로그인</title>
</head>
<body>
	<form action="/login" method="POST">
		<p>
			아이디 : <input type="text" name="memId" id="id" value="아이디">
		</p>
		<p>
			비밀번호 : <input type="text" name="password" id="id" value="아이디">
		</p>
		<input type="submit" value="로그인">
	</form>
</body>
</html>