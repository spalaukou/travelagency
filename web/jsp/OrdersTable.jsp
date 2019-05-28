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

<link rel="stylesheet" type="text/css" href="css/style.css"/>

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

<div class="container">
    <div class="main">
        <div class="center">

            <br/>
            <c:choose>
                <c:when test="${afterPurchaseMessage != null}"><c:out value="${afterPurchaseMessageLocale}"/></c:when>
                <c:when test="${afterCancelMessage != null}"><c:out value="${afterCancelMessageLocale}"/></c:when>
            </c:choose>
            <br/>
            ${yourOrders}
            <br/><br/>

            <div class="grid tour">
                <div class="box">
                    ${num}
                </div>
                <div class="box">
                    ${type}
                </div>
                <div class="box">
                    ${country}
                </div>
                <div class="box">
                    ${city}
                </div>
                <div class="box">
                    ${hotel}
                </div>
                <div class="box">
                    ${stars}
                </div>
                <div class="box">
                    ${meals}
                </div>
                <div class="box">
                    ${persons}
                </div>
                <div class="box">
                    ${nights}
                </div>
                <div class="box">
                    ${transport}
                </div>
                <div class="box">
                    ${cost}
                </div>
                <div class="box">
                    ${hot}
                </div>
                <div class="box">
                    ${yourDisc}
                </div>
                <div class="box">
                    ${youPaid}
                </div>
                <div class="box">
                    ${click}
                </div>
            </div>

            <c:forEach var="order" items="${orders}" varStatus="status">
                <div class="grid tour">
                    <div class="box">
                        <c:out value="${status.count}"/>
                    </div>
                    <div class="box">
                        <c:out value="${order.tour.type}"/>
                    </div>
                    <div class="box">
                        <c:out value="${order.tour.hotel.country}"/>
                    </div>
                    <div class="box">
                        <c:out value="${order.tour.hotel.city}"/>
                    </div>
                    <div class="box">
                        <c:out value="${order.tour.hotel.name}"/>
                    </div>
                    <div class="box">
                        <c:out value="${order.tour.hotel.star}"/>
                    </div>
                    <div class="box">
                        <c:out value="${order.tour.hotel.meal}"/>
                    </div>
                    <div class="box">
                        <c:out value="${order.tour.hotel.person}"/>
                    </div>
                    <div class="box">
                        <c:out value="${order.tour.night}"/>
                    </div>
                    <div class="box">
                        <c:out value="${order.tour.transport.type}"/>
                    </div>
                    <div class="box">
                        <c:out value="${order.tour.cost}"/>
                    </div>
                    <div class="box">
                        <c:out value="${Math.round( (1.0 - order.tour.hot) * 100 )} %"/>
                    </div>
                    <div class="box">
                        <c:out value="${Math.round( (1.0 - discount) * 100 )} %"/>
                    </div>
                    <div class="box">
                        <c:out value="${order.totalPrice}"/>
                    </div>
                    <div class="box">
                        <a href="start?command=cancel_tour&id=${order.id}&tp=${order.totalPrice}" class="button">
                            <button>${cancel}</button>
                        </a>
                    </div>

                </div>
            </c:forEach>

            <br/>

        </div>
    </div>
</div>

<jsp:include page="footer/Footer.jsp"/>

</body>
</html>