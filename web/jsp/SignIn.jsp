<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.signIn" var="signIn"/>
    <fmt:message key="locale.sign.signIn" var="signInText"/>
    <fmt:message key="locale.sign.login" var="login"/>
    <fmt:message key="locale.sign.password" var="password"/>
    <fmt:message key="locale.sign.clear" var="clear"/>
    <fmt:message key="locale.sign.errorLoginPassMessage" var="errorLoginPassMessageLocale"/>
    <fmt:message key="locale.sign.shortLoginPassMessage" var="shortLoginPassMessageLocale"/>
    <fmt:message key="locale.sign.wrongAction" var="wrongActionLocale"/>
    <fmt:message key="locale.sign.nullPage" var="nullPageLocale"/>
</fmt:bundle>
<html>
<head>
    <title>${signIn}</title>
</head>
<body>

<jsp:include page="header/GuestHeader.jsp"/>

<div style="text-align: center;">
    <form name="loginForm" method="POST" action="${pageContext.request.contextPath}\start">
        <input type="hidden" name="command" value="sign_in"/>
        <p>${signInText}</p>
        <p>${login}<br/>
            <input type="text" name="login"/>
        </p>
        <p>${password}<br/>
            <input type="password" name="password"/>
        </p>
        <c:choose>
            <c:when test="${errorLoginPassMessage != null}"><c:out value="${errorLoginPassMessageLocale}"/></c:when>
            <c:when test="${shortLoginPassMessage != null}"><c:out value="${shortLoginPassMessageLocale}"/></c:when>
            <c:when test="${wrongAction != null}"><c:out value="${wrongActionLocale}"/></c:when>
            <c:when test="${nullPage != null}"><c:out value="${nullPageLocale}"/></c:when>
        </c:choose>
        <br/>
        <tr>
            <td colspan="2">
                <input type="reset" value="${clear}"/>
                <input type="submit" value="${signIn}"/>
            </td>
        </tr>
    </form>
</div>

<jsp:include page="footer/Footer.jsp"/>

</body>
</html>
