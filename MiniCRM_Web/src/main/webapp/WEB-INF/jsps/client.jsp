<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: otecdimitry
  Date: 12.03.17
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный кабинет</title>
    <style>
        body{
            background-color: #9c8f50;
            background-image: url(http://www.transparenttextures.com/patterns/brick-wall-dark.png);
        }
        #cabinet{
            margin: auto;
            width: auto;
        }
        .change{
            float: left;
        }
        .centerfield{
            width: 750px;
            margin: 0px 0px 0px 15px;
            float: left;
        }
        #centerfieldset{
            border: 1px solid #060080; /* Рамка вокруг таблицы */
            border-radius: 5px;
            width: 725px;
            height: 500px;
            text-align: left;
        }
        #textarea{
            float: right;
            width: 400px;
            height: 470px;
        }
        .divform{
            width: 400px;
            float: left;
        }
        .divtextarea{
            width: 300px;
            float: right;
        }
        .history{
            float: right;
        }
        #orderhistory{
            width: 300px;
            height: auto;
            border: 1px solid #060080; /* Рамка вокруг таблицы */
            border-radius: 5px;

        }
        #changefield {
            width: 220px; /* Ширина таблицы */
            border: 1px solid #060080; /* Рамка вокруг таблицы */
            border-radius: 5px;
        }


    </style>
</head>
<body>
<div id="cabinet">
    <div class="change">
        <fieldset id="changefield">
            <legend><i>Изменение информации</i></legend>
            <form:form action="/client"  onsubmit="return checkAuthFields()" modelAttribute="user">
                <span><i>Логин</i> </span><br/><form:input path="login"/><br/>
                <span><i>Пароль</i> </span><br/><form:password path="password"/><br/>
                <span><i>Имя </i></span><br/><form:input path="name"/><br/>
                <span><i>Фамилия</i></span><br/><form:input path="surname"/><br/>
                <span><i>Email</i></span><br/><form:input path="email"/><br/>
                <span><i>Телефон</i></span><br/><form:input path="phone"/><br/>
                <span><i>Адресс</i></span><br/><form:input path="address"/><br/><br/>
                <input type="button"  value="Изменить" onclick="checkAuthFields()"/>
            </form:form>
        </fieldset>
    </div>
<div class="centerfield">
    <fieldset id="centerfieldset">
    <legend><i><font color="#ffd700">Оформление заказа</font></i></legend>
        <div class="divform">
        <span><i>Наименование товара</i></span><br/><input type="search" size="40px"><br/>
        <span><i>Количество</i></span><br/><input type="search" size="10px"><br/>
        <span><i>Телефон</i></span><br/><input type="search" size="40px"><br/>
        <span><i>Email</i></span><br/><input type="search" size="40px"><br/>
        <span><i>Адресс доставки</i></span><br/><input type="search" size="40px"><br/><br/>
        <input type="button" value="Оформить заказ">
        </div>
        <div class="divtextarea">
            <textarea id="textarea"></textarea>
        </div>
    </fieldset>

</div>
    <div class="history">
        <fieldset id="orderhistory">
            <legend><i>История заказов</i></legend>
        </fieldset>
    </div>
</div>
</body>
</html>
