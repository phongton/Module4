<%--
  Created by IntelliJ IDEA.
  User: tonthathoangphong
  Date: 13/07/2024
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Detail</title>
</head>
<body>
<h3>Customer Information</h3>
    <form action="${pageContext.request.contextPath}/customer/update" method="post">
    <table>
        <tr>
            <td>Id</td>
            <td><input type="text" name="id" value="${customer.id}" readonly /></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${customer.name}" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${customer.email}" /></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${customer.address}" /></td>
        </tr>
    </table>
    <input type="submit" value="Update" />
</form>
<br>
<a href="${pageContext.request.contextPath}/customer">Back to list</a>
</body>
</html>

</body>
</html>
