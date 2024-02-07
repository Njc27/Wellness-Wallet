<%-- 
    Document   : registerUser
    Created on : 03-Jul-2023, 1:12:18 pm
    Author     : namithajc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/register.css"
    rel="stylesheet">
        <title>Register a New User</title>
    </head>
    <body>
        
        <h2>Personal HealthCare App</h2>
        <div>
            <form action = "register.htm" method="post">
<!--                <h2>Personal HealthCare App</h2>-->
                <h3>Please register here</h3><br><br>
                <label>First Name:</label>
                <input type="text" name="firstName" placeholder="First Name" /><br>
                <label>Last Name:</label>
                <input type="text" name="lastName" placeholder="Last Name" /><br>
                <label>Date Of Birth: </label>
                <input type="date" name="dob"/><br>
                <label>Email:</label>
                <input type="text" name="email" placeholder="Email" /><br>
                <label>Password:</label>
                <input type="text" name="password" placeholder="Password" /><br>
                <input type ="submit" value="Register"/>
            </form>
        </div>
    </body>
</html>
