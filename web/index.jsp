<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.title" var="title"/>
    <fmt:message key="locale.index.please" var="please"/>
    <fmt:message key="locale.index.signIn" var="signIn"/>
    <fmt:message key="locale.index.notHaveAccount" var="notHaveAccount"/>
    <fmt:message key="locale.index.signUp" var="signUp"/>
    <fmt:message key="locale.index.toBuy" var="toBuy"/>
    <fmt:message key="locale.index.selectToursRegistered" var="selectToursRegistered"/>
    <fmt:message key="locale.index.showAllTours" var="showAllTours"/>
    <fmt:message key="locale.index.travelToSpain" var="travelToSpain"/>
    <fmt:message key="locale.index.restInTurkey" var="restInTurkey"/>
    <fmt:message key="locale.index.vacationInEgypt" var="vacationInEgypt"/>
    <fmt:message key="locale.index.travelWithUs" var="travelWithUs"/>
    <fmt:message key="locale.index.weOfferDiscounts" var="weOfferDiscounts"/>
    <fmt:message key="locale.index.lvl_1_discount" var="lvl_1_discount"/>
    <fmt:message key="locale.index.lvl_2_discount" var="lvl_2_discount"/>
    <fmt:message key="locale.index.lvl_3_discount" var="lvl_3_discount"/>
    <fmt:message key="locale.buy.errorNotEnoughMoneyMessage" var="errorNotEnoughMoneyMessageLocale"/>
</fmt:bundle>
<html>

<head>
    <title>${title}</title>
    <style type="text/css">
        a.button {display:grid; height:100%; width:100%; text-align: center}
    </style>
</head>

<body>

<%--Кодировка запроса: ${pageContext.request.characterEncoding}--%>

<c:if test="${sessionScope.login == null}">
    <jsp:include page="jsp/header/GuestHeader.jsp"/>
    <br/>
    <div style="text-align: center;">
        ${please} <a href="${pageContext.request.contextPath}/jsp/SignIn.jsp">${signIn}</a>
        ${notHaveAccount} <a href="${pageContext.request.contextPath}/jsp/SignUp.jsp">${signUp}</a>${toBuy}
    </div>
    <br/>
</c:if>

<c:if test="${sessionScope.login != null}">
    <jsp:include page="jsp/header/UserHeader.jsp"/>
    <div style="text-align: center;">
        <c:if test="${errorNotEnoughMoneyMessage != null}">
            ${errorNotEnoughMoneyMessageLocale}
        </c:if><br/>
            ${selectToursRegistered}
    </div>
</c:if>

<br/>

<table width="100%" cellspacing="0" cellpadding="4" border="1">
    <tr>
        <td width="25%" bgcolor="#A9DFBF"><a href="start?command=show_tours" class="button">${showAllTours}</a></td>
        <td width="25%" bgcolor="#F9E79F"><a href="start?command=show_tours&country=spain" class="button">${travelToSpain}</a></td>
        <td width="25%" bgcolor="#F1948A"><a href="start?command=show_tours&country=turkey" class="button">${restInTurkey}</a></td>
        <td width="25%" bgcolor="#D3EDF6"><a href="start?command=show_tours&country=egypt" class="button">${vacationInEgypt}</a></td>
    </tr>
</table>

<br/>

<div style="text-align: center;">
    ${travelWithUs}<br/><br/><br/>
    ${weOfferDiscounts}<br/>
    ${lvl_1_discount}<br/>
    ${lvl_2_discount}<br/>
    ${lvl_3_discount}
</div>

<br/>

<jsp:include page="jsp/footer/Footer.jsp"/>

</body>
</html>