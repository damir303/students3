<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title page</title>
    <link rel="stylesheet" href="../resources/styles/style.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker();
        });
    </script>
</head>

<body>
<div class="flex">
    <div class="side"></div>
    <div class="header">
        <h1>Система управления студентами и их успеваемостью</h1>
    </div>
    <div class="side margin-top-auto">
        <div class="rigth-side">
            <a href="">Login</a>
            <br>
            <br>
            <a href="">Logout</a>
        </div>
    </div>
</div>

<div class="flex margin-top">
    <div class="side">
        <div class=" backToStart">
            <a href="/">На главную</a>
            <a href="/student">Назад</a>
        </div>
    </div>

    <div class="midle-place">
        <h3>
            Для создания студента заполните все поля и нажмите кнопку "Создать".
        </h3>
    </div>
</div>

<div class="flex margin-left margin-top">
    <div class="nameText">
        <p>Фамилия</p>
        <p>Имя</p>
        <p>Группа</p>
        <p>Дата поступления</p>
    </div>
    <div class="inputText">
        <form action="/create-student" method="post">
            <div>
                <input type="text" class="textInput" name="surname" value="${surname}">
            </div>
            <div>
                <input type="text" class="textInput" name="name" value="${name}">
            </div>
            <div>
                <input type="text" class="textInput" name="group" value="${group}">
            </div>
            <div>
                <input type="text" class="textInput margin-bottom" name="date" id="datepicker" value="${date}">
            </div>
            <div class="margin-bottom">
                <input type="submit" class="textInput" value="Создать">
            </div>
        </form>
    </div>
</div>
<c:if test="${error == 1}">
    <h2>Поля не должны быть пустыми</h2>
</c:if>

</body>

</html>