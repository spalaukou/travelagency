<%--
  Created by IntelliJ IDEA.
  User: Станислав
  Date: 29.04.2019
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>

<table width="100%" cellspacing="0" cellpadding="4">
    <tr>
        <td width="15%"><a href="${pageContext.request.contextPath}">GoTravel</a></td>
        <td width="70%" style="text-align: center;">Welcome to GoTravel</td>
        <td>
            <a href="${pageContext.request.contextPath}/jsp/sign_in.jsp">Sign In</a>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/jsp/sign_up.jsp">Sign Up</a>
        </td>
    </tr>
</table>

<hr/>

</body>
</html>
