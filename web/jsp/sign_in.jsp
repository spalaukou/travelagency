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

<jsp:include page="header/GuestHeader.jsp"/>

<div style="text-align: center;">
    <form name="loginForm" method="POST" action="${pageContext.request.contextPath}\start">
        <input type="hidden" name="command" value="sign_in"/>
        <p>Please, Sign In.</p>
        <p>Login:<br/>
            <input type="text" name="login"/>
        </p>
        <p>Password:<br/>
            <input type="password" name="password"/>
        </p>
        ${errorLoginPassMessage}
        ${shortLoginPassMessage}
        ${wrongAction}
        ${nullPage}
        <br/>
        <tr>
            <td colspan="2">
                <input type="reset" value="Clear form"/>
                <input type="submit" value="Sign In"/>
            </td>
        </tr>
    </form>
</div>
<jsp:include page="footer/footer.jsp"/>

</body>
</html>
