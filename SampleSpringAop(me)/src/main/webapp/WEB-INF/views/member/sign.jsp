<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function fn_chk(){
	var varId = document.getElementById("memberid");
	var varPass = document.getElementById("password");
	var varNm = document.getElementById("name");
	var varEmail = document.getElementById("email");
	
	if(varId.value == ""){
		alert("아이디를 입력하세요");
		return false;
	}
	return true;
}
</script>
<title>회원추가 페이지</title>
</head>
<body>
	<h1>회원추가 페이지입니다.</h1>
	<br />
	<form action="/member/insert" method="post" onsubmit="return fn_chk()">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberid" id="memberid" value=""></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="password" id="password" value=""></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name" value=""></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" id="email" value=""></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="추가"></td>
			</tr>
		</table>
	</form>
</body>
</html>