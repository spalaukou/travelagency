<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.signUp" var="signUp"/>
    <fmt:message key="locale.sign.signUp" var="signUpText"/>
    <fmt:message key="locale.sign.login" var="login"/>
    <fmt:message key="locale.sign.password" var="password"/>
    <fmt:message key="locale.sign.clear" var="clear"/>
    <fmt:message key="locale.sign.errorLoginPassMessage" var="errorLoginPassMessageLocale"/>
    <fmt:message key="locale.sign.shortLoginPassMessage" var="shortLoginPassMessageLocale"/>
    <fmt:message key="locale.sign.wrongAction" var="wrongActionLocale"/>
    <fmt:message key="locale.sign.nullPage" var="nullPageLocale"/>
</fmt:bundle>

<link rel="stylesheet" type="text/css" href="../css/style.css"/>

<html>
<head>
    <title>${signUp}</title>
</head>
<body>

<jsp:include page="header/GuestHeader.jsp"/>

<div class="container">
    <div class="main">
        <div class="center">
            <form name="loginForm" method="POST" action="${pageContext.request.contextPath}\start">
                <input type="hidden" name="command" value="sign_up"/>
                <p>${signUpText}</p>
                <p>${login}<br/>
                    <input type="text" name="login"/>
                </p>
                <p>${password}<br/>
                    <input type="password" name="password"/>
                </p>
                <c:choose>
                    <c:when test="${errorLoginPassMessage != null}"><c:out
                            value="${errorLoginPassMessageLocale}"/></c:when>
                    <c:when test="${shortLoginPassMessage != null}"><c:out
                            value="${shortLoginPassMessageLocale}"/></c:when>
                    <c:when test="${wrongAction != null}"><c:out value="${wrongActionLocale}"/></c:when>
                    <c:when test="${nullPage != null}"><c:out value="${nullPageLocale}"/></c:when>
                </c:choose>
                <br/>
                <tr>
                    <td colspan="2">
                        <input type="reset" value="${clear}"/>
                        <input type="submit" value="${signUp}"/>
                    </td>
                </tr>
            </form>
        </div>
    </div>
</div>

<jsp:include page="footer/Footer.jsp"/>

</body>
</html>
