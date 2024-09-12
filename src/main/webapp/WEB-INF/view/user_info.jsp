<%--
  Created by IntelliJ IDEA.
  User: flown
  Date: 11.09.2024
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Info</title>
</head>
<body>

<h2>User Info</h2>
<br>
<br>

<form:form action="saveUser" modelAttribute="user">

    <form:hidden path="id"/>

    Name: <form:input path="name"/>
    <br> <br>
    Surname: <form:input path="surname"/>
    <br> <br>
    Age: <form:input path="age"/>
    <br> <br>
    <input type="submit" value="OK"/>

</form:form>

</body>
</html>