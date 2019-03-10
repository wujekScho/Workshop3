<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Scho
  Date: 10.03.2019
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja użytkownika</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp"/>
<h2>Edycja użytkownika</h2>
<form method="post" action="EditUser">
    <label> Nazwa <input type="text" name="name" value="${user.username}" required/></label><br>
    <label> Email <input type="text" name="email" value="${user.email}" required/></label><br>
    <label> Grupa
        <select name="groupId">
            <c:forEach items="${groups}" var="group">
                <option value="${group.id}">${group.name}</option>
            </c:forEach>
        </select>
    </label><br>
    <label> Hasło <input type="password" name="password" required/></label><br>
    <button type="submit">Edytuj użytkownika</button>
</form>
<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
