<%--
  Created by IntelliJ IDEA.
  User: tonthathoangphong
  Date: 14/07/2024
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dictionary</h2>
<form action="translate/result" >
    <label for="word">Enter word:</label>
    <input type="text" id="word" name="word" required><br><br>
    <input type="submit" value="Translate">
</form>
<p>Result: ${result}</p>
</body>
</html>
