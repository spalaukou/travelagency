<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customTags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.agencyName" var="agencyName"/>
    <fmt:message key="locale.welcomeMessage" var="welcomeMessage"/>
    <fmt:message key="locale.signOut" var="signOut"/>
    <fmt:message key="locale.profileInfo" var="profileInfo"/>
    <fmt:message key="locale.role" var="role"/>
    <fmt:message key="locale.balanceText" var="balanceText"/>
    <fmt:message key="locale.discountText" var="discountText"/>
    <fmt:message key="locale.myOrders" var="myOrders"/>
</fmt:bundle>

<table width="100%" cellspacing="0" cellpadding="4">
    <tr>
        <td width="15%"><a href="${pageContext.request.contextPath}">${agencyName}</a></td>
        <td width="70%" style="text-align: center;">
            <ctg:helloTag login="${login}" welcomeMessage="${welcomeMessage}"/>
        </td>
        <td>
            <div style="text-align: right;">
                <a href="start?command=sign_out">${signOut}</a>
            </div>
        </td>
    </tr>
</table>

<hr/>

<table width="100%" cellspacing="0" cellpadding="4" border="1">
    <tr>
        <td style="text-align: center;">${profileInfo}</td>
        <td style="text-align: center;">${role}: ${userType}</td>
        <td style="text-align: center;">ID: ${userid}</td>
        <td style="text-align: center;">${balanceText}: ${balance}</td>
        <td style="text-align: center;">${discountText}: ${discount}</td>
        <td style="text-align: center;"><a href="start?command=show_orders">${myOrders}</a></td>
    </tr>
</table>

<hr/>

<c:set var= "agent" value="AGENT"/>
<c:if test= "${userType eq agent}">
    <jsp:include page="AgentPanel.jsp"/>
</c:if>