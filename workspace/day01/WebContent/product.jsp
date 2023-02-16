<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품확인</title>
</head>
<body>
	<form action="product">
		상품명
		<input type="text" name="name">
		가격
		<input type="text" name="price">
		<input type="submit" value="전송">
	</form>
	<h1><c:out value="${ param.name }"/></h1>
	<h1><c:out value="${ param.price }"/></h1>
</body>
</html>