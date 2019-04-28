<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.04.2019
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<div style="overflow:hidden">
    <div style="float:left">
        <a href ="${pageContext.request.contextPath}">GoTravel</a>
    </div>
    <div style="float:right">
        <a href ="${pageContext.request.contextPath}/jsp/sign_in.jsp">Sing In</a>
        <a href ="${pageContext.request.contextPath}">Sing Up</a>
    </div>
</div>

    <h3>
        Welcome
    </h3>
    <hr/>
        ${user}, hello!
    <hr/>
    <a href="controller?command=logout">Logout</a>
</body>
</html>
