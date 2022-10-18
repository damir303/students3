<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <link rel="stylesheet" href="../resources/styles/style.css">
    <script src="../resources/js/functions.js"></script>
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
        </div>
    </div>

    <div class="midle-place">
        <div class="flex">
            <a href="StudentProgress.html" class="button">Посмотреть успеваемость выбранных студентов</a>
            <a href="/create-student" class="button">Создать студента...</a>
        </div>

        <div class="flex">
            <input type="submit" onclick="modificationStudents()"
                   value="Модифицировать выбранного студента" class="button">
            <input type="submit" onclick="deleteStudents()"
                   value="Удалить выбранных студентов" class="button">
        </div>
    </div>
    <div class="side"></div>
</div>

<div class="margin-left">
    <h2>
        Список студентов
    </h2>
</div>

<div class="flex">
    <div class="side"></div>
    <div class="midle-place">
        <form method="get">
            <table>
                <thead class="thead">
                <tr>
                    <th></th>
                    <th>Фамилия</th>
                    <th>Имя</th>
                    <th>Группа</th>
                    <th>Дата поступления</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="st">
                    <tr>
                        <td><input name="idStudent" type="checkbox" value="${st.id}"></td>
                        <td>${st.surname}</td>
                        <td>${st.name}</td>
                        <td>${st.group}</td>
                        <td><fmt:formatDate value="${st.date}" pattern="MM/dd/yyyy"></fmt:formatDate></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
    <div class="side"></div>
</div>

</body>
<form id="deleteStudentForm" action="/delete-student" method="post">
    <input type="hidden" id="deleteStudentHidden" name="deleteStudentHidden">
</form>

<form id="modificationStudentForm" action="/modification-student" method="get">
    <input type="hidden" id="modificationStudentHidden" name="modificationStudentHidden">
</form>

</html>