<%-- 
    Document   : newjsp
    Created on : 02-Jul-2023, 9:58:37 am
    Author     : namithajc
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.me.pojo.HealthValues"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Health Checkup</title>
    </head>
    
    <style>
        
    </style>
    <body>
        <form action="goHome.htm" method="get">
                <input type="submit" name="button" value="Home">
            </form>
        <h2>Personal HealthCare App</h2>
        <c:choose>
        <c:when test="${requestScope.healthDetailsList.size() > 0}">
        <c:forEach var="healthValues" items="${requestScope.healthDetailsList}">
            <h1>Enter your Health Data</h1>
                <form action ="updateDetails.htm" method="post">
                    <input type="checkbox" name="selected" checked hidden value="${healthValues.healthId}"></input>
                <input type ="text" name="bloodPressure" placeholder="${healthValues.bloodPressure}"/>
                <input type ="text" name="bloodSugar" placeholder="${healthValues.bloodSugar}"/>
                <input type="text" name="totalCholestrol" placeholder="${healthValues.totalCholestrol}"/>
                <input type ="text" name="bmi" placeholder="${healthValues.bmi}"/>
                <input type ="submit" value="Update Details" />
        </form>
            <table>
            <tr>
                <td>Blood Pressure</td>
                <td>Blood Sugar</td>
                <td>Total Cholestrol</td>
                <td>BMI</td>
                <td>As Of</td>
            </tr>
            <tr>
                <td><c:out value="${healthValues.bloodPressure}"/></td>
                <td><c:out value="${healthValues.bloodSugar}"/></td>
                <td><c:out value="${healthValues.totalCholestrol}"/></td>
                <td><c:out value="${healthValues.bmi}"/></td>
                <td><c:out value="${healthValues.datetime}"/></td>
                </form>
            </tr>
            </table>
                
        </c:forEach> 
        <br />
    </c:when>    
        <c:otherwise>
       <h1>Add your Health Data</h1>
        <form action ="uploadDetails.htm" method="post">
                <input type ="text" name="bloodPressure" placeholder="Blood Pressure"/>
                <input type ="text" name="bloodSugar" placeholder="Blood Sugar"/>
                <input type="text" name="totalCholestrol" placeholder="Total Cholestrol"/>
                <input type ="text" name="bmi" placeholder="Body Mass Index"/>
                <input type ="submit" value="Upload Details" />
        </form>
        </c:otherwise>
        </c:choose>
        
    </body>
</html>
