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
    <title>Manage Tours</title>
</head>
<body>

<jsp:include page="header/UserHeader.jsp"/>

<br/>

<table cellspacing="0" cellpadding="4" border="1" align="center">
    <tr>
        <td>${num}</td>
        <td>ID Tour</td>
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
        <td>${total}</td>
        <td>Click to update</td>
    </tr>
    <c:forEach var="tour" items="${tours}" varStatus="status">
        <form name="updateTour" method="POST" action="${pageContext.request.contextPath}\start">
            <input type="hidden" name="command" value="update_tour&tour_id=${tour.id}"/>
            <tr>
                <td><c:out value="${status.count}"/></td>
                <td><c:out value="${tour.id}"/></td>
                <td><input type="text" size="8" name="type" value="${tour.name}"/></td>
                <td><input type="text" size="5" name="country" value="${tour.hotel.country}"/></td>
                <td><input type="text" size="7" name="city" value="${tour.hotel.city}"/></td>
                <td><input type="text" size="6" name="hotel" value="${tour.hotel.name}"/></td>
                <td><input type="text" size="2" name="star" value="${tour.hotel.star}"/></td>
                <td><input type="text" size="2" name="meal" value="${tour.hotel.meal}"/></td>
                <td><input type="text" size="2" name="person" value="${tour.hotel.person}"/></td>
                <td><input type="text" size="2" name="night" value="${tour.night}"/></td>
                <td><input type="text" size="5" name="transport" value="${tour.transport.type}"/></td>
                <td><input type="text" size="3" name="cost" value="${tour.cost}"/></td>
                <td><input type="text" size="3" name="hot" value="${tour.hot}"/></td>
                <td><c:out value="${tour.totalPrice}"/></td>
                <td><input type="submit" value="Update tour"/></td>
            </tr>
        </form>
    </c:forEach>
</table>

<jsp:include page="footer/Footer.jsp"/>

</body>
</html>