<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<jsp:include page="header/GuestHeader.jsp"/>

<div style="text-align: center;">
    You are successfully signed up, ${param.login}!<br/>

    Now you can <a href="${pageContext.request.contextPath}/jsp/sign_in.jsp">Sign In</a> and buy a tour.<br/>

    <br/>
    <a href="${pageContext.request.contextPath}">Back to main page</a>
</div>

<jsp:include page="footer/footer.jsp"/>

</body>
</html>
