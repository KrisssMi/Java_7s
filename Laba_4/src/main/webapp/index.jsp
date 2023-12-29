<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            font-family: "Century Gothic",serif;
            margin: 20px;
        }
        h2 {
            color: #333;
            font-family: "Century Gothic",serif;
        }
        div {
            margin-bottom: 20px;
            border: 1px solid #333333;
            padding: 25px;
            background-color: rgba(170, 170, 170, 0.25);
            border-radius: 15px;
            align-items: center;
        }
        a {
            text-decoration: none;
            color: #0073e6;
        }
        a:hover {
            text-decoration: underline;
        }
        form {
            margin-top: 10px;
            border-radius: 15px;
        }
        input {
            background-color: #0073e6;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 12px;
            font-family: "Century Gothic", serif;
            font-size: 14px;
            transition: background-color 0.3s ease;
        }

        input:hover {
            background-color: #0056b3;
            box-shadow: 0px 0px 5px #333;
        }

        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
            width: 50%;
            margin: 0 auto;
            border-radius: 13px;
        }
    </style>
    <title>Lab4</title>

    <%
        Calendar calendar =  Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Integer n = calendar.get(Calendar.HOUR_OF_DAY);
    %>
    <%!
        String pageToGo = null;

        protected String Period(Integer h)
        {
            if ((h > 0) && (h <= 5))
            {
                return  "night";
            }
            else if ((h > 5) && (h <= 12))
            {
                return "morning";
            }
            else if ((h > 12) && (h <= 17))
            {
                return "afternoon";
            }
            else
            {
                return "evening";
            }
        }
        protected String Say(Integer h)
        {
            return "Good " + Period(h);
        }
    %>
</head>
<body>

<h1>Task 1. Время суток:</h1>
<p><%=Say(n)%></p>

<hr>

<h1>Task 2. Вывести таблицу:</h1>
    <table>
        <thead>
        <tr>
            <td>Дата</td>
            <td>Номер дня</td>
        </tr>
        </thead>
        <% for(int i = 0; i < 6;i++)
        {%>
        <tr>
            <td><%= formatter.format(date)%></td>
            <% calendar.setTime(date); int day = calendar.get(Calendar.DAY_OF_WEEK);  %>
            <td><%= day == 1 ? 7 : day - 1%></td>
        </tr>
        <%calendar.add(Calendar.DATE,1); date = calendar.getTime();
        }%>
    </table>
<hr>


<h1>Task 5. Переход на страницу в зависимости от времени суток:</h1>
<div>
    <input type="button" value="Press" onclick="getPage()"/>
    <p id="day"></p>
</div>

<hr>

<h1>Task 6. JSP:INCLUDE</h1>
<p>
    <%
        String pagePath = "/" + Period(n) + ".jsp";
    %>
    <jsp:include page="<%=pagePath%>"/>
</p>

<hr>

<h1>Task 7. Сервлет afternoon:</h1>
<div>
    <a href="${pageContext.request.contextPath}/Afternoon">Afternoon servlet</a>
</div>

<hr>

<h1>Task 8. Сервлет afternoon (forward):</h1>
<div>
    <a href="${pageContext.request.contextPath}/Afternoon?parm=forw">Afternoon servlet (forward)</a>
</div>
<hr>

<h1>Task 11 - 13. Jjj сервлет: </h1>
<a href="./Jjj?parm=forw">GET (Jjj) (forward) </a> <br/>
<a href="./Jjj?parm=hc">GET (Jjj) (HTTPClient) </a> <br/>
<form action="Jjj" method="POST">
    <input type="submit" name="press" value="POST (Jjj)">
</form>

<script>
    const getPage = () =>
    {
        <%switch (Period(n))
        {
            case "morning": %>document.getElementById('day').innerHTML = `<%@ include file="/morning.jsp"%>`<% break;
            case "night": %>document.getElementById('day').innerHTML = `<%@ include file="/night.jsp"%>`<%break;
            case "evening": %>document.getElementById('day').innerHTML = `<%@ include file="/evening.jsp"%>`<%break;
            case "afternoon": %>document.getElementById('day').innerHTML = `<%@ include file="/afternoon.jsp"%>`<%break;
        }%>
    }
</script>
<br/>
</body>
</html>