<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.agencyName" var="agencyName"/>
    <fmt:message key="locale.welcomeMessage" var="welcomeMessage"/>
    <fmt:message key="locale.signIn" var="signIn"/>
    <fmt:message key="locale.signUp" var="signUp"/>
</fmt:bundle>

<table width="100%" cellspacing="0" cellpadding="4">
    <tr>
        <td width="15%"><a href="${pageContext.request.contextPath}">${agencyName}</a></td>
        <td width="70%" style="text-align: center;">${welcomeMessage}</td>
        <td>
            <a href="${pageContext.request.contextPath}/jsp/SignIn.jsp">${signIn}</a>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/jsp/SignUp.jsp">${signUp}</a>
        </td>
    </tr>
</table>

<hr/>