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
    <table>
        <thead>
        <tr style="background-color: darkcyan" class="table100-head">
            <th class="column1">FirstName</th>
            <th class="column2">LastName</th>
            <th class="column3">NationalCode</th>
            <th class="column4">Phone</th>
            <th class="column5">Age</th>
            <th class="column6"></th>
        </tr>
        </thead>
        <tbody>
        <d:forEach items="${personList}" var="person">
            <tr>
                <td class="column1">${person.firstName}</td>
                <td class="column2">${person.lastName}</td>
                <td class="column3">${person.nationalCode}</td>
                <td class="column4">${person.phone}</td>
                <td class="column5">${person.age}</td>
                <td class="column5">
                    <button style="background-color: red;width: 80%;height: 60%"><a
                            style="color: black;text-decoration: none" href="<d:url value="/home/delete/${flight.id}&${person.id}" />">delete</a>
                    </button>
                </td>
            </tr>
        </d:forEach>

        <tr>

            <c:form action="/home/addcart/${flight.id}" modelAttribute="person" method="post">
                <td colspan="5"><c:select path="id" style="width: 80%">
                    <d:forEach items="${people}" var="person">
                        <c:option value="${person.id}">
                            ${person.firstName} &nbsp;&nbsp;&nbsp;&nbsp;
                            ${person.lastName} &nbsp;&nbsp;&nbsp;&nbsp;
                            ${person.nationalCode} &nbsp;&nbsp;&nbsp;&nbsp;
                            ${person.phone} &nbsp;&nbsp;&nbsp;&nbsp;
                            ${person.age}
                        </c:option>
                    </d:forEach>
                </c:select></td>
                <td class="column6">
                    <button type="submit" style="background-color: darkgreen;width: 80%;height: 60%">Add</button>
                </td>
            </c:form>
        </tr>

        <tr>
            <%--@elvariable id="person" type="com.mapsa.model.Person"--%>
            <c:form action="/home/addperson/${flight.id}" modelAttribute="person" method="post">
                <td class="column1"><c:input path="firstName" type="text" placeholder="firstName"/></td>
                <td class="column2"><c:input path="lastName" type="text" placeholder="LastName"/></td>
                <td class="column3"><c:input path="nationalCode" type="text" placeholder="NatianlCode"/></td>
                <td class="column4"><c:input path="phone" type="phone" placeholder="Phone"/></td>
                <td class="column5"><c:select path="age">
                    <c:option value="b">Baby(0-2)</c:option>
                    <c:option value="c">Child(2-12)</c:option>
                    <c:option value="a">Adult(12-120)</c:option>
                </c:select></td>
                <td class="column6">
                    <button type="submit" style="background-color: darkgreen;width: 80%;height: 60%">Add</button>
                </td>
            </c:form>
        </tr>
        </tbody>
        <tfoot>
        <td class="column3">
            <c:form method="post"   action="/home" >
                <button type="submit" value="Cancel" style="background-color:#d9534f;width: 300px;height: 40px" class="btn btn-info">Cancel</button>
            </c:form>
        </td>
        </tfoot>
    </table>
</div>

</body>
</html>
