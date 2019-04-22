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
    <title>$Title$</title>
</head>

<body>

<form action="FirstServletTest">
    <input type="submit" value="Execute">
</form>
$END$
<h5>Счетчик времени от запуска приложения до нажатия кнопки</h5>

<jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>
<form name="Simple" action="timeaction" method="POST">
    <input type="hidden" name="time" value="${calendar.timeInMillis}"/>
    <input type="submit" name="button" value="Посчитать время"/>
</form>

<jsp:forward page="/jsp/login.jsp"/>

</body>

</html>