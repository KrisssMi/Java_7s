<%@ page import="by.belstu.ChoiceWord" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab_13</title>
</head>
<body>
INDEX
<a href="/Lab_13/Sss">Sss</a>

<%
    String d = (String) request.getServletContext().getInitParameter("word-dir");
    ChoiceWord ch = new ChoiceWord(d, "docx");
    String foundedFile = null;
    for (int i = 0; i < ch.wordList.length; i++) {
        foundedFile = ch.wordList[i];
%>
<br />
<a href="/Lab_13/GetWord?file=<%=foundedFile%>"> <%=foundedFile%> </a>
<%}%>
</body>
</html>
