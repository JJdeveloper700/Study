<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>List Page</h1>
<ul>
<c:forEach var="member" items="${list }">
	<li>${member.id }/${member.pw }/${member.name }</li>

</c:forEach>
	


</ul>



</body>
</html>