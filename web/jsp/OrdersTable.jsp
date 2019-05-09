<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.orders.orders" var="ordersText"/>
    <fmt:message key="locale.orders.yourOrders" var="yourOrders"/>
    <fmt:message key="locale.tours.num" var="num"/>
    <fmt:message key="locale.tours.type" var="type"/>
    <fmt:message key="locale.tours.country" var="country"/>
    <fmt:message key="locale.tours.city" var="city"/>
    <fmt:message key="locale.tours.hotel" var="hotel"/>
    <fmt:message key="locale.tours.stars" var="stars"/>
    <fmt:message key="locale.tours.meals" var="meals"/>
    <fmt:message key="locale.tours.persons" var="persons"/>
    <fmt:message key="locale.tours.nights" var="nights"/>
    <fmt:message key="locale.tours.transport" var="transport"/>
    <fmt:message key="locale.tours.cost" var="cost"/>
    <fmt:message key="locale.tours.hot" var="hot"/>
    <fmt:message key="locale.tours.yourDisc" var="yourDisc"/>
    <fmt:message key="locale.orders.youPaid" var="youPaid"/>
    <fmt:message key="locale.orders.click" var="click"/>
    <fmt:message key="locale.orders.cancel" var="cancel"/>
    <fmt:message key="locale.buy.afterPurchaseMessage" var="afterPurchaseMessageLocale"/>
    <fmt:message key="locale.buy.afterCancelMessage" var="afterCancelMessageLocale"/>
</fmt:bundle>
<html>
<head>
    <title>${ordersText}</title>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.login != null}">
        <jsp:include page="header/UserHeader.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="header/GuestHeader.jsp"/>
    </c:otherwise>
</c:choose>

<br/>

<div style="text-align: center;">
    <c:choose>
        <c:when test="${afterPurchaseMessage != null}"><c:out value="${afterPurchaseMessageLocale}"/></c:when>
        <c:when test="${afterCancelMessage != null}"><c:out value="${afterCancelMessageLocale}"/></c:when>
    </c:choose>
        <br/>
    ${yourOrders}
</div>

<br/>

<table cellspacing="0" cellpadding="4" border="1" align="center">
    <tr>
        <td>${num}</td>
        <td>${type}</td>
        <td>${country}</td>
        <td>${city}</td>
        <td>${hotel}</td>
        <td>${stars}</td>
        <td>${meals}</td>
        <td>${persons}</td>
        <td>${nights}</td>
        <td>${transport}</td>
        <td>${cost}</td>
        <td>${hot}</td>
        <td>${yourDisc}</td>
        <td>${youPaid}</td>
        <td>${click}</td>
    </tr>
    <c:forEach var="order" items="${orders}" varStatus="status">
        <tr>
            <td><c:out value="${status.count}"/></td>
            <td><c:out value="${order.tour.name}"/></td>
            <td><c:out value="${order.tour.hotel.country}"/></td>
            <td><c:out value="${order.tour.hotel.city}"/></td>
            <td><c:out value="${order.tour.hotel.name}"/></td>
            <td><c:out value="${order.tour.hotel.star}"/></td>
            <td><c:out value="${order.tour.hotel.meal}"/></td>
            <td><c:out value="${order.tour.hotel.person}"/></td>
            <td><c:out value="${order.tour.night}"/></td>
            <td><c:out value="${order.tour.transport.type}"/></td>
            <td><c:out value="${order.tour.cost}"/></td>
            <td><c:out value="${order.tour.hot}"/></td>
            <td><c:out value="${discount}"/></td>
            <td><c:out value="${order.totalPrice}"/></td>
            <td>
                <a href="start?command=cancel_tour&id=${order.id}&tp=${order.totalPrice}" class="button">
                    <button>${cancel}</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="footer/Footer.jsp"/>

</body>
</html>