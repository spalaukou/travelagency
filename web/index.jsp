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
</head>

<body>

<c:if test="${sessionScope.user == null}">
    <jsp:include page="jsp/header/GuestHeader.jsp"/>
</c:if>

<%--<c:if test="${sessionScope.user != null}">
    <jsp:include page="header/RegistredUserHeader.jsp">
        <jsp:param name="balance" value="${balance}"/>
    </jsp:include>
</c:if>--%>

<%--<div style="overflow:hidden">
    <div style="float:left">
        <a href="${pageContext.request.contextPath}">GoTravel</a>
    </div>
    <div style="float:right">
        <a href="${pageContext.request.contextPath}/jsp/sign_in.jsp">Sign In</a>
        <a href="${pageContext.request.contextPath}">Sign Up</a>
    </div>
</div>

<hr/>--%>

<div style="text-align: center;">
    <form name="sign_up" method="post" action="start">
        <input type="hidden" name="command" value="sign_up">
        <p>Register form</p>
        <p>Login:<br>
            <input type="text" name="login" size="20">
        </p>
        <p>Password:<br>
            <input type="text" name="password" size="20">
        </p>
        <input type="reset" value="Clear form">
        <input type="submit" value="Sign Up">
    </form>
</div>

<hr/>

<div style="text-align: center;">
    <a href="start?command=show_all_tours">Show all tours</a>
</div>

<%--<div style="float: left;">
    <form name="show_all_tours" method="post" action="mainController">
        <input type="hidden" name="command" value="show_all_tours">
        <input type="submit" value="Show all tours">
    </form>
</div>
<div style="float: left;">
    <form name="show_turkey_tours" method="post" action="mainController">
        <input type="submit" value="Rest in Turkey">
    </form>
</div>
<div style="float: left;">
    <form name="show_spain_tours" method="post" action="mainController">
        <input type="submit" value="Travel to Spain">
    </form>
</div>
<br/>
<br/>--%>

<jsp:include page="jsp/footer/footer.jsp"/>

<%--<a href="${pageContext.request.contextPath}/jsp/calculator.jsp">calculator</a>

<form name="calculate" action="mainController" method="post">
    <input type="hidden" name="command" value="calculate"/>
    <table>
        <tr>
            <td>value of a:</td>
            <td>
                <input type="text" name="a" value="0">
            </td>
        </tr>
        <tr>
            <td>value of b:</td>
            <td>
                <input type="text" name="b" value="0">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="reset" value="reset"/>
                <input type="submit" value="calculate"/>
            </td>
        </tr>
    </table>
</form>

<hr/>--%>

</body>
</html>