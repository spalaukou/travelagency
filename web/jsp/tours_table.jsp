<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.04.2019
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tours</title>

</head>
<body>
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


<%--
<br/>
<br/>
<c:out value="${requestScope.user_tour}"/>--%>

</body>
</html>
