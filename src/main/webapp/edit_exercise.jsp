<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Scho
  Date: 10.03.2019
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja zadania</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp"/>
<h2>Edycja zadania</h2>
<form method="post" action="EditExercise">
    <label> Nazwa <input type="text" name="name" required/></label><br>
    <label> Opis <input type="text" name="description" required/></label><br>
    <input type="hidden" name="id" value="${id}"/>
    <button type="submit">Edytuj zadanie</button>
</form>
<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
