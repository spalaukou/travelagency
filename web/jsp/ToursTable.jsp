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

<link rel="stylesheet" type="text/css" href="css/style.css"/>

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

<div class="container">
    <div class="main">
        <div class="center">

            <br/>
            ${weOffer}
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
                    ${total}
                </div>
                <div class="box">
                    ${click}
                </div>
            </div>

            <c:forEach var="tour" items="${tours}" varStatus="status">
                <div class="grid tour">
                    <div class="box">
                        <c:out value="${status.count}"/>
                    </div>
                    <div class="box">
                        <c:out value="${tour.type}"/>
                    </div>
                    <div class="box">
                        <c:out value="${tour.hotel.country}"/>
                    </div>
                    <div class="box">
                        <c:out value="${tour.hotel.city}"/>
                    </div>
                    <div class="box">
                        <c:out value="${tour.hotel.name}"/>
                    </div>
                    <div class="box">
                        <c:out value="${tour.hotel.star}"/>
                    </div>
                    <div class="box">
                        <c:out value="${tour.hotel.meal}"/>
                    </div>
                    <div class="box">
                        <c:out value="${tour.hotel.person}"/>
                    </div>
                    <div class="box">
                        <c:out value="${tour.night}"/>
                    </div>
                    <div class="box">
                        <c:out value="${tour.transport.type}"/>
                    </div>
                    <div class="box">
                        <c:out value="${tour.cost}"/>
                    </div>
                    <div class="box">
                        <c:out value="${Math.round( (1.0 - tour.hot) * 100 )} %"/>
                    </div>
                    <div class="box">
                        <c:choose>
                            <c:when test="${sessionScope.login != null}">
                                <c:out value="${Math.round( (1.0 - discount) * 100 )} %"/>
                            </c:when>
                            <c:otherwise>0 %</c:otherwise>
                        </c:choose>
                    </div>
                    <div class="box">
                        <c:out value="${tour.totalPrice}"/>
                    </div>
                    <div class="box">
                        <a href="start?command=buy_tour&tour_id=${tour.id}&tp=${tour.totalPrice}" class="button">
                            <button>${buy}</button>
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