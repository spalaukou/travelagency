<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.04.2019
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

<hr/>

<p>You are successfully signed up, ${param.login} (id = ${requestScope.iduser})!
<br/>
<br/>
<a href ="${pageContext.request.contextPath}">Back to main page</a>
</body>
</html>
