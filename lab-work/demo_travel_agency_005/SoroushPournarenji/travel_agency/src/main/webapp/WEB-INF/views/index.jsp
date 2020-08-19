<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Travel agency</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/fontawesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/slick/slick.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/slick/slick-theme.css"/>
    <link rel="stylesheet" href="/resources/css/tooplate-style.css">
    <!--    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">-->
    <link rel="stylesheet" type="text/css" href="/resources/css/fontawesome-all.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/iofrm-style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/util.css">
    <script>document.documentElement.className = "js";
    var supportsCssVars = function () {
        var e, t = document.createElement("style");
        return t.innerHTML = "root: { --tmp-var: bold; }", document.head.appendChild(t), e = !!(window.CSS && window.CSS.supports && window.CSS.supports("font-weight", "var(--tmp-var)")), t.parentNode.removeChild(t), e
    };
    supportsCssVars() || alert("Please view this in a modern browser such as latest version of Chrome or Microsoft Edge.");</script>

</head>

<body>
<div id="tm-bg"></div>
<div id="tm-wrap">
    <div class="tm-main-content">
        <div class="container tm-site-header-container">
            <div class="row">
                <div class="col-sm-12 col-md-6 col-lg-6 col-md-col-xl-6 mb-md-0 mb-sm-4 mb-4 tm-site-header-col">
                    <div class="tm-site-header">
                        <h2>Travel agency</h2>
                    </div>
                </div>
                <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">
                    <div class="content">
                        <div class="grid">
                            <div class="grid__item" id="home-link">
                                <div class="product">
                                    <div class="tm-nav-link">
                                        <i class="fas fa-lock fa-2x tm-nav-icon"></i>
                                        <span class="tm-nav-text">Login</span>
                                        <div class="product__bg"></div>
                                    </div>
                                    <div class="product__description">
                                        <div>
                                            <div class="row">
                                                <div class="form-holder">
                                                    <div class="img-holder">
                                                        <div class="bg"></div>
                                                        <div class="info-holder"></div>
                                                    </div>
                                                    <div class="form-content" style="width: 300px;">
                                                        <div class="form-items" style="width: 100%">
                                                            <h3>"<b>SAVE time</b> while others are wasting it"</h3>
                                                            <p size="40px">Get access to the most powerful tools after
                                                                you login....</p>
                                                            <%--@elvariable id="account" type="com.mapsa.model.Account"--%>
                                                            <a:form action="/login" method="post" modelAttribute="account">
                                                                <a:input path="email" class="form-control" type="email" name="username"
                                                                         placeholder="E-mail Address" />
                                                                <a:input path="password" class="form-control" type="password"
                                                                         name="password" placeholder="Password" />
                                                                <div class="form-button">
                                                                <button id="submit" type="submit" class="ibtn">Login</button>
                                                                </div>
                                                            </a:form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="grid__item" id="team-link">
                                <div class="product">
                                    <div class="tm-nav-link">
                                        <i class="fas fa-user-plus fa-3x tm-nav-icon"></i>
                                        <span class="tm-nav-text">Register</span>
                                        <div class="product__bg"></div>
                                    </div>
                                    <div class="product__description" >
                                        <div style="padding: 0px;margin: 0px">
                                            <div class="row" >
                                                <div  class="form-holder" >
                                                    <div class="img-holder">
                                                        <div class="bgre"></div>
                                                        <div class="info-holder"></div>
                                                    </div>
                                                    <div  style=" width: 350px;margin:0px;padding: 0px 0px 0px 0px" class="form-content">
                                                        <div  class="form-items" >
                                                           <center> <h1 >Register</h1></center>
                                                            <h3>"<b>SAVE time</b> while others are wasting it"</h3>
                                                            <%--@elvariable id="account" type="com.mapsa.model.Account"--%>
                                                            <a:form action="/registering" method="post" modelAttribute="account">
                                                                <table>
                                                                    <tr>
                                                                        <td> Email:</td>
                                                                        <td><a:input path="email"  class="form-control" type="email" name="email"
                                                                                     placeholder="E-mail Address" /></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Username:</td>
                                                                        <td><a:input path="username"   class="form-control" type="text" name="name"
                                                                                     placeholder="Full Name" /></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Password</td>
                                                                        <td><a:input path="password" class="form-control" type="password"
                                                                                     name="password" placeholder="Password"/></td>
                                                                    </tr>
                                                                </table>
                                                            <div class="form-button">
                                                                <button id="submits" type="submit" class="ibtn">Register</button>
                                                            </div>
                                                            </a:form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="grid__item">
                                <div class="product">
                                    <div class="tm-nav-link">
                                        <i class="fas fa-plane fa-3x tm-nav-icon"></i>
                                        <span class="tm-nav-text">List flight</span>
                                        <div class="product__bg"></div>
                                    </div>
                                    <div class="product__description">


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
                                                <c:forEach items="${flights}" var="flight">
                                            <tr>
                                                <td class="column1">${flight.company}</td>
                                                <td class="column2">${flight.origin}</td>
                                                <td class="column3">${flight.destination}</td>
                                                <td class="column4">${flight.flightDate}</td>
                                                <td class="column5">${flight.arrivalDate}</td>
                                                <td class="column6">${flight.fee}$</td>
                                                <td class="column7">${flight.quantity}</td>
                                            </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>


                                    </div>
                                </div>
                            </div>

                            <div class="grid__item">
                                <div class="product">
                                    <div class="tm-nav-link">
                                        <i class="fas fa-info-circle fa-3x tm-nav-icon"></i>
                                        <span class="tm-nav-text">About</span>
                                        <div class="product__bg"></div>
                                    </div>
                                    <div class="product__description">
                                        <div class="p-sm-4 p-2">
                                            <div class="row mb-3">
                                                <div class="col-12">
                                                    <h2 class="tm-page-title">About</h2>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-12">
                                                    <h2>Travel agency</h2>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-12">
                                                    <div class="p-sm-4 p-2 tm-img-container">
                                                        <div class="tm-img-slider" id="tmImgSlider">
                                                            <a href="#" class="tm-slider-img-link"><img src="/resources/img/1.jpg" alt="Image 1" class="img-fluid tm-slider-img"></a>
                                                            <a href="#" class="tm-slider-img-link"><img src="/resources/img/2.jpg" alt="Image 2" class="img-fluid tm-slider-img"></a>
                                                            <a href="#" class="tm-slider-img-link"><img src="/resources/img/3.jpg" alt="Image 3" class="img-fluid tm-slider-img"></a>
                                                            <a href="#" class="tm-slider-img-link"><img src="/resources/img/4.jpg" alt="Image 4" class="img-fluid tm-slider-img"></a>
                                                            <a href="#" class="tm-slider-img-link"><img src="/resources/img/5.jpg " alt="Image 5" class="img-fluid tm-slider-img"></a>
                                                            <a href="#" class="tm-slider-img-link"><img src="/resources/img/6.jpg" alt="Image 6" class="img-fluid tm-slider-img"></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div> <!-- .tm-main-content -->
</div>
<!-- load JS -->
<script src="/resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="/resources/slick/slick.min.js"></script>
<script src="/resources/js/anime.min.js"></script>
<script src="/resources/js/main.js"></script>


</body>
</html>