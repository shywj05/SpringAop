<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function fn_showToggle(param){
	console.log("param은 : " + param);
	if(param == "showDiv"){ // 수정모드로 전환
		document.getElementById("showDiv").style.display = "none";
		document.getElementById("updateDiv").style.display = "block";
	}else { // 상세모드로 전환
		document.getElementById("showDiv").style.display = "block";
		document.getElementById("updateDiv").style.display = "none";
	}
}

function fn_del(){
	var yesOrNo = confirm("정말 삭제하시겠어요?");
	if(yesOrNo){
		location.href = "/member/delete";
	}else{
		return false; 
	}
}
</script>
<title>회원정보 상세</title>
</head>
<body>
	<%
	String mode = request.getParameter("updateOk") == null ? "success" : request.getParameter("updateOk");

	if (mode.equals("success")) {
		mode = "updateDiv";
	} else {
		mode = "showDiv";
	}
	%>
	<c:set var="mode" value="<%=mode%>"></c:set>
	<h1>회원정보 상세</h1>
	<form action="/member/delete" method="post" onsubmit="return fn_del()">
	<input type="hidden" name="memberid" value="${memberVo.memberid}">
	<div id="showDiv">
		<p>아이디 : ${memberVo.memberid}</p>
		<p>비밀번호 : ${memberVo.password}</p>
		<p>성명 : ${memberVo.name}</p>
		<p>이메일 : ${memberVo.email}</p>
		<p>등록일 : ${memberVo.regdate}</p>
		<br /> <input type="button" value="수정하기" onclick="fn_showToggle('showDiv')">&nbsp;
		<input type="submit" value="삭제하기">&nbsp;<input type="button" value="회원목록" onclick="location.href='/member/list'">
	</div>
	</form>
	<form action="/member/update" method="post">
	<input type="hidden" name="memberid" value="${memberVo.memberid}">
		<div id="updateDiv">
			<p>아이디 : ${memberVo.memberid}</p>
			<p>
				비밀번호 : <input type="text" name="password" placeholder="${memberVo.password}">
			</p>
			<p>
				성명 : <input type="text" name="name" placeholder="${memberVo.name}">
			</p>
			<p>
				이메일 : <input type="text" name="email" placeholder="${memberVo.email}">
			</p>
			<p>등록일 : ${memberVo.regdate}</p>
			<br /> <input type="submit" value="확인">&nbsp;<input type="button" value="취소" onclick="fn_showToggle('updateDiv')">
		</div>
	</form>
	<script type="text/javascript">
		fn_showToggle("<%=mode%>");
	</script>
</body>
</html>