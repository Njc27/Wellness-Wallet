<%-- 
    Document   : login
    Created on : 03-Jul-2023, 3:37:09 pm
    Author     : namithajc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--        <link href="${pageContext.request.contextPath}/resources/css/login.css"
    rel="stylesheet">-->
        <title>Login</title>
    </head>
    
    <style>
        body{
    text-align: center;
        }

.container  form label{
    width:20px;
}

input[type=text], input[type=password] {
  width: 30%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

.container input[type=submit] {
  background-color: darkslategrey;
  color: white;
  padding: 10px 10px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 10%;
}
    </style>
    <body>
        <h2>Personal HealthCare App</h2>
        <h3>Please login to continue...</h3>
        <div class="container">
            <form action="login.htm" method="post">
                <label>Enter Email: </label>
                <input type="text" name="email"><br>
                <label>Enter Password: </label>
                <input type="password" name="password"><br>
                <input type="submit" value="Login">
            </form>
        </div>
        <div class="register_btn">
<!--            <form action="register.htm" method="get">
               <label>New User? Please register here!</label>
               <input type="submit" value="Register"/>
            </form>-->
            <label>New User?</label><!-- comment -->
            <a href="/health/register.htm">Please register here!</a>

        </div>
    </body>
</html>
