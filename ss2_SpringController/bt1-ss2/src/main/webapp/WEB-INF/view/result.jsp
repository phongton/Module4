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
<h1>Selected Condiments</h1>
<c:if test="${not empty selectedCondiments}">
    <ul>
        <c:forEach items="${selectedCondiments}" var="condiment">
            <li>${condiment}</li>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${empty selectedCondiments}">
    <p>No condiments selected</p>
</c:if>
<a href="/condiment">Go back</a>
</body>
</html>
