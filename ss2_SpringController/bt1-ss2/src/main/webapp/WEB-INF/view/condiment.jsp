<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tonthathoangphong
  Date: 15/07/2024
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<h2>${message}</h2>
<form action="condiment/show" method="post">
    <c:forEach items="${condiments}" var="condiment">
        <label>
            <input type="checkbox" name="condiment" value="${condiment.name}"> ${condiment.name}
        </label>
        <br>
    </c:forEach>
    <button type="submit">Save</button>
</form>
</body>
</html>
