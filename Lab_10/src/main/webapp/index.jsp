<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>AS_MKV_10</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }

    h1 {
      color: #333;
    }

    form {
      margin-bottom: 20px;
    }

    input {
      padding: 5px;
    }

    button {
      padding: 8px 15px;
      background-color: #4CAF50;
      color: #fff;
      border: none;
      cursor: pointer;
    }
  </style>
</head>
<body>
<h1>Task 1: Simple select</h1>
<form action="staticRequest">
  <button>Click</button>
</form>
<h1>Task 2: Select with dynamic condition generation</h1>
<form action="dynamicRequest">
  <input name="id" placeholder="Number..." />
  <button>Click</button>
</form>
<h1>Task 3: Call procedure "GetStudentById"</h1>
<form action="callProcedure">
  <input name="student_id" placeholder="Number..." />
  <button>Click</button>
</form>
</body>
</html>