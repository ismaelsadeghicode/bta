<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/25/2020
  Time: 11:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ثبت نام</title>
</head>
<body>


<form action="/account/create" method="post" >
    <label for="nationalCode">کد ملی:</label>
    <input type="text" id="nationalCode" name="nationalCode" value="${account.nationalCode}"><br><br>
    <label for="firstName">نام:</label>
    <input type="text" id="firstName" name="firstName" value="${account.firstName}"><br><br>
    <label for="lastName">نام خانوادگی:</label>
    <input type="text" id="lastName" name="lastName" value="${account.lastName}"><br><br>
    <label for="email">ایمیل:</label>
    <input type="text" id="email" name="email" value="${account.email}"><br><br>
    <label for="password">رمز وروود:</label>
    <input type="text" id="password" name="password" value="${account.password}"><br><br>
    <label for="age">سن:</label>
    <input type="text" id="age" name="age" value="${account.age}"><br><br>
    <label for="phoneNumber">شماره همراه:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" value="${account.phone}"><br><br>
    <label for="address">آدرس:</label>
    <input type="text" id="address" name="address" value="${account.address}"><br><br>

    <input type="submit" value="ثبت نام">
</form>
</body>
</html>