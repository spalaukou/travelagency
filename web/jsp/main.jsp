<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<div class="content">
    <c:if test="${sessionScope.login == null}">
        <jsp:include page="header/guestHeader.jsp"/>
    </c:if>

    <c:if test="${sessionScope.login != null}">
        <jsp:include page="header/userHeader.jsp"/>
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
