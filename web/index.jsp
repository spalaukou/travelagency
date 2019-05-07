<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Travel Agency GoTravel</title>

    <style type="text/css">
        a.button {display:grid; height:100%; width:100%; text-align: center}
    </style>
</head>

<body>

<%--Кодировка запроса: ${pageContext.request.characterEncoding}--%>

<c:if test="${sessionScope.login == null}">
    <jsp:include page="jsp/header/guestHeader.jsp"/>
    <br/>
    <div style="text-align: center;">
        Please <a href="${pageContext.request.contextPath}/jsp/sign_in.jsp">Sign In</a>
        (do not have an account? <a href="${pageContext.request.contextPath}/jsp/sign_up.jsp">Sign Up</a>)
        to buy a tour, or select tours that interest you:
    </div>
    <br/>
</c:if>

<c:if test="${sessionScope.login != null}">
    <jsp:include page="jsp/header/userHeader.jsp"/>
    <div style="text-align: center;">
            ${errorNotEnoughMoneyMessage}<br/>
                Please select tours that interest to buy:
    </div>
</c:if>

<br/>

<table width="100%" cellspacing="0" cellpadding="4" border="1">
    <tr>
        <td width="25%" bgcolor="#A9DFBF"><a href="start?command=show_tours" class="button">Show all Tours</a></td>
        <td width="25%" bgcolor="#F9E79F"><a href="start?command=show_tours&country=spain" class="button">Travel to Spain</a></td>
        <td width="25%" bgcolor="#F1948A"><a href="start?command=show_tours&country=turkey" class="button">Rest in Turkey</a></td>
        <td width="25%" bgcolor="#D3EDF6"><a href="start?command=show_tours&country=egypt" class="button">Vacation in Egypt</a></td>
    </tr>
</table>

<br/>

<div style="text-align: center;">
    Travel with us, get great offers and personal discounts!<br/><br/><br/>
    We offer next personal discounts:<br/>
    After purchase on $1000 - 5%.<br/>
    After purchase on $2000 - 10%.<br/>
    After purchase on $5000 - 20%.
</div>

<br/>

<jsp:include page="jsp/footer/footer.jsp"/>

</body>
</html>