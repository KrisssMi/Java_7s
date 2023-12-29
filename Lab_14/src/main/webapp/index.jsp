<%@ page import="com.bstu.lab15.EmailAdmin" %>
<%@ page import="javax.mail.MessagingException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lab_15</title>
</head>
<body>
<a href="./jsp/messageForm.jsp">---> Send a message <---</a></body>
<%= EmailAdmin.showMessages(application.getInitParameter("UserEmail"), application.getInitParameter("UserPassword"))%>
</html>