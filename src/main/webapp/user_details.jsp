<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Scho
  Date: 09.03.2019
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Details</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp"/>
<h2>Szczegóły użytkownika: ${user.username}</h2>
Email: ${user.email}<br>
<h3>Dodane rozwiązania zadań</h3>
<c:choose>
    <c:when test="${empty solutions}">
        Użykownik nie dodał żadnych rozwiązań.
    </c:when>
    <c:otherwise>
        <table border="2">
            <tr>
                <th>Utworzono</th>
                <th>Data dodania</th>
            </tr>
            <c:forEach items="${solutions}" var="solution">
                <tr>
                    <td>${solution.created}</td>
                    <td>${solution.updated}</td>
                    <td><a href="ExcerciseSolution?id=${solution.id}">Szczegóły</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
