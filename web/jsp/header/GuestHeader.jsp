<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customTags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.agencyName" var="agencyName"/>
    <fmt:message key="locale.welcomeMessage" var="welcomeMessage"/>
    <fmt:message key="locale.signIn" var="signIn"/>
    <fmt:message key="locale.signUp" var="signUp"/>
</fmt:bundle>

<div class="grid guest">
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
            <a href="${pageContext.request.contextPath}/jsp/SignIn.jsp">
                <li>
                    ${signIn}
                </li>
            </a>
        </ul>
    </div>
    <div class="nav">
        <ul>
            <a href="${pageContext.request.contextPath}/jsp/SignUp.jsp">
                <li>
                    ${signUp}
                </li>
            </a>
        </ul>
    </div>
</div>
