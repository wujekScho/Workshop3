<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Scho
  Date: 10.03.2019
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj zadanie</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp"/>
<h2>Dodaj zadanie</h2>
<form method="post" action="AddExercise">
    <label> Nazwa <input type="text" name="name" required/></label><br>
    <label> Opis <input type="text" name="description" required/></label><br>
    <button type="submit">Dodaj zadanie</button>
</form>
<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
