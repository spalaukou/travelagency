<%--
  Created by IntelliJ IDEA.
  User: Станислав
  Date: 27.04.2019
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<div style="overflow:hidden">
    <div style="float:left">
        <a href ="${pageContext.request.contextPath}">GoTravel</a>
    </div>
    <div style="float:right">
        <a href ="${pageContext.request.contextPath}/jsp/sign_in.jsp">Sing In</a>
        <a href ="${pageContext.request.contextPath}">Sing Up</a>
    </div>
</div>

<hr/>

<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="sign_in" />
    Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
    <tr>
        <td colspan="2">
            <input type="reset" value="Reset"/>
            <input type="submit" value="Log in"/>
        </td>
    </tr>
</form><hr/>

</body>
</html>
