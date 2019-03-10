<%--
  Created by IntelliJ IDEA.
  User: Scho
  Date: 09.03.2019
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp"/>
<h2>Panel administratora</h2>
<a href="ExerciseManagement">Lista zadań</a><br>
<a href="GroupManagement">Lista grup</a><br>
<a href="UserManagement">Lista użytkowników</a><br>
<jsp:include page="WEB-INF/footer.jsp"/>
</body>
</html>
