<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Scho
  Date: 10.03.2019
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarządzanie grupami</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp"/>
<h2>Lista grup użytkowników</h2>
<table border="2">
    <tr>
        <th>Nazwa</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.name}</td>
            <td><a href="DeleteGroup?id=${group.id}">Usuń</a> <a href="EditGroup?id=${group.id}">Edytuj</a></td>
        </tr>
    </c:forEach>
</table>
<a href="AddGroup">Dodaj grupę</a>
<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
