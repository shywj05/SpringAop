<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function fn_create(){
	location.href = "/create";
}

function fn_login() {
	// 요청경로, 창의 이름, 옵션=>window.open 옵션 검색
	window.open("/member/login","loginWindow","width=300,height=300,left=100,top=100");
}
</script>
<title>상품분류 정보 목록</title>
</head>
<body>
	<h1>상품분류 정보 목록</h1>
	<c:if test="${!empty memberVo}">
		${memberVo.name}(${memberVo.memberid})님, 안녕하세요
		
		<form action="/member/logout" method="post">
			<input type="submit" value="로그아웃">&nbsp;<input type="button" value="회원목록" onclick="location.href='/member/list'">
		</form>
	</c:if>
	<c:if test="${empty memberVo}">
		<input type="button" value="로그인" onclick="fn_login()">
	</c:if>
	<br />
	<table border="1" style="width: 50%;">
		<thead>
			<tr>
				<th>상품분류 번호</th>
				<th>상품분류 코드</th>
				<th>상품분류 명</th>
			</tr>
		<tbody>
			<c:forEach var="i" items="${lprodListVo}">
				<tr>
					<td><a href="/detail?lprodId=${i.lprodId}">${i.lprodId}</a></td>
					<td>${i.lprodGu}</td>
					<td>${i.lprodNm}</td>
				</tr>
			</c:forEach>
			<tr>
				<td>&nbsp;</td>
				<td>
					<c:if test=""></c:if>
				</td>
				<td colspan="3" style="text-align: right;"><input type="button" value="신규입력" onclick="fn_create()"></td>
			</tr>
		</tbody>
	</table>
</body>
</html>