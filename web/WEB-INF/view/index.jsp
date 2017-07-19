<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.getElementById('logoutForm').submit()">Logout</a></h2>
<form action="/add" method="get">
    <input type="text" name="name">
    <input type="submit" value="add">
</form>

<hr>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${list}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td><a href="/delete/${employee.id}">Delete</a></td>
            <td><a href="/findbyid/${employee.id}">Edit</a> </td>
        </tr>
    </c:forEach>
    <tr>

    </tr>
</table>
</body>
</html>
