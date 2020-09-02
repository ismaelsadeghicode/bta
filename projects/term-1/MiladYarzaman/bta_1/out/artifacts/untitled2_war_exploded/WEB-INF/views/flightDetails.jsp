<%--
  Created by IntelliJ IDEA.
  User: Milad
  Date: 8/4/2020
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.mapsa.models.Flight" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Milad
  Date: 8/4/2020
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.io.PrintWriter"%>
<%@ page import = " java.util.* " %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
            Flight flight=(Flight) request.getAttribute("Flight");

%>
<html>
<head>
    <title>Home</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>id</th>
        <th>مبدا</th>
        <th>مقصد</th>
        <th>تاریخ وزمان پرواز</th>
        <th>هزینه(ریال)</th>
        <th>صندلی های خالی</th>
        <th>توضیحات</th>
    </tr>

        <tr>

            <th>${flight.id}</th>
            <th>${flight.origin}</th>
            <th>${flight.destination}</th>
            <th>${flight.flightDate}</th>
             <th>${flight.fee}</th>
            <th>


                <c:forEach items="${flight.airplaneSeats}" var="seat">

                    <c:if test="${seat.status=='0'}">
                        <form action="">
                            <input type="submit" value="${seat.seatNumber}">
                        </form >

                    </c:if>
                </c:forEach>


            </th>
            <th>${flight.description}</th>
        </tr>

    </thead>
</table>
<form action="/reservation/${flight.id}">
    <input type="submit" value="پرداخت">
</form>
</body>
</html>
