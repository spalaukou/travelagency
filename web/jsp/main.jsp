<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class="content">
    <c:if test="${requestScope.login == null}">
        <jsp:include page="header/GuestHeader.jsp"/>
    </c:if>

    <c:if test="${requestScope.login != null}">
        <jsp:include page="header/CustomerHeader.jsp"/>
    </c:if>
</div>

    <div>
        <div style="text-align: center;">
            Content for registered user.
        </div>
    </div>

<jsp:include page="footer/footer.jsp"/>

</body>
</html>
