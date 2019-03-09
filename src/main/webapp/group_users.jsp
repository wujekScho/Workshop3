<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Scho
  Date: 09.03.2019
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group Users</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp"/>
<h2>Lista użytkowników grupy: ${group.name}</h2>
<c:choose>
    <c:when test="${empty users}">
        Grupa jest pusta.
    </c:when>
    <c:otherwise>
        <table border="2">
            <tr>
                <th>Nazwa</th>
                <th>Akcje</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td><a href="GetUserDetails?id=${user.id}">Szczegóły</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
