<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--

  Created by IntelliJ IDEA.

  User: fqx

  Date: 2020/8/28

  Time: 14:22

  To change this template use File | Settings | File Templates.

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Login</title>

</head>

<body>





<c:if test="${message ne null}">

    ${message}

</c:if>

<form action="loginCheck" method="post">

    Username : <input type="text" name="username" placeholder="Enter username" />

    <br />

    Password : <input type="password" name="password" placeholder="Enter password" />

    <br />

    <input type="submit" value="Login">

</form>



</body>

</html>