<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Scho
  Date: 10.03.2019
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarządzanie ćwiczeniami</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp"/>
<h2>Lista zadań</h2>
<table border="2">
    <tr>
        <th>Nazwa</th>
        <th>Opis</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${exercises}" var="exercise">
        <tr>
            <td>${exercise.title}</td>
            <td>${exercise.description}</td>
            <td><a href="DeleteExercise?id=${exercise.id}">Usuń</a> <a href="EditExercise?id=${exercise.id}">Edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="AddExercise">Dodaj zadanie</a>
<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
