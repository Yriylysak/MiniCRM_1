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
    <title>Authorization</title>
    <script>
        function checkAuthFields() {
            var login = document.getElementById("login");
            var pass = document.getElementById("password");

            var error = document.getElementById("error");

            if (login.value == '') {
                error.innerHTML = "Error! Login can't be empty!";
                return false;
            }

            if (pass.value == '') {
                error.innerHTML = "Error! Password can't be empty!";
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div>
    <fieldset>
        <legend>Authorization</legend>
        <span id="error" style="color: #ff0000"></span>
        <form action="/auth" method="post" onsubmit="return checkAuthFields()">
            <p>Login  :</p><input type="text" name="login" id="login"/><br>
            <p>Password :</p><input type="password" name="password" id="password"/><br>
            <input type="submit" onclick="checkAuthFields()">
        </form>
    </fieldset>
</div>
<form action="/js" method="get">
    <input type="submit" name="JavaScript">
</form>

</body>
</html>
