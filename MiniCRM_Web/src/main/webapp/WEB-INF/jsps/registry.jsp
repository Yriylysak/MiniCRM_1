<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: otecdimitry
  Date: 12.03.17
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <style>
        body{
            background-color: #9c8f50;
            background-image: url(http://www.transparenttextures.com/patterns/brick-wall-dark.png);

        }
        #reg{
            margin: auto;
            width: auto;
        }
        .regblock{
            margin: auto;
        }

        #regfield {
            width: 300px; /* Ширина таблицы */
            margin: auto; /* Выравниваем таблицу по центру окна  */
            border-radius: 5px;
        }

        /*fieldset:hover {
            border: 2px solid #060080; !* Рамка при наведении на рисунок курсора мыши *!
        }*/

    </style>
    <script>
        function checkAuthFields()
        {
            var login = document.getElementById("login");
            var password = document.getElementById("password");
            var name = document.getElementById("name");
            var surname = document.getElementById("surname");
            var email = document.getElementById("email");
            var error = document.getElementById("error");


            if(login.value=='')
            {
                error.innerHTML = "Введите логин!";
                return false;
            }
            if(name.value=='')
            {
                error.innerHTML = "Введите пароль!";
                return false;
            }
            if(name.value=='')
            {
                error.innerHTML = "Введите имя!";
                return false;
            }

            if(surname.value=='')
            {
                error.innerHTML = "Введите пароль!";
                return false;
            }

            if(email.value=='')
            {
                error.innerHTML = "Введите Email!";
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<div id="reg">
    <div class="regblock" align="center">

        <legend><h3><i>Регистрация на сайте</i></h3></legend><br/>
    <span id="error" style="color: red"> </span>
    <form:form action="/registry"  onsubmit="return checkAuthFields()" modelAttribute="user">
        <span><i>Логин</i> </span><br/><form:input path="login"/><br/>
        <span><i>Пароль</i> </span><br/><form:password path="password"/><br/>
        <span><i>Имя </i></span><br/><form:input path="name"/><br/>
        <span><i>Фамилия</i></span><br/><form:input path="surname"/><br/>
        <span><i>Email</i></span><br/><form:input path="email"/><br/>
        <span><i>Телефон</i></span><br/><form:input path="phone"/><br/>
        <span><i>Адресс</i></span><br/><form:input path="address"/><br/><br/>
        <input type="submit" value="Регистрация" onclick="checkAuthFields()"/>
    </form:form>

    </div>
</div>
</body>
</html>
