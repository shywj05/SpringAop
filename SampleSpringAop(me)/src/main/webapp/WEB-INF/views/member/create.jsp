<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>create</title>
<script type="text/javascript">
	function fn_chk(){
		var strGu = document.getElementById("lprodGu");
		var strNm = document.getElementById("lprodNm");
		console.log("strGu : " + strGu.value);
		console.log("strNm : " + strNm.value);
		
		if(strGu.value == ""){
			alert("상품분류 코드를 입력하세요");
			return false;
		}
		if(strNm.value == ""){
			alsert("상품명을 입력하세요");
			return false;
		}
		
		return true;
	}
	function fn_list(){
		location.href = "/list";
	}
</script>
</head>
<body>
<h1>상품분류 정보</h1>

<form method="POST" onsubmit="return fn_chk()">
	<p>상품분류 코드 : <input type="text" name="lprodGu" id="lprodGu"></p>
	<p>상품분류 명 : <input type="text" name="lprodNm" id="lprodNm"></p>
	<p><input type="submit" value="저장"> &nbsp; <input type="button" value="목록" onclick="fn_list()"> </p>
</form>

</body>
</html>