<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--Created by IntelliJ IDEA.
    User: S_Zab
    Date: 14-Aug-20
    Time: 18:03
    To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/home.css">
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/fontawesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/fontawesome-all.min.css">
    <title>Home</title>

</head>
<body id="tm-bgs">

<ul>
        <li><i class="fas fa-user fa-2x"></i> &nbsp;&nbsp;${account.username}(${account.email})</li>
    <li><a href="#home">Home</a></li>
    <li> <a href="<c:url value="/home/account/${account.id}" />">edit</a></li>
    <li> <a href="<c:url value="/home/information/${account.id}" />">information</a></li>
    <li style="background-color: darkred"> <a href="<c:url value="/home/cart/${account.id}" />">cart</a></li>
    <li><a href="<c:url value="/" />">Logout</a></li>
</ul>

<table id="table-bgs">
    <thead>
    <tr class="table100-head">
        <th class="column1">Company</th>
        <th class="column2">From</th>
        <th class="column3">To</th>
        <th class="column4">Flight(Date,Time)</th>
        <th class="column5">Arrival(Date,Time)</th>
        <th class="column6">Price</th>
        <th class="column7">Quantity</th>
        <th class="column8">Description</th>
        <th class="column9">Shop</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach items="${flights}" var="flight">
        <tr>
            <td class="column1">${flight.company}</td>
            <td class="column2">${flight.origin}</td>
            <td class="column3">${flight.destination}</td>
            <td class="column4">${flight.flightDate}</td>
            <td class="column5">${flight.arrivalDate}</td>
            <td class="column6">${flight.fee}$</td>
            <td class="column7">${flight.quantity}</td>
            <td class="column8"><a href="<c:url  value="/home/description/${flight.id}" />">Description</a></td>
            <td  class="column9"><button style="width:90px;height: 32px;background-color: darkred  " class="btn btn-info"><a style="text-decoration:none;color: whitesmoke" href="<c:url value="/home/shopping/${flight.id}" />">Add to cart</a></button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</form>
</body>
</html>
