<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.tours.manageTours" var="manageToursText"/>
    <fmt:message key="locale.tours.addNewTour" var="addNewTour"/>
    <fmt:message key="locale.tours.addTour" var="addTour"/>
    <fmt:message key="locale.tours.updateTour" var="updateTour"/>
    <fmt:message key="locale.tours.hotelOffer" var="hotelOffer"/>
    <fmt:message key="locale.tours.k" var="k"/>
    <fmt:message key="locale.tours.clickToAdd" var="clockToAdd"/>
    <fmt:message key="locale.tours.clickToUpdate" var="clickToUpdate"/>
    <fmt:message key="locale.tours.enterData" var="enterData"/>
    <fmt:message key="locale.tours.hotel.name.vikingen" var="vikingen"/>
    <fmt:message key="locale.tours.hotel.name.best" var="best"/>
    <fmt:message key="locale.tours.hotel.name.super" var="superName"/>
    <fmt:message key="locale.tours.hotel.onePerson" var="onePerson"/>
    <fmt:message key="locale.tours.hotel.fewPerson" var="fewPerson"/>
    <fmt:message key="locale.tours.type.excursion" var="excursion"/>
    <fmt:message key="locale.tours.type.shopping" var="shopping"/>
    <fmt:message key="locale.tours.type.rest" var="rest"/>
    <fmt:message key="locale.tours.transport.car" var="car"/>
    <fmt:message key="locale.tours.transport.train" var="train"/>
    <fmt:message key="locale.tours.transport.airplane" var="airplane"/>
    <fmt:message key="locale.tours.transport.ship" var="ship"/>
    <fmt:message key="locale.tours.num" var="num"/>
    <fmt:message key="locale.tours.type" var="type"/>
    <fmt:message key="locale.tours.id" var="id"/>
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
    <fmt:message key="locale.tours.total" var="total"/>
    <fmt:message key="locale.tours.buy" var="buy"/>
    <fmt:message key="locale.tours.add" var="afterAddMessageLocale"/>
    <fmt:message key="locale.tours.addErr" var="errorAddMessageLocale"/>
    <fmt:message key="locale.tours.upd" var="afterUpdateMessageLocale"/>
    <fmt:message key="locale.tours.updErr" var="errorUpdateMessageLocale"/>
</fmt:bundle>
<html>
<head>
    <title>${manageToursText}</title>
</head>
<body>

<c:set var="agent" value="AGENT"/>
<c:if test="${userType eq agent}">
    <jsp:include page="header/UserHeader.jsp"/>

    <br/>

    <div style="text-align: center;">
            ${addNewTour}<br/><br/>
    </div>

    <table cellspacing="0" cellpadding="4" border="1" align="center">
        <tr>
            <td></td>
            <td>${type}</td>
            <td>${hotelOffer}</td>
            <td>${nights}</td>
            <td>${transport}</td>
            <td>${cost}${k}</td>
            <td>${hot}</td>
            <td>${clockToAdd}</td>
        </tr>
        <form name="updateTour" method="POST" action="${pageContext.request.contextPath}\start">
            <input type="hidden" name="command" value="add_tour"/>
            <tr>
                <td>${enterData}</td>
                <td>
                    <select name="tourType">
                        <option selected disabled>${type}</option>
                        <option value="excursion">${excursion}</option>
                        <option value="shopping">${shopping}</option>
                        <option value="rest">${rest}</option>
                    </select>
                </td>
                <td>
                    <select name="hotelID">
                        <option selected disabled>${hotelOffer}</option>
                        <option value="1">${vikingen} UAI, 1 ${onePerson}</option>
                        <option value="2">${vikingen} UAI, 2 ${fewPerson}</option>
                        <option value="3">${vikingen} UAI, 3 ${fewPerson}</option>
                        <option value="4">${vikingen} AI, 1 ${onePerson}</option>
                        <option value="5">${vikingen} AI, 2 ${fewPerson}</option>
                        <option value="6">${vikingen} AI, 3 ${fewPerson}</option>
                        <option value="7">${best} AI, 1 ${onePerson}</option>
                        <option value="8">${best} AI, 2 ${fewPerson}</option>
                        <option value="9">${best} AI, 3 ${fewPerson}</option>
                        <option value="10">${best} FB, 1 ${onePerson}</option>
                        <option value="11">${best} FB, 2 ${fewPerson}</option>
                        <option value="12">${best} FB, 3 ${fewPerson}</option>
                        <option value="13">${superName} HB, 1 ${onePerson}</option>
                        <option value="14">${superName} HB, 2 ${fewPerson}</option>
                        <option value="15">${superName} HB, 3 ${fewPerson}</option>
                        <option value="16">${superName} RO, 1 ${onePerson}</option>
                        <option value="17">${superName} RO, 2 ${fewPerson}</option>
                        <option value="18">${superName} RO, 3 ${fewPerson}</option>
                    </select>
                </td>
                <td>
                    <select name="tourNight">
                        <option selected disabled>${nights}</option>
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
                        <option selected disabled>${transport}</option>
                        <option value="1">${car}</option>
                        <option value="2">${train}</option>
                        <option value="3">${airplane}</option>
                        <option value="4">${ship}</option>
                    </select>
                </td>
                <td><input type="number" min="1" max="10000" size="1" name="tourCost"/></td>
                <td>
                    <select name="tourHot">
                        <option selected disabled>${hot}</option>
                        <option value="1.0">1.0</option>
                        <option value="0.9">0.9</option>
                        <option value="0.8">0.8</option>
                        <option value="0.7">0.7</option>
                    </select>
                </td>
                <td><input type="submit" value="${addTour}"/></td>
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
            ${manageToursText}:<br/><br/>
        <c:choose>
            <c:when test="${afterUpdateMessage != null}"><c:out value="${afterUpdateMessageLocale}"/></c:when>
            <c:when test="${errorUpdateMessage != null}"><c:out value="${errorUpdateMessageLocale}"/></c:when>
        </c:choose>
    </div>
    <table cellspacing="0" cellpadding="4" border="1" align="center">
        <tr>
            <td>${num}</td>
            <td>${id}</td>
            <td>${type}</td>
            <td>${country}</td>
            <td>${city}</td>
            <td>${hotel}</td>
            <td>${stars}</td>
            <td>${meals}</td>
            <td>${persons}</td>
            <td>${nights}</td>
            <td>${transport}</td>
            <td>${cost}${k}</td>
            <td>${hot}</td>
            <td>${total}</td>
            <td>${clickToUpdate}</td>
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
                    <td><input type="submit" value="${updateTour}"/></td>
                </tr>
            </form>
        </c:forEach>
    </table>

    <jsp:include page="footer/Footer.jsp"/>
</c:if>

</body>
</html>
