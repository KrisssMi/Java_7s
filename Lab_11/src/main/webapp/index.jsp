<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab_11</title>
</head>
<body>
<form action="#" method="post">
    <input type="text" id="x" value="2">
    <input type="text" id="y" value="7">
    <input type="text" id="z" readonly="readonly">
    <input type="button" value="headerSum" onclick="headerSum(this.form.x.value, this.form.y.value, false)">
</form>

<div>
    <form action="#" method="post">
        <input name="n" id="n" type="text" value="15">
        <div id="result-task-2"></div>
        <div id="result-task-3"></div>
        <input type="button" value="xml" onclick="getXML(this.form.n.value, false)">
        <input type="button" value="json" onclick="getJSON(this.form.n.value, false)">
    </form>
</div>

<div>
    <div>
        <input type="button" value="sync" onclick="getSync()">
        <input type="button" value="async" onclick="getAsync()">
    </div>
</div>

<script>
    function getAsync() {
        headerSum(document.getElementById("x").value, document.getElementById("y").value, true);
        getXML(document.getElementById("n").value, true);
        getJSON(document.getElementById("n").value, true);
    }

    function getSync() {
        headerSum(document.getElementById("x").value, document.getElementById("y").value, false);
        getXML(document.getElementById("n").value, false);
        getJSON(document.getElementById("n").value, false);
    }

    function headerSum(x, y, async) {
        const xhr = new XMLHttpRequest();
        xhr.open("GET", "/Lab11/SssHeader", async); // open() - открывает соединение
        xhr.setRequestHeader("Value-X", x);
        xhr.setRequestHeader("Value-Y", y);
        xhr.send();
        if (async) {
            xhr.onreadystatechange = () => {        // onreadystatechange - обработчик события изменения состояния
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById("z").value = xhr.getResponseHeader("Value-Z");
                }
            };
        } else {
            console.log(xhr.getResponseHeader("Value-Z"))
            document.getElementById("z").value = xhr.getResponseHeader("Value-Z");
        }
    }

    function getXML(n, async) {
        console.log('getXML');
        const xhr = new XMLHttpRequest();
        xhr.open("GET", "/Lab11/SssXml", async);
        xhr.setRequestHeader("XRand-N", n);
        xhr.send();
        if (async) {
            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById("result-task-2").innerHTML = "xml: " + stringifyXML(xhr);
                }
            };
        } else {
            console.log('2');
            document.getElementById("result-task-2").innerHTML = "xml: " + stringifyXML(xhr);
        }
    }

    function getJSON(n, async) {
        console.log('getJSON');
        const xhr = new XMLHttpRequest();
        xhr.open("GET", "/Lab11/SssJson", async);
        xhr.setRequestHeader("XRand-N", n);
        xhr.send();
        if (async) {
            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById("result-task-3").innerHTML = "json: " + stringifyJSON(xhr);
                }
            };
        } else {
            console.log('3');
            document.getElementById("result-task-3").innerHTML = "json: " + stringifyJSON(xhr);
        }
    }

    function stringifyXML(req) {
        const xml = req.responseXML;                                // responseXML - возвращает ответ сервера в виде XMLDocument
        const arr = Array.from(xml.getElementsByTagName("num"));    // getElementsByTagName - возвращает коллекцию элементов с указанным именем тега
        return arr.map(number => number.innerHTML).join(" ");       // map - создаёт новый массив с результатом вызова указанной функции для каждого элемента массива
    }

    function stringifyJSON(req) {
        const arr = JSON.parse(req.responseText);
        return arr.join(" ");                                       // join - объединяет все элементы массива в строку
    }
</script>
</body>
</html>
