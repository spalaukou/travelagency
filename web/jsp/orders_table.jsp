<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.login != null}">
        <jsp:include page="header/userHeader.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="header/guestHeader.jsp"/>
    </c:otherwise>
</c:choose>

<br/>

<div style="text-align: center;">
    ${afterPurchaseMessage}<br/>
    There are your orders:
</div>

<br/>

<table cellspacing="0" cellpadding="4" border="1" align="center">
    <tr>
        <td>#</td>
        <td>Country</td>
        <td>City</td>
        <td>Hotel</td>
        <td>Stars</td>
        <td>Meals</td>
        <td>Persons</td>
        <td>Nights</td>
        <td>Transport</td>
        <td>Cost</td>
        <td>Hot</td>
        <td>Your disc.</td>
        <td>You paid</td>
        <td>Click to cancel</td>
    </tr>
    <c:forEach var="order" items="${orders}" varStatus="status">
        <tr>
            <td><c:out value="${status.count}"/></td>
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
                <a href="start?command=cancel_tour&id=${order.id}" class="button">
                    <button>Cancel Tour</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="footer/footer.jsp"/>

</body>
</html>