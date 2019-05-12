<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.agentPanel" var="agentPanel"/>
    <fmt:message key="locale.tours.manageTours" var="manageToursText"/>
</fmt:bundle>

<div style="text-align: center;">

</div>

<table width="100%" cellspacing="0" cellpadding="4">
    <tr>
        <td width="50%" style="text-align: center;">${agentPanel}</td>
        <td width="50%" style="text-align: center;"><a href="start?command=show_tours&param=manage">${manageToursText}</a></td>
    </tr>
</table>

<hr/>