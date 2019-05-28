<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.title" var="title"/>
    <fmt:message key="locale.index.please" var="please"/>
    <fmt:message key="locale.index.signIn" var="signIn"/>
    <fmt:message key="locale.index.notHaveAccount" var="notHaveAccount"/>
    <fmt:message key="locale.index.signUp" var="signUp"/>
    <fmt:message key="locale.index.toBuy" var="toBuy"/>
    <fmt:message key="locale.index.selectToursRegistered" var="selectToursRegistered"/>
    <fmt:message key="locale.index.showAllTours" var="showAllTours"/>
    <fmt:message key="locale.index.travelToSpain" var="travelToSpain"/>
    <fmt:message key="locale.index.restInTurkey" var="restInTurkey"/>
    <fmt:message key="locale.index.vacationInEgypt" var="vacationInEgypt"/>
    <fmt:message key="locale.index.travelWithUs" var="travelWithUs"/>
    <fmt:message key="locale.index.weOfferDiscounts" var="weOfferDiscounts"/>
    <fmt:message key="locale.index.lvl_1_discount" var="lvl_1_discount"/>
    <fmt:message key="locale.index.lvl_2_discount" var="lvl_2_discount"/>
    <fmt:message key="locale.index.lvl_3_discount" var="lvl_3_discount"/>
    <fmt:message key="locale.buy.errorNotEnoughMoneyMessage" var="errorNotEnoughMoneyMessageLocale"/>
</fmt:bundle>

<link rel="stylesheet" type="text/css" href="css/style.css"/>

<html>

<head>
    <title>${title}</title>
</head>

<body>

<%--Кодировка запроса: ${pageContext.request.characterEncoding}--%>

<c:if test="${sessionScope.login == null}">
    <jsp:include page="jsp/header/GuestHeader.jsp"/>
    <div class="container">
        <div class="main">
            <div class="center">
                    ${please} <a href="${pageContext.request.contextPath}/jsp/SignIn.jsp">${signIn}</a>
                    ${notHaveAccount} <a href="${pageContext.request.contextPath}/jsp/SignUp.jsp">${signUp}</a>${toBuy}
            </div>
        </div>
    </div>
</c:if>

<c:if test="${sessionScope.login != null}">
    <jsp:include page="jsp/header/UserHeader.jsp"/>
    <div class="container">
        <div class="main">
            <div class="center">
                <c:if test="${errorNotEnoughMoneyMessage != null}">
                    <br/>
                    ${errorNotEnoughMoneyMessageLocale}
                </c:if>
                <br/>
                    ${selectToursRegistered}
            </div>
        </div>
    </div>
</c:if>

<div class="container">
    <div class="main">
        <div class="center">

            <div class="travel">
                <div class="options">
                    <a href="start?command=show_tours" class="button">
                        <div class="option all">
                            <div class="caption">${showAllTours}</div>
                        </div>
                    </a>
                </div>
                <div class="options">
                    <a href="start?command=show_tours&country=spain" class="button">
                        <div class="option spain">
                            <div class="caption">${travelToSpain}</div>
                        </div>
                    </a>
                </div>
                <div class="options">
                    <a href="start?command=show_tours&country=turkey" class="button">
                        <div class="option turkey">
                            <div class="caption">${restInTurkey}</div>
                        </div>
                    </a>
                </div>
                <div class="options">
                    <a href="start?command=show_tours&country=egypt" class="button">
                        <div class="option egypt">
                            <div class="caption">${vacationInEgypt}</div>
                        </div>
                    </a>
                </div>
            </div>

            <br/><br/>
            ${travelWithUs}
            <br/><br/>
            ${weOfferDiscounts}
            <br/>
            ${lvl_1_discount}
            <br/>
            ${lvl_2_discount}
            <br/>
            ${lvl_3_discount}
        </div>
    </div>
</div>

<jsp:include page="jsp/footer/Footer.jsp"/>

</body>
</html>