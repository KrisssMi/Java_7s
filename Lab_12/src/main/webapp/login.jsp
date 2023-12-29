<%--
  Created by IntelliJ IDEA.
  User: Kristina
  Date: 22.11.2023
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FORM</title>
</head>
<body>
<form method="post" action="j_security_check">
    <label for="username">Username: </label>
    <input type="text" id="username" name="j_username" />
    <label for="password">Password: </label>
    <input type="password" id="password" name="j_password" />
    <input type="submit" />
</form>
</body>
</html>

