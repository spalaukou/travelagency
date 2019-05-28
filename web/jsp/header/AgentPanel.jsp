<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.agentPanel" var="agentPanel"/>
    <fmt:message key="locale.tours.manageTours" var="manageToursText"/>
</fmt:bundle>

<div class="grid manage">
    <div class="nav msg">
        ${agentPanel}
    </div>
    <div class="nav">
        <ul>
            <a href="start?command=show_tours&param=manage">
                <li>
                    ${manageToursText}
                </li>
            </a>
        </ul>
    </div>
</div>
