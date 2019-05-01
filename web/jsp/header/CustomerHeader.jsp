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
        <td width="70%" style="text-align: center;">Welcome to GoTravel, ${login}!</td>
        <td>
            <div style="text-align: right;">
                <a href="start?command=sign_out">Sign out</a>
            </div>
        </td>
    </tr>
</table>

<hr/>

<table width="100%" cellspacing="0" cellpadding="4" border="1">
    <tr>
        <td width="20%" style="text-align: center;">Profile info</td>
        <td width="20%" style="text-align: center;">Role: ${userType}</td>
        <td width="20%" style="text-align: center;">ID: ${userid}</td>
        <td width="20%" style="text-align: center;">Balance: ${balance}</td>
        <td width="20%" style="text-align: center;">Discount: ${discount}</td>
    </tr>
</table>

<hr/>

</body>
</html>
