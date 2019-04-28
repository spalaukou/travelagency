<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Станислав
  Date: 27.04.2019
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Result</title>
</head>
<body>

    <%--<%
        int res = Integer.parseInt(request.getAttribute("result") + "");
        String s = request.getParameter("a") + " + " + request.getParameter("b")
                + " = " + res;

        out.println(s);
    %>--%>

    Result is:
    <br/>
    <c:out value="${param.a} + ${param.b} = ${requestScope.result}"/>

    <br/>
    <a href="${pageContext.request.contextPath}/jsp/calculator.jsp">Back to calculator</a>
    <br/>
    <a href ="${pageContext.request.contextPath}">Back to main page</a>

</body>
</html>
