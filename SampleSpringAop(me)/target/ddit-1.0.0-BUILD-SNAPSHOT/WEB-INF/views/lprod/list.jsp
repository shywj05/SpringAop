<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function fn_create(){
	location.href = "/create";
}
</script>
<title>상품분류 정보 목록</title>
</head>
<body>
	<h1>상품분류 정보 목록</h1>
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
				<td colspan="3" style="text-align: right;"><input type="button" value="신규입력" onclick="fn_create()"></td>
			</tr>
		</tbody>
	</table>
</body>
</html>