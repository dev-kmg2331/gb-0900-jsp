<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과값 출력</title>
</head>
<body>
	<h2>
		결과 : <c:out value="${param.result}"/>
	</h2>
</body>
</html>