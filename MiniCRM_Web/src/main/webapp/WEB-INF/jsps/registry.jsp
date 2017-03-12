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
        fieldset {
            width: 200px; /* Ширина таблицы */
            border: 1px solid #060080; /* Рамка вокруг таблицы */
            background-color: #fff5b1;
            margin: auto; /* Выравниваем таблицу по центру окна  */
        }

        fieldset:hover {
            border: 2px solid #060080; /* Рамка при наведении на рисунок курсора мыши */
        }

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
<fieldset>
    <span id="error" style="color: red"> </span>
    <form:form action="/registry"  onsubmit="return checkAuthFields()" modelAttribute="user">
        <span>Логин :</span><br/><form:input path="login"/><br/>
        <span>Пароль :</span><br/><form:input path="password"/><br/>
        <span>Имя :</span><br/><form:input path="name"/><br/>
        <span>Фамилия:</span><br/><form:input path="surname"/><br/>
        <span>Email:</span><br/><form:input path="email"/><br/>
        <span>Телефон:</span><br/><form:input path="phone"/><br/>
        <span>Адресс:</span><br/><form:input path="address"/><br/>
        <input type="submit" value="Регистрация" onclick="checkAuthFields()"/>
    </form:form>
</fieldset>
</body>
</html>
