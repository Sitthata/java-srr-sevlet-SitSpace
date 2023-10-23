<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/23/2023
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>PAGE: <a href="all-data.jsp">All-data</a></h1>
</div>
<div>
    <h2>Add Student Data</h2>
    <form action="addStudent" method="POST">
        <label for="id">ID:</label>
        <input type="text" name="id" id="id" value="id">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" value="name">
        <label for="score">Score:</label>
        <input type="text" name="score" id="score" value="score">
        <input type="submit" value="ADD">
    </form>
    <c:if test="${error != null}">
        <h2>${error}</h2>
    </c:if>
</div>
<div>
    <h2>Remove Student</h2>
    <form action="RemoveStudent" method="POST">
        <label for="removeId">ID:</label>
        <input type="text" name="removeId" id="removeId" value="id">
        <input type="submit" value="REMOVE">
    </form>
    <c:if test="${removeError != null}">
        <h2>${removeError}</h2>
    </c:if>
    <c:if test="${removeMessage != null}">
        <h2>${removeMessage}</h2>
    </c:if>
</div>
</body>
</html>
