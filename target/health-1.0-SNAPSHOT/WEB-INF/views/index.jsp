<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
<!--        <link href="${pageContext.request.contextPath}/resources/css/index.css"
    rel="stylesheet">-->
    </head>
    
    <style>
        body {
            
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Fira Sans", "Droid Sans", "Helvetica Neue", Helvetica, "ヒラギノ角ゴ Pro W3", "Hiragino Kaku Gothic Pro", メイリオ, Meiryo, "ＭＳ Ｐゴシック", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
}

.main-head h1 {
    color: black;
    text-align: center;
}

.main-head h3{
    text-align: center;
    text-transform: uppercase;
}
.main-head{
    display: grid;
    grid-template-columns: 1fr 0.2fr;
    justify-content: center;
    margin: 3rem;
}

input[type=submit] {
    display:flex;
    justify-content: center;
    background-color: darkslategray;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 30%;
}

input[type=submit]:hover {
  opacity: 0.8;
}
    </style>

    <body>
        <div class='main-head'>
        <h1>Wellness Wallet</h1>
        <h3>${requestScope.user.firstname} ${requestScope.user.lastname}</h3>
            </div>
        <h2>An application that serves as a comprehensive platform for organizing and accessing all your healthcare documents, including 
            medical records, lab results, prescriptions, and personal health information, ensuring everything is conveniently stored 
            and easily retrievable.</h2>
        <div class="fileUpload">
            <form action="fileUpload.htm" method = "get">
                
            <input type="submit" value="Manage Files" />
            </form>
        </div>
        <div class="health_detls">
            <form action="redirectUpload.htm" method = "get">
            <input type="submit" value="Manage Health Details" />
            </form>
        </div>
        <div class="medication">
            <form action="medicine.htm" method = "get">
            <input type="submit" value="Your Medications" />
            </form> 
        </div>
<!--        <div>
            <form action="register.htm" method = "get">
            <input type="submit" value="Register User" />
            </form> 
        </div>-->
    </body>
</html>
