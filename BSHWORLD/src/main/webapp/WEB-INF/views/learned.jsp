<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {
	width: 30%;
	border-collapse: collapse;
}
thead {
	
}

tr {
	text-align: center;
}

tbody {
	background-color: #52E252;
	color:52E252;'
}

tfoot tr:nth-child(2n) {
	background-color: #D2FFD2;
}

tfoot tr:nth-child(2n+1) {
	background-color: #F0FFF0;
}
</style>
</head>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}p/resources/css/main.css">
<body>
	<table border=1>
		<thead>
			<h3>학기별이수학점</h3>
		</thead>
		<tbody>
			<tr>
				<th>년도</th>
				<th>학기</th>
				<th>취득학점</th>
				<th>상세보기</th>
			</tr>
		</tbody>
		<tfoot>
			<c:set var="sum" value="0"/>	
			<c:forEach var="offer" items="${offers}">
				<tr>
					<td><c:out value="${offer.learnedyear}"></c:out></td>
					<td><c:out value="${offer.semester}"></c:out></td>
					<td><c:out value="${offer.sumcredit}"></c:out></td>
					<td><a
						href="${pageContext.request.contextPath}/detail?learnedyear=${offer.learnedyear}&semester=${offer.semester}">링크</a></td>
				<c:set var="sum" value="${sum + offer.sumcredit}" />
						</tr>

			</c:forEach>
			
			<tr>
			
		<td>총계</td>
		
		<td></td>
		<td>${sum}</td>	
			
		<td></td>
			</tr>
		</tfoot>
	</table>
	<br>
	<a href="${pageContext.request.contextPath}"
		class="btn btn-primary btn-lg active" role="button">Home</a>


</body>
</html>