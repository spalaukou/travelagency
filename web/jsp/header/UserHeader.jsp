<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customTags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.agencyName" var="agencyName"/>
    <fmt:message key="locale.welcomeMessage" var="welcomeMessage"/>
    <fmt:message key="locale.signOut" var="signOut"/>
    <fmt:message key="locale.profileInfo" var="profileInfo"/>
    <fmt:message key="locale.role" var="role"/>
    <fmt:message key="locale.balanceText" var="balanceText"/>
    <fmt:message key="locale.discountText" var="discountText"/>
    <fmt:message key="locale.myOrders" var="myOrders"/>
</fmt:bundle>

<div class="grid user">
    <div class="nav">
        <ul>
            <a href="${pageContext.request.contextPath}">
                <li>
                    ${agencyName}
                </li>
            </a>
        </ul>
    </div>
    <div class="nav msg">
        <ctg:helloTag login="${login}" welcomeMessage="${welcomeMessage}"/>
    </div>
    <div class="nav">
        <ul>
            <a href="start?command=sign_out">
                <li>
                    ${signOut}
                </li>
            </a>
        </ul>
    </div>
</div>

<div class="grid panel">
    <div class="nav msg">
        ${profileInfo}
    </div>
    <div class="nav msg">
        ${role}: ${userType}
    </div>
    <div class="nav msg">
        ID: ${userid}
    </div>
    <div class="nav msg">
        ${balanceText}: ${balance}
    </div>
    <div class="nav msg">
        ${discountText}: ${Math.round( (1.0 - discount) * 100 )} %
    </div>
    <div class="nav">
        <ul>
            <a href="start?command=show_orders">
                <li>
                    ${myOrders}
                </li>
            </a>
        </ul>
    </div>
</div>

<c:set var= "agent" value="AGENT"/>
<c:if test= "${userType eq agent}">
    <jsp:include page="AgentPanel.jsp"/>
</c:if>