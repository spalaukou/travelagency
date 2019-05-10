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
    <fmt:message key="locale.tours.add" var="afterAddMessageLocale"/>
    <fmt:message key="locale.tours.addErr" var="errorAddMessageLocale"/>
    <fmt:message key="locale.tours.upd" var="afterUpdateMessageLocale"/>
    <fmt:message key="locale.tours.updErr" var="errorUpdateMessageLocale"/>
</fmt:bundle>
<html>
<head>
    <title>Manage Tours</title>
</head>
<body>

<c:set var="agent" value="AGENT"/>
<c:if test="${userType eq agent}">
    <jsp:include page="header/UserHeader.jsp"/>

    <br/>

    <div style="text-align: center;">
        Add new Tour:<br/><br/>
    </div>

    <table cellspacing="0" cellpadding="4" border="1" align="center">
        <tr>
            <td></td>
            <td>${type}</td>
            <td>Hotel offer</td>
            <td>${nights}</td>
            <td>${transport}</td>
            <td>${cost}(1-10k)</td>
            <td>${hot}</td>
            <td>Click to add</td>
        </tr>
        <form name="updateTour" method="POST" action="${pageContext.request.contextPath}\start">
            <input type="hidden" name="command" value="add_tour"/>
            <tr>
                <td>Enter data:</td>
                <td>
                    <select name="tourType">
                        <option selected disabled>Type</option>
                        <option value="excursion">excursion</option>
                        <option value="shopping">shopping</option>
                        <option value="rest">rest</option>
                    </select>
                </td>
                <td>
                        <%--                    <input type="number" size="1" min="1" max="18" name="hotelID"/>--%>
                    <select name="hotelID">
                        <option selected disabled>Select hotel offer</option>
                        <option value="1">Turkey, Alanya. Vikingen 5*. UAI, 1 person</option>
                        <option value="2">Turkey, Alanya. Vikingen 5*. UAI, 2 persons</option>
                        <option value="3">Turkey, Alanya. Vikingen 5*. UAI, 3 persons</option>
                        <option value="4">Turkey, Alanya. Vikingen 5*. AI, 1 person</option>
                        <option value="5">Turkey, Alanya. Vikingen 5*. AI, 2 persons</option>
                        <option value="6">Turkey, Alanya. Vikingen 5*. AI, 3 persons</option>
                        <option value="7">Spain, Barcelona. Best 4*. AI, 1 person</option>
                        <option value="8">Spain, Barcelona. Best 4*. AI, 2 persons</option>
                        <option value="9">Spain, Barcelona. Best 4*. AI, 3 persons</option>
                        <option value="10">Spain, Barcelona. Best 4*. FB, 1 person</option>
                        <option value="11">Spain, Barcelona. Best 4*. FB, 2 persons</option>
                        <option value="12">Spain, Barcelona. Best 4*. FB, 3 persons</option>
                        <option value="13">Egypt, Hurghada. Super 3*. HB, 1 person</option>
                        <option value="14">Egypt, Hurghada. Super 3*. HB, 2 persons</option>
                        <option value="15">Egypt, Hurghada. Super 3*. HB, 3 persons</option>
                        <option value="16">Egypt, Hurghada. Super 3*. RO, 1 person</option>
                        <option value="17">Egypt, Hurghada. Super 3*. RO, 2 persons</option>
                        <option value="18">Egypt, Hurghada. Super 3*. RO, 3 persons</option>
                    </select>
                </td>
                <td>
                    <select name="tourNight">
                        <option selected disabled>Night</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                    </select>
                </td>
                <td>
                    <select name="transport">
                        <option selected disabled>Transport</option>
                        <option value="1">car</option>
                        <option value="2">train</option>
                        <option value="3">airplane</option>
                        <option value="4">ship</option>
                    </select>
                </td>
                <td><input type="number" min="1" max="10000" size="1" name="tourCost"/></td>
                <td>
                    <select name="tourHot">
                        <option selected disabled>Hot</option>
                        <option value="1.0">1.0</option>
                        <option value="0.9">0.9</option>
                        <option value="0.8">0.8</option>
                        <option value="0.7">0.7</option>
                    </select>
                </td>
                <td><input type="submit" value="Add Tour"/></td>
            </tr>
        </form>
    </table>

    <div style="text-align: center;">
        <c:choose>
            <c:when test="${afterAddMessage != null}"><c:out value="${afterAddMessageLocale}"/></c:when>
            <c:when test="${errorAddMessage != null}"><c:out value="${errorAddMessageLocale}"/></c:when>
        </c:choose>
        <br/>
    </div>

    <br/>

    <div style="text-align: center;">
        Manage Tours:<br/><br/>
        <c:choose>
            <c:when test="${afterUpdateMessage != null}"><c:out value="${afterUpdateMessageLocale}"/></c:when>
            <c:when test="${errorUpdateMessage != null}"><c:out value="${errorUpdateMessageLocale}"/></c:when>
        </c:choose>
    </div>
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
            <td>${cost}(1-10k)</td>
            <td>${hot}</td>
            <td>${total}</td>
            <td>Click to update</td>
        </tr>
        <c:forEach var="tour" items="${tours}" varStatus="status">
            <form name="updateTour" method="POST" action="${pageContext.request.contextPath}\start?">
                <input type="hidden" name="command" value="update_tour"/>
                <input type="hidden" name="tour_id" value="${tour.id}"/>
                <tr>
                    <td><c:out value="${status.count}"/></td>
                    <td><c:out value="${tour.id}"/></td>
                    <td>${tour.name}</td>
                    <td>${tour.hotel.country}</td>
                    <td>${tour.hotel.city}</td>
                    <td>${tour.hotel.name}</td>
                    <td>${tour.hotel.star}</td>
                    <td>${tour.hotel.meal}</td>
                    <td>${tour.hotel.person}</td>
                    <td>${tour.night}</td>
                    <td>${tour.transport.type}</td>
                    <td><input type="number" size="1" min="1" max="10000" name="tourCost" value="${tour.cost}"/></td>
                    <td>
                        <select name="tourHot">
                            <option selected>${tour.hot}</option>
                            <option value="1.0">1.0</option>
                            <option value="0.9">0.9</option>
                            <option value="0.8">0.8</option>
                            <option value="0.7">0.7</option>
                        </select>
                    </td>
                    <td><c:out value="${tour.totalPrice}"/></td>
                    <td><input type="submit" value="Update Tour"/></td>
                </tr>
            </form>
        </c:forEach>
    </table>

    <jsp:include page="footer/Footer.jsp"/>
</c:if>

</body>
</html>
