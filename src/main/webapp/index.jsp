<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: schodziak
  Date: 02.03.19
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp"/>
<h2>Ostatnie rozwiązania</h2>
<table border="2">
    <tr>
        <th>Tytuł zadania</th>
        <th>Autor rozwiązania</th>
        <th>Data dodania</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${solutions}" var="solution">
        <tr>
            <td>${solution.title}</td>
            <td>${solution.author}</td>
            <td>${solution.created}</td>
            <td><a href="/ExcerciseSolution?id=${solution.id}">Szczegóły</a></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
