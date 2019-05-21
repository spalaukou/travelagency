<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.tours.tours" var="toursText"/>
    <fmt:message key="locale.tours.weOffer" var="weOffer"/>
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
    <fmt:message key="locale.tours.total" var="total"/>
    <fmt:message key="locale.tours.click" var="click"/>
    <fmt:message key="locale.tours.buy" var="buy"/>
</fmt:bundle>
<html>
<head>
    <title>${toursText}</title>
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
    ${weOffer}
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
        <td>${total}</td>
        <td>${click}</td>
    </tr>
    <c:forEach var="tour" items="${tours}" varStatus="status">
        <tr>
            <td><c:out value="${status.count}"/></td>
            <td><c:out value="${tour.type}"/></td>
            <td><c:out value="${tour.hotel.country}"/></td>
            <td><c:out value="${tour.hotel.city}"/></td>
            <td><c:out value="${tour.hotel.name}"/></td>
            <td><c:out value="${tour.hotel.star}"/></td>
            <td><c:out value="${tour.hotel.meal}"/></td>
            <td><c:out value="${tour.hotel.person}"/></td>
            <td><c:out value="${tour.night}"/></td>
            <td><c:out value="${tour.transport.type}"/></td>
            <td><c:out value="${tour.cost}"/></td>
            <td><c:out value="${Math.round( (1.0 - tour.hot) * 100 )} %"/></td>
            <td>
                <c:choose>
                    <c:when test="${sessionScope.login != null}"><c:out value="${Math.round( (1.0 - discount) * 100 )} %"/></c:when>
                    <c:otherwise>0 %</c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:out value="${tour.totalPrice}"/>
            </td>
            <td>
                <a href="start?command=buy_tour&tour_id=${tour.id}&tp=${tour.totalPrice}" class="button">
                    <button>${buy}</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="footer/Footer.jsp"/>

</body>
</html>