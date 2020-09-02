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
<%@ page import="com.mapsa.models.AirplaneSeat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
  String t="";
  List<Flight> temp=new ArrayList();
  ArrayList<Flight> temp2=(ArrayList<Flight>)request.getAttribute("Flights");
  if(temp2.size()>0){
    for(Flight cx: temp2) {
      temp.add(cx);

    }
    t="تعداد پروازها: "+temp2.size()+temp2.get(0).getAirplaneSeats().size();
  }else {
          t="پروازی یافت نشد.";
    }


%>

<html>
  <head>
    <title>index</title>
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
  <div class="right" >
  <form action="/flightSearch" method="post" >
    <label for="destination">مقصد:</label>
    <input type="text" id="destination" name="destination"><br><br>
    <label for="origin">مبدا:</label>
    <input type="text" id="origin" name="origin"><br><br>

    <input type="submit" value="جستجو">
  </form>
      <form action="/account/login">
          <label for="username">کد ملی/ایمیل:</label>
          <input type="text" id="username" name="username"><br><br>
          <label for="loginPassword">رمز ورود:</label>
          <input type="text" id="loginPassword" name="loginPassword"><br><br>

          <input type="submit" value="ورود">
      </form>

      <form action="/account/registerPage">
      <input type="submit" value="ثبت نام">
    </form>
  </div>
  <h2>لیست کلیه پرواز ها  </h2>
  <table>
    <thead>
    <tr>
       <th>شماره پرواز</th>
      <th>مبدا</th>
       <th>مقصد</th>

      <th>تاریخ وزمان پرواز</th>
       <th>تعداد صندلی خالی</th>

       <th>هزینه(ریال)</th>
       <th>جزییات پرواز</th>
    </tr>
    <c:out value="<%=t%>"></c:out>


    <c:forEach items="${Flights}"  var="flight">

    <tr>

      <th>${flight.id}</th>
      <th>${flight.origin}</th>
      <th>${flight.destination}</th>
      <th>${flight.flightDate}</th>

     <th>
        <%--<c:forEach items="${flight.ID}"  var="seat">
          <c:if test="${seat.status}==0">
            <th>${seat.seatNumber}</th>
          </c:if>

        </c:forEach>--%>
        <%--<c:forEach items="<%=%>" var="seatNumber">
          <a href="/reserv/<%=flight.getFlightNumber()%>/seatNumber/${seatNumber}">${seatNumber}</a>
        </c:forEach>--%>
          <c:set var="freeSeats" value="0" scope="page" />
       <c:forEach items="${flight.airplaneSeats}" var="seat">

          <c:if test="${seat.status=='0'}">

            <c:set var="freeSeats" value="${freeSeats + 1}" scope="page"/>
           </c:if>
       </c:forEach>

          <a>${freeSeats}</a>
     </th>
     <%-- <th>${flight.description}</th>--%>
      <th>${flight.fee}</th>
      <th><form action="/flightDetails/${flight.id}">
        <input type="submit" value="جزییات">
      </form></th>
    </tr>
    </c:forEach>

    </thead>
  </table>

  </body>
</html>
