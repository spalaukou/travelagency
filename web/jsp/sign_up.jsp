<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>

<jsp:include page="header/guestHeader.jsp"/>

<div style="text-align: center;">
    <form name="loginForm" method="POST" action="${pageContext.request.contextPath}\start">
        <input type="hidden" name="command" value="sign_up"/>
        <p>Please, Sign Up.</p>
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
                <input type="submit" value="Sign Up"/>
            </td>
        </tr>
    </form>
</div>
<jsp:include page="footer/footer.jsp"/>

</body>
</html>
