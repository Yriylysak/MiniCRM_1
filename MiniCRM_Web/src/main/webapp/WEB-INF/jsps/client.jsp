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

        /*button:hover {
            border: 2px solid #060080; !* Рамка при наведении на рисунок курсора мыши *!
        }*/

    </style>
</head>
<body>
<div id="cabinet">
    <div class="change">
        <fieldset id="changefield">
            <legend><i>Изменение информации</i></legend>
            <form:form action="/client"  onsubmit="return checkAuthFields()" modelAttribute="user">
                <span><i>Логин</i> </span><br/><form:input path="login"/><br/>
                <span><i>Пароль</i> </span><br/><form:input path="password"/><br/>
                <span><i>Имя </i></span><br/><form:input path="name"/><br/>
                <span><i>Фамилия</i></span><br/><form:input path="surname"/><br/>
                <span><i>Email</i></span><br/><form:input path="email"/><br/>
                <span><i>Телефон</i></span><br/><form:input path="phone"/><br/>
                <span><i>Адресс</i></span><br/><form:input path="address"/><br/><br/>
                <input type="submit"  value="Изменить" onclick="checkAuthFields()"/>
            </form:form>
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
