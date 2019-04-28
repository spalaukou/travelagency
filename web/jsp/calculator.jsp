<%--
  Created by IntelliJ IDEA.
  User: Станислав
  Date: 27.04.2019
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form name="calculate" action="${pageContext.request.contextPath}\mainController" method="post">
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
</body>
</html>
