<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
// 	function fn_chk(){
// 		var varSelectOpt = document.getElementById("selectOpt");
// 		var varKeyWord = document.getElementByid("keyWord");
		
// 	}
	
	function fn_addMem() {
		location.href = "/member/signup";
	}
</script>
<title>회원정보 목록</title>
</head>
<body>
	<h1>회원정보 정보 목록</h1>
	<form method="get" action="">
		<select name="selectOpt" id="selectOpt">
			<option>전체</option>
			<option value="memberid" <c:if test="${selectOpt=='memberid'}"> selected="selected" </c:if>>아이디</option>
			<option value="name" <c:if test="${selectOpt=='name'}"> selected="selected" </c:if>>이름</option>
		</select>
		<input type="text" placeholder="검색" id="keyWord" name="keyWord" value="${keyWord}" onclick="document.getElementById('spanKeyWord').innerHTML='';" />
		<input type="submit" value="회원검색"/>
		<span id="spanKeyWord"></span>
	</form>
	<br/>
	<c:if test="${memberInfo != null}">
		<input type="button" value="회원추가하기" onclick="fn_addMem()">&nbsp;
		<input type="button" value="제품목록" onclick="location.href='/list'">
		<br />
		<br />
	</c:if>
	<table border="1" style="width: 50%;">
		<thead>
			<tr>
				<th>회원 아이디</th>
				<th>회원 이름</th>
				<th>회원 이메일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${memberListVo.content}">
				<tr>
					<td><a href="/member/detailMem?memberid=${i.memberid}">${i.memberid}</a></td>
					<td>${i.name}</td>
					<td>${i.email}</td>
				</tr>
			</c:forEach>
			<!-- ------------------ 페이지 처리 시작 ---------------------- -->
			<c:if test="${memberListVo.hasArticles()}">
				<tr>
					<td colspan="4" style="text-align: center;"><c:if test="${memberListVo.startPage > 5}">
							<a href="/member/list?pageNum=${memberListVo.startPage - 5}">[이전]</a>
						</c:if> <c:forEach var="pNo" begin="${memberListVo.startPage}" end="${memberListVo.endPage }">
							<a href="/member/list?pageNum=${pNo}">[${pNo}]</a>
						</c:forEach> <c:if test="${memberListVo.endPage < memberListVo.totalPages}">
							<a href="/member/list?pageNum=${memberListVo.startPage + 5}">[다음]</a>
						</c:if></td>
				</tr>
			</c:if>
			<!-- ------------------ 페이지 처리 끝 ---------------------- -->
		</tbody>
	</table>
</body>
</html>