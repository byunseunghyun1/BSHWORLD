<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<p><a href="${pageContext.request.contextPath}/offers"> Show current offers </a></p>

<p><a href="${pageContext.request.contextPath}/createoffer"> Add a new  offer</a></p>

</body>
</html>