<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Scho
  Date: 10.03.2019
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja grupy</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp"/>
<h2>Edycja grupy użytkowników</h2>
<form method="post" action="EditGroup">
    <label> Nazwa <input type="text" name="name" value="${group.name}" required/></label><br>
    <input type="hidden" name="id" value="${id}"/>
    <button type="submit">Edytuj grupę</button>
</form>
<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
