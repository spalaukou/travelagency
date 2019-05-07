<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tours</title>
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
    We offer you next tours:
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
        <td>Total price</td>
        <td>Click to buy</td>
    </tr>
    <c:forEach var="tour" items="${tours}" varStatus="status">
        <tr>
            <td><c:out value="${status.count}"/></td>
            <td><c:out value="${tour.hotel.country}"/></td>
            <td><c:out value="${tour.hotel.city}"/></td>
            <td><c:out value="${tour.hotel.name}"/></td>
            <td><c:out value="${tour.hotel.star}"/></td>
            <td><c:out value="${tour.hotel.meal}"/></td>
            <td><c:out value="${tour.hotel.person}"/></td>
            <td><c:out value="${tour.night}"/></td>
            <td><c:out value="${tour.transport.type}"/></td>
            <td><c:out value="${tour.cost}"/></td>
            <td><c:out value="${tour.hot}"/></td>
            <td>
                <c:choose>
                    <c:when test="${sessionScope.login != null}"><c:out value="${discount}"/></c:when>
                    <c:otherwise>1.0</c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:out value="${tour.totalPrice}"/>
            </td>
            <td>
                <a href="start?command=buy_tour&tour_id=${tour.id}&tp=${tour.totalPrice}" class="button">
                    <button>Buy Tour</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="footer/footer.jsp"/>

</body>
</html>