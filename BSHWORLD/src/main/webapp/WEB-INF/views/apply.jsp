<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>apply</title>
<style>
table {
	width: 40%;
	border: 1px solid black;
	border-collapse: collapse;
	margin: 20px;
}

table td {
	padding: 5px;
}

table {
	border: 1px solid black;
}
.error {
	color: red;
}
</style>
</head>
<body>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		modelAttribute="offer">

		<table class="formtable">
			<tr>
				<td class="label">learnedyear</td>
				<td><sf:input class="control" type="text" path="learnedyear" />
					<br /> <sf:errors path="learnedyear" class="error" /></td>
			</tr>
			<tr>
				<td class="label">semester</td>
				<td><sf:input class="control" type="text" path="semester" /> <br />
					<sf:errors path="semester" class="error" /></td>
			</tr>

			<tr>
				<td class="label">code</td>
				<td><sf:input class="control" type="text" path="code" /> <br />
					<sf:errors path="code" class="error" /></td>
			</tr>

			<tr>
				<td class="label">classname</td>
				<td><sf:input class="control" type="text" path="classname" />
					<br /> <sf:errors path="classname" class="error" /></td>
			</tr>

			<tr>
				<td class="label">classification</td>
				<td><sf:input class="control" type="text" path="classification" />
					<br /> <sf:errors path="classification" class="error" /></td>
			</tr>
			<tr>
				<td class="label">professor</td>
				<td><sf:input class="control" type="text" path="professor" />
					<br /> <sf:errors path="professor" class="error" /></td>
			</tr>

			<tr>
				<td class="label">credit</td>
				<td><sf:input class="control" type="text" path="credit" /> <br />
					<sf:errors path="credit" class="error" /></td>
			</tr>



			<tr>
				<td></td>
				<td><input type="submit" value="입력"></td>
			</tr>

		</table>
	</sf:form>
</body>
</html>