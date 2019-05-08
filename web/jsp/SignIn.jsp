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

<jsp:include page="footer/Footer.jsp"/>

</body>
</html>
