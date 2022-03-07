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
	width: 60%;
	border-collapse: collapse;
}

tr {
	text-align: center;
}

table, tr, td, th {
	border:1px solid black;
}

thead {
	background-color: #52E252;
	color: 52E252;
}

tbody tr:nth-child(2n) {
	background-color: #D2FFD2;
}

tbody tr:nth-child(2n+1) {
	background-color: #F0FFF0;
}
</style>


</head>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}p/resources/css/main.css">
<body>


	<h3>2022�� ������û ��ȸ</h3>


	<table>
		<thead>
			<tr>
				<th>�⵵</th>
				<th>�б�</th>
				<th>�������</th>
				<th>��������</th>
				<th>��米��</th>
				<th>�������</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="offer" items="${offers}">
				<tr>
					<c:if test="${offer.learnedyear eq '2022' }">
						<td><c:out value="${offer.learnedyear}"></c:out></td>
						<td><c:out value="${offer.semester}"></c:out></td>
						<td><c:out value="${offer.classname}"></c:out></td>
						<td><c:out value="${offer.classification}"></c:out></td>
						<td><c:out value="${offer.professor}"></c:out></td>
						<td><c:out value="${offer.credit}"></c:out></td>


					</c:if>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	
	<a href="${pageContext.request.contextPath}"
		class="btn btn-primary btn-lg active" role="button">Home</a>

</body>
</html>