<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Scho
  Date: 07.03.2019
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Groups</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp"/>
<h2>Groupy użytkowników</h2>
<table border="2">
    <tr>
        <th>Id</th>
        <th>Nazwa</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.id}</td>
            <td>${group.name}</td>
            <td><a href="GetGroupUsers?id=${group.id}">Użytkownicy</a></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
