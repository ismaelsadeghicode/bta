<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 8/16/2020
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h2><center><u>  routeLists
</u></center></h2>
<hr>
<div class="container">
    <table class="table">
        <thead>
        <tr>

            <th>id</th>
            <th>movingTime</th>
            <th>returningTime</th>
            <th>Origin</th>
            <th>Destination</th>
            <th>severalPassengers</th>


        </tr>
        </thead>
        <tr>

            <td>${routeLists.id}</td>
            <td>${routeLists.movingTime}</td>
            <td>${routeLists.returningTime}</td>
            <td>${routeLists.origin}</td>
            <td>${routeLists.destination}</td>
            <td>${routeLists.severalPassengers}</td>

            <td><a href="<spring:url value="/RoutLists/${routeLists.id}" />"
            >
                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-info-circle-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM8 5.5a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                </svg>
            </a>
            </td>




        </tr>


    </table>
</div>

</body>
</html>
