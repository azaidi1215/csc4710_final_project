<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<h3 align="center"> Pc Member With No Assigned Papers Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>memberid</th>
		<th>email</th>
		<th>name</th>
		
	</tr>
	<c:forEach items="${noassignedpaper}" var="noassigned">
	<tr>
		<td>${noassigned.memberid }</td>
		<td>${noassigned.email }</td>
		<td>${noassigned.name }</td>
		
	</tr>
</c:forEach>
</table>

</body>
</html>