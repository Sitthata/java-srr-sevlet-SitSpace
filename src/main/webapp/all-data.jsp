<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/23/2023
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>SitSpaceManagement</h1>
<a href="all-data.jsp">Data</a>
<a href="add-remove.jsp">Add/Remove Student</a>
<br/>
<c:if test="${sessionScope.AllStudents != null}">
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Score</th>
        <th>Grade</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${sessionScope.AllStudents.studentList}" var="student">
            <tr>
                <th>${student.id}</th>
                <th>${student.name}</th>
                <th>${student.score}</th>
                <th>${student.getGrade()}</th>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${sessionScope.AllStudents == null}">
        <h2>No data available</h2>
    </c:if>
    </tbody>
</table>
</body>
</html>
