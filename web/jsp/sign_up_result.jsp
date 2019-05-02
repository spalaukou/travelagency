<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header/guestHeader.jsp"/>

<div style="text-align: center;">
    You are successfully signed up, ${param.login}!<br/>

    Now you can <a href="${pageContext.request.contextPath}/jsp/sign_in.jsp">Sign In</a> and buy a tour.<br/>

    <br/>
    <a href="${pageContext.request.contextPath}">Back to main page</a>
</div>

<jsp:include page="footer/footer.jsp"/>

</body>
</html>
