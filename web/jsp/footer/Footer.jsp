<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="localization">
    <fmt:message key="locale.author" var="author"/>
    <fmt:message key="locale.selectLanguage" var="selectLanguage"/>
</fmt:bundle>

<hr/>

<table width="100%" cellspacing="0" cellpadding="4">
    <tr>
        <td style="text-align: left;">© ${author}, 2019</td>
        <td style="text-align: right;">${selectLanguage}:
            <a href="${pageContext.request.contextPath}/start?command=change_locale&localization=en_US">EN</a> |
            <a href="${pageContext.request.contextPath}/start?command=change_locale&localization=ru_RU">RU</a>
        </td>
    </tr>
</table>