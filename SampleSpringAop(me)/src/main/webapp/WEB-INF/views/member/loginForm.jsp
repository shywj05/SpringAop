<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function fn_chk() {
		var varId = document.getElementById("memberid");
		var varPwd = document.getElementById("password");

		if (varId.value == "") {
			alert("아이디를 입력해주세요");
			return false;
		}
		if (varPwd.value == "") {
			alert("비밀번호를 입력해주세요");
			return false;
		}
		return true;
	}
</script>
<title>회원 로그인</title>
</head>
<body>
	<c:if test="${!empty memberVo}">
	${memberVo.name}(${memberVo.memberid})님, 환영합니다.
	<script type="text/javascript">
		opener.location.href = "/list";

		setTimeout(function() {
			this.close();
		}, 3000);
	</script>

	</c:if>
	<c:if test="${empty memberVo}">
		<form action="/member/login" method="POST" onsubmit="return fn_chk()">
			<p>
				아이디 : <input type="text" name="memberid" id="memberid" value="">
			</p>
			<p>
				비밀번호 : <input type="text" name="password" id="password" value="">
			</p>
			<input type="submit" value="로그인">&nbsp;<input type="button" value="회원가입" onclick="location.href='/member/signup'">
		</form>
	</c:if>
</body>
</html>