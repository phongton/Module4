<%--
  Created by IntelliJ IDEA.
  User: tonthathoangphong
  Date: 14/07/2024
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>Conversion Result</h2>
<p>Exchange Rate: ${rate}</p>
<p>Amount in USD: ${usd}</p>
<p>Amount in VND: ${result}</p>
<a href="${pageContext.request.contextPath}/conversion">Back to form</a>
</body>
</html>
