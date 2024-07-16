<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tonthathoangphong
  Date: 16/07/2024
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@declare id="filter"--%><h1>Setting</h1>
<h5>Language</h5>
<form:form action="/email/update" modelAttribute="emailSetting" method="post">
    <form:select path="language">
        <form:options items="${language}"/>
    </form:select>
    <h5>Page size:</h5>
    <p>Show <form:select path="size">
        <form:options items="${size}"/> emails per page
    </form:select></p>
    <h5>Spams filter : </h5>
    <form:checkbox path="filter"/>
        <label for="filter">Enable spams filter</label>
    <h5>Signature</h5>
    <form:textarea path="signature"></form:textarea>
    <br>
    <button type="submit">Update</button>
    <button type="reset">Cancel</button>
</form:form>
</body>
</html>
