<%--
  Created by IntelliJ IDEA.
  Date: 20.10.2016
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>QE Show Solve Page</title>
</head>

<body>
    <c:set var="D" value="${discriminant.doubleValue()}"/>
    <c:choose>
        <c:when test="${D gt 0}">
            <h1>This equation has two roots:</h1>
            <h2>1st Root = ${root1.doubleValue()}</h2>
            <h2>2nd Root = ${root2.doubleValue()}</h2>
        </c:when>
        <c:when test="${D eq 0}">
            <h1>This equation has one root:</h1>
            <h2>Root = ${root1.doubleValue()}</h2>
        </c:when>
        <c:otherwise>
            <h1>This equation has no real roots.</h1>
        </c:otherwise>
    </c:choose>

    <h2>Discriminant = ${discriminant.doubleValue()}</h2>
    <form action="lesson3_QE.html"><input type="submit" value="Solve one more equation"/></form>
</body>
</html>
