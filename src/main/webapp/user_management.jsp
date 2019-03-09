<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Scho
  Date: 09.03.2019
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp"/>
<h2>Lista użytkowników</h2>
<table border="2">
    <tr>
        <th>Nazwa</th>
        <th>Email</th>
        <th>Grupa</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.userGroupId}</td>
            <td><a href="DeleteUser?id=${user.id}">Usuń</a></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
