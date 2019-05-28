<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.sign.signUpResult" var="regRes"/>
    <fmt:message key="locale.sign.success" var="success"/>
    <fmt:message key="locale.sign.nowYouCan" var="nowYouCan"/>
    <fmt:message key="locale.sign.toSignIn" var="toSignIn"/>
    <fmt:message key="locale.sign.andBuy" var="andBuy"/>
    <fmt:message key="locale.sign.back" var="back"/>
</fmt:bundle>

<link rel="stylesheet" type="text/css" href="css/style.css"/>

<html>
<head>
    <title>${regRes}</title>
</head>
<body>

<jsp:include page="header/GuestHeader.jsp"/>

<div class="container">
    <div class="main">
        <div class="center">
            ${success} ${param.login}!<br/>

            ${nowYouCan} <a href="${pageContext.request.contextPath}/jsp/SignIn.jsp">${toSignIn}</a> ${andBuy}<br/>

            <br/>
            <a href="${pageContext.request.contextPath}">${back}</a>
        </div>
    </div>
</div>

<jsp:include page="footer/Footer.jsp"/>

</body>
</html>
