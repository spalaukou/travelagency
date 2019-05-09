<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.signUp" var="signUp"/>
    <fmt:message key="locale.sign.signUp" var="signUpText"/>
    <fmt:message key="locale.sign.login" var="login"/>
    <fmt:message key="locale.sign.password" var="password"/>
    <fmt:message key="locale.sign.clear" var="clear"/>
</fmt:bundle>
<html>
<head>
    <title>${signUp}</title>
</head>
<body>

<jsp:include page="header/GuestHeader.jsp"/>

<div style="text-align: center;">
    <form name="loginForm" method="POST" action="${pageContext.request.contextPath}\start">
        <input type="hidden" name="command" value="sign_up"/>
        <p>${signUpText}</p>
        <p>${login}<br/>
            <input type="text" name="login"/>
        </p>
        <p>${password}<br/>
            <input type="password" name="password"/>
        </p>
        ${errorLoginPassMessage}
        ${shortLoginPassMessage}
        ${wrongAction}
        ${nullPage}
        <br/>
        <tr>
            <td colspan="2">
                <input type="reset" value="${clear}"/>
                <input type="submit" value="${signUp}"/>
            </td>
        </tr>
    </form>
</div>

<jsp:include page="footer/Footer.jsp"/>

</body>
</html>
