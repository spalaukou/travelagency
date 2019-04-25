<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.04.2019
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form name="sign_up" method="POST" action="controller">
    <input type="hidden" name="command" value="login" />
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
    <input type="submit" value="Log in"/>
</form>

<form name="sign_up" method="post" action="mainCot">
    <p><b>Sign up</b><br>
    <p>Login:<br>
        <input type="text" name="login" size="40">
    </p>
    <p>Password:<br>
        <input type="text" name="password" size="40">
    </p>
    <p><input type="submit" value="Отправить">
        <input type="reset" value="Очистить"></p>
</form>

</body>
</html>
