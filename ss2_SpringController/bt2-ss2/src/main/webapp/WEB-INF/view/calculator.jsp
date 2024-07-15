<%--
  Created by IntelliJ IDEA.
  User: tonthathoangphong
  Date: 15/07/2024
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculator/calculate" method="post">
    <input type="number" name="number1" placeholder="só thứ nhất">
    <input type="number" name="number2" placeholder="só thứ hai">
    <br>
    <button type="submit" value="addition" name="operation">Addition</button>
    <button type="submit" value="subtraction" name="operation">Subtraction</button>
    <button type="submit" value="multiplication" name="operation">Multiplication</button>
    <button type="submit" value="division" name="operation">Division</button>
</form>
<h3>Result : ${result}</h3>
<h1>${message}</h1>
</body>
</html>
