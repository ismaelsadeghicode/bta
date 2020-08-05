
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <title>Travel Agency : Home  </title>
  <meta charset="UTF-8">
</head>

<body>
Welcome <% if (request.getParameter("name")!=null ) out.println(request.getParameter("name") + ", we sent an email to your email please confirm it"); %>
</body>
</html>