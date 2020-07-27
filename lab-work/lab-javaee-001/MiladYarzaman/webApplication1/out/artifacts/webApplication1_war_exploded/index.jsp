<%--
  Created by IntelliJ IDEA.
  User: Milad
  Date: 7/25/2020
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>HelloWorld</h1>
  <form method="post" action="/HelloServlet/register">
    <label for="username">
      name:
      <input id="username" type="text" name="username" ><br><br>
    </label>
    <label for="password">
      mobileNumber:
      <input id="password" type="text" name="password"><br><br>
    </label>
    <input type="submit" value="register">
  </form>
  <form method="post" action="/HelloServlet/login">
    <label for="loginusername">
      name:
      <input id="loginusername" type="text" name="username" ><br><br>
    </label>
    <label for="loginpassword">
      mobileNumber:
      <input id="loginpassword" type="text" name="password"><br><br>
    </label>
    <input type="submit" value="login">
  </form>
  </body>
</html>
