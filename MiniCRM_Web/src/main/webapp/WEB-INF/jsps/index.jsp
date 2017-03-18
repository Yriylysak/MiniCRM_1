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
    <title>Главная страница</title>
    <style>
        body{
            /*background-color: #e1ffdb;*/
            background-color: #9c8f50;
            background-image: url(http://www.transparenttextures.com/patterns/brick-wall-dark.png);

        }
        #glaw{
            margin: auto;
            width: auto;
        }
        .text{
            color: #fdfbff;

        }
        .autor, .center{
            float: left;
            margin: 5px 5px 5px 5px;
            top: 3%;
        }
        .poisk{
            float: right;

        }
        .menublock{
            float: right;
            margin-top: 7px;

        }
        #mainfield{
            border-radius: 5px;
            margin: auto;
            width: 800px;
            height: 700px;
            border: 1px solid #060080; /* Рамка вокруг таблицы */
            text-align: left;

        }
        #menu{
            width: 200px;
            border-radius: 5px;
            height: auto;
            border: 1px solid #060080; /* Рамка вокруг таблицы */
        }
        #autorization {
            float: right;
            width: 220px; /* Ширина таблицы */
            border: 1px solid #060080; /* Рамка вокруг таблицы */
            border-radius: 5px;
            text-align: left;
            top: 3%;

           /* margin: auto; !* Выравниваем таблицу по центру окна  *!*/
        }

        #shapka{
            width: auto;
            background-color: #090a28;
        }
        /*button:hover {
            border: 2px solid #060080; !* Рамка при наведении на рисунок курсора мыши *!
        }*/

    </style>
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
<center>
    <fieldset id="shapka">
        <h2 class="text"><i>DRUGSTORE</i></h2>

    </fieldset>
</center>
<div id="glaw">

<div class="autor">
    <fieldset id="autorization">
    <legend><i>Авторизация</i></legend>
    <span id="error" style="color: red"> </span>
    <form:form action="/index" onsubmit="return checkAuthFields()" modelAttribute="user">
        <span><i>Логин:</i></span><br/><form:input path="login"/><br/>
        <span><i>Пароль:</i></span><br/><form:input path="password" /><br/>
        <input type="submit" value="Вход" onclick="checkAuthFields()"/>
    </form:form>
    <form action="/index" method="get" name="registry"> <input type="submit" value="Регистрация">
    </form>
    </fieldset>
</div>

    <div class="center">
        <fieldset id="mainfield">
            <span><i>Наименование товара</i></span><br/><input type="search"><br/>
            <span><i>Количество</i></span><br/><input type="search"><br/>
            <span><i>Телефон</i></span><br/><input type="search"><br/>
            <span><i>Email</i></span><br/><input type="search"><br/>
            <span><i>Адресс доставки</i></span><br/><input type="search"><br/><br/>
            <input type="button" value="Оформить заказ">
        </fieldset>
    </div>

<div class="poisk">
    <p><h5><i>Поиск на сайте</i></h5></p><input type="search"><input type="button" value="Поиск">
</div>

</div>

<div class="menublock">
    <fieldset id="menu">
        <legend><i>Меню сайта</i></legend>
    </fieldset>
</div>

</body>
</html>
