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
    <title>Edit Account</title>
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
<body style="width: 60%;height: 90%" class="templatemo-bg-gray" id="tm-bgs">

<div style="margin-left: 60%" class="container ">
    <div style="margin-top: 60px;width: 400px;" class="col-md-12">
        <div   class="form-horizontal templatemo-create-account templatemo-container">
            <h2 style="margin-top: 0px" class="margin-bottom-15">Edit account</h2>
        <%--@elvariable id="account" type="com.mapsa.model.Account"--%>
        <c:form action="/home/account/update" method="post" modelAttribute="account"
                >
            <div  class="form-inner ">
                <div  class="form-group ">
                    <div >
                        <label for="username" class="control-label">Username</label>
                        <c:input path="username" type="text" class="form-control" id="username" placeholder="Username"/>
                    </div>
                    <div >

                        <label for="email" class="control-label">Email</label>
                        <c:input path="email"  readonly="true" type="email"  class="form-control" id="email" placeholder="Email"/>
                    </div>
                    <div >
                        <label for="password" class="control-label">Password</label>
                        <td><c:input path="password" type="password" class="form-control" id="password" placeholder="Password"/>
                    </div>
                    <c:hidden path="active"/>
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
