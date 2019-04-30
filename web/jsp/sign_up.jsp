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

<c:if test="${sessionScope.user == null}">
    <jsp:include page="header/GuestHeader.jsp"/>
</c:if>

<p>You are successfully signed up, ${param.login} (id = ${requestScope.iduser})!
<br/>
<br/>
<a href ="${pageContext.request.contextPath}">Back to main page</a>
</body>
</html>
