<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/edit" method="get">
    <input type="text" hidden="true" name="id" value="${employee.id}">
    <input type="text" name="name" value="${employee.name}">
    <input type="submit" value="edit">
</form>
</body>
</html>
