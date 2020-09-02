<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="http://java.sun.com/jstl/core" %>
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
    <title>Information</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/home.css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/templatemo_style.css" rel="stylesheet" type="text/css">
</head>
<body style="width: 60%" class="templatemo-bg-gray" id="tm-bgs">

<div style="margin-left: 57%" class="container ">

    <div style="margin-top: 30px;width: 400px;" class="col-md-12">

        <%--@elvariable id="information" type="com.mapsa.model.Information"--%>
        <div    class="form-horizontal templatemo-create-account templatemo-container">
            <h2 style="margin-top: 0px" class="margin-bottom-15">Edit infromatrion</h2>
        <c:form action="/home/information/update" method="post" modelAttribute="information">
            <div  class="form-inner ">
                <div  class="form-group ">
                    <div >
                        <label for="first_name" class="control-label">First Name</label>
                        <c:input path="firstName" type="text" class="form-control" id="first_name" placeholder="First Name"/>
                    </div>
                    <div >
                        <label for="last_name" class="control-label">Last Name</label>
                        <c:input path="lastName" type="text" class="form-control" id="last_name" placeholder="Last Name"/>
                    </div>
                    <div >
                        <label for="nationalCode" class="control-label">National Code</label>
                        <c:input path="nationalCode" type="text" class="form-control" id="nationalCode" placeholder="National Code"/>
                    </div>
                    <div >
                        <label for="age" class="control-label">Age</label>
                        <c:input path="age" type="text" class="form-control" id="age" placeholder="Age"/>
                    </div>
                    <div >
                        <label for="phone" class="control-label">Phone</label>
                        <c:input path="phone" type="phone" class="form-control" id="phone" placeholder="Phone"/>
                    </div>
                    <div >
                        <label for="address" class="control-label">Address</label>
                        <c:input path="address" type="phone" class="form-control" id="address" placeholder="Address"/>
                    </div>
                    <c:hidden path="accountId"/>
                    <c:hidden path="id"/>
                </div>
                <div class="form-group">
                    <div >
                        <input type="submit" value="Edit" style="width: 300px" class="btn btn-info">
                    </div>
                </div>
            </div>
        </c:form>
            <c:form method="post"   action="/home" >
            <button type="submit" value="Cancel"  style="width: 300px;height: 40px" class="btn btn-info">Cancel</button>
        </c:form>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
