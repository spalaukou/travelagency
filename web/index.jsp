<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Станислав
  Date: 18.04.2019
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Travel Agency GoTravel</title>

    <style type="text/css">
        a.button {display:grid; height:100%; width:100%; text-align: center}
    </style>
</head>

<body>

<c:if test="${sessionScope.user == null}">
    <jsp:include page="jsp/header/GuestHeader.jsp"/>
</c:if>

<c:if test="${sessionScope.user != null}">
    <jsp:include page="jsp/header/CustomerHeader.jsp"/>
</c:if>

<br/>
<div style="text-align: center;">
    Please <a href="${pageContext.request.contextPath}/jsp/sign_in.jsp">Sign In</a>
    (do not have an account? <a href="${pageContext.request.contextPath}/jsp/sign_up.jsp">Sign Up</a>)
    to buy a tour, or select tours that interest you:
</div>
<br/>

<table width="100%" cellspacing="0" cellpadding="4">
    <tr>
        <td width="25%" bgcolor="#A9DFBF"><a href="start?command=show_all_tours" class="button">Show all Tours</a></td>
        <td width="25%" bgcolor="#F9E79F"><a href="start?command=show_spain_tours" class="button">Travel to Spain</a></td>
        <td width="25%" bgcolor="#F1948A"><a href="start?command=show_turkey_tours" class="button">Rest in Turkey</a></td>
        <td width="25%" bgcolor="#D3EDF6"><a href="start?command=show_greece_tours" class="button">Vacation in Greece</a></td>
    </tr>
</table>
<br/>

<jsp:include page="jsp/footer/footer.jsp"/>

</body>
</html>