<%--
  Created by IntelliJ IDEA.
  User: tonthathoangphong
  Date: 14/07/2024
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conversion</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="conversion/change" method="post">
    <label for="rate">Exchange Rate (USD to VND):</label>
    <input type="text" id="rate" name="rate" required><br><br>
    <label for="usd">Amount in USD:</label>
    <input type="text" id="usd" name="usd" required><br><br>
    <input type="submit" value="Convert">
</form>
</body>
</html>
