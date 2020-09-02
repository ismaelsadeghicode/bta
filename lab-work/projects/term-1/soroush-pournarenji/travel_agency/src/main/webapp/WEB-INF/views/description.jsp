<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: S_Zab
  Date: 16-Aug-20
  Time: 07:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/home.css">
    <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body style="width: 60%;height: 90%" class="templatemo-bg-gray" id="tm-bgs">

<div style="margin-left: 30%;width: 100%">
    <table>
        <thead>
        <tr class="table100-head">
            <th class="column1">Company</th>
            <th class="column2">From</th>
            <th class="column3">To</th>
            <th class="column4">Flight(Date,Time)</th>
            <th class="column5">Arrival(Date,Time)</th>
            <th class="column6">Price</th>
            <th class="column7">Quantity</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="column1">${flight.company}</td>
            <td class="column2">${flight.origin}</td>
            <td class="column3">${flight.destination}</td>
            <td class="column4">${flight.flightDate}</td>
            <td class="column5">${flight.arrivalDate}</td>
            <td class="column6">${flight.fee}$</td>
            <td class="column7">${flight.quantity}</td>
        </tr>
        </tbody>
        <tfoot>
        <tr style="background-color: grey;">
            <td style="font-size: 50px;color: whitesmoke" colspan="7">${flight.description}</td>
        </tr>
        </tfoot>
    </table>
    <br/>
        <td class="column3">
            <c:form method="post"   action="/home" >
                <button type="submit" value="Cancel"  style="background-color:#d9534f;width: 100%;height: 40px" class="btn btn-info">Home</button>
            </c:form>
        </td>
</div>

</body>
</html>
