<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function fn_list() {
		location.href = "/list";
	}

	function fn_showToggle(getParam) {
		console.log("getParam : " + getParam);
		if(getParam == "divView"){ // 수정모드
			document.getElementById("divView").style.display = "none";
			document.getElementById("divEdit").style.display = "block";
		}else { // 상세보기 모드
			document.getElementById("divView").style.display = "block";
			document.getElementById("divEdit").style.display = "none";
		}
	}
	
	function fn_delchk(){
		alert("정말 삭제하시겠어요?");
		if(true){
			location.href = "/delete";
		}else {
			return false;
		}
	}
</script>
<title>상품분류 정보 상세</title>
</head>
<body>
	<%
	// updateGu의 값 : success / fail
	String mode = request.getParameter("updateGu") == null ? "success" : request.getParameter("updateGu");

	if (mode.equals("success")) {
		mode = "divEdit";
	} else {
		mode = "divView";
	}
	%>
	<c:set var="mode" value="<%=mode%>">

	</c:set>
	<form action="/delete" method="POST" onsubmit="return fn_delchk()">
		<input type="hidden" name="lprodId" value="${lprodVo.lprodId}">
		<!-- 상세 정보 보이기 -->
		<div id="divView">
			<h1>상품분류 정보 상세</h1>
			<p>상품분류 번호 : ${lprodVo.lprodId}</p>
			<p>상품분류 코드 : ${lprodVo.lprodGu}</p>
			<p>상품분류 명 : ${lprodVo.lprodNm}</p>
			<input type="button" value="수정" onclick="fn_showToggle('divView')" />&nbsp; <input type="submit" value="삭제"/>&nbsp; <input type="button" value="목록" onclick="fn_list()" />
		</div>
	</form>
	<!-- 상세 정보 수정-->
	<form action="/update" method="POST">
		<input type="hidden" name="lprodId" value="${lprodVo.lprodId}">
		<div id="divEdit" style="display: none;">
			<h1>상품분류 정보 수정</h1>
			<p>상품분류 번호 : ${lprodVo.lprodId}</p>
			<p>
				상품분류 코드 : <input type="text" name="lprodGu" id="lprodGu" value="${lprodVo.lprodGu}">
			</p>
			<p>
				상품분류 명 : <input type="text" name="lprodNm" id="lprodNm" value="${lprodVo.lprodNm}">
			</p>
			<input type="submit" value="확인" />&nbsp; <input type="button" value="취소" onclick="fn_showToggle('divEdit')" />&nbsp; <input type="button" value="목록" onclick="fn_list()" />
		</div>
	</form>
	<script type="text/javascript">
	fn_showToggle("<%=mode%>
		");
	</script>
</body>
</html>