<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Julia
  Date: 06.03.2017
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
    <script>
        function checkAuthFields()
        {
            var login = document.getElementById("login");
            var password = document.getElementById("password");
            var error = document.getElementById("error");


            if(login.value=='')
            {
                error.innerHTML = "Не заполнено поле логина!";
                return false;
            }

            if(password.value=='')
            {
                error.innerHTML = "Не заполнено поле пароля!";
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<fieldset>
    <legend>Введите логин и пароль:</legend>
    <span id="error" style="color: red"> </span>
    <form:form action="/index" onsubmit="return checkAuthFields()" modelAttribute="user">
        <span>Логин  :</span><form:input path="login"/><br/>
        <span>Пароль:</span><form:input path="password"/><br/>
        <input type="submit" value="Вход" onclick="checkAuthFields()"/>
    </form:form>
    <form action="/index" method="get" name="registry"> <input type="submit" value="Регистрация">
    </form>
</fieldset>
</body>
</html>
