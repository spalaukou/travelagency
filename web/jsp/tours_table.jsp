<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tours</title>

</head>
<body>

<c:if test="${sessionScope.login == null}">
    <jsp:include page="header/guestHeader.jsp"/>
</c:if>

<c:if test="${sessionScope.login != null}">
    <jsp:include page="header/userHeader.jsp"/>
</c:if>

<div style="text-align: center;">
    We offer you next tours:
    <table>
        <tr>
            <td colspan="12">
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
            <td>Total</td>
            </td>
        </tr>
        <c:forEach var="elem" items="${tourlist}" varStatus="status">
            <tr>
                <td colspan="12">
                <td><c:out value="${ status.count }"/></td>
                <td><c:out value="${ elem.country }"/></td>
                <td><c:out value="${ elem.city }"/></td>
                <td><c:out value="${ elem.hotelName }"/></td>
                <td><c:out value="${ elem.star }"/></td>
                <td><c:out value="${ elem.meal }"/></td>
                <td><c:out value="${ elem.person }"/></td>
                <td><c:out value="${ elem.night }"/></td>
                <td><c:out value="${ elem.transportType }"/></td>
                <td><c:out value="${ elem.cost }"/></td>
                <td><c:out value="${ elem.hot }"/></td>
                <td><c:out value="${ elem.userCost }"/></td>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
