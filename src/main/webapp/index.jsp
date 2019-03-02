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
<table border="1">
    <tr>
        <th>Created</th>
        <th>Updated</th>
        <th>Description</th>
        <th>Exercise Id</th>
        <th>User Id</th>
    </tr>
    <c:forEach items="${solutions}" var="solution">
        <tr>
            <td>${solution.created}</td>
            <td>${solution.updated}</td>
            <td>${solution.description}</td>
            <td>${solution.exerciseId}</td>
            <td>${solution.userId}</td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
