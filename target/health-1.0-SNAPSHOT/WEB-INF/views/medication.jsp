<%-- 
    Document   : medication
    Created on : 02-Jul-2023, 10:25:32 pm
    Author     : namithajc
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.me.pojo.Medication"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Medication</title>
    </head>
    <style>
        input[type=text], input[type=number], input[type=date], input[type=checkbox] {
  width: 30%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

input[type=submit] {
  display: flex;
  justify-content: space-between;
  background-color: darkslategrey;
  color: white;
  padding: 10px 10px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 8%;
}

        .medi {
  border-collapse: collapse;
  width: 100%;
}
        .medi td, .files th {
  border: 1px solid #ddd;
  padding: 6px;
}

.medi tr:nth-child(even){background-color: #f2f2f2;}

.medi tr:hover {background-color: #ddd;}

.medi th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: gainsboro;
  color: white;
}
    </style>
    <body>
        <form action="goHome.htm" method="get">
                <input type="submit" name="button" value="Home">
            </form>
        <h2>Personal HealthCare App</h2>
        <form action="medicine.htm" method="post">
            Name : <input type="text" name="medicineName"/><br>
            Quantity : <input type ="number" name="quantity" /><br><!-- comment -->
            Expiry Date : <input type="date" name="expiryDate" /><br>
            Morning : <input type="checkbox" name ="morning"/><br>
            Afternoon : <input type="checkbox" name ="afternoon"/><br>
            Night   : <input type="checkbox" name ="evening"/><br>
            <input type="submit" value="Add Medicine"/>
        </form>
        
        <br>
        <table class="medi">
            <tr>
                <td>Id</td>
                <td>Medicine Name</td>
                <td>Quantity</td>
                <td>Expiry</td>
                <td>After Breakfast</td>
                <td>After Lunch</td>
                <td>After Dinner</td>
            </tr>
                
        <c:forEach var="medicine" items="${requestScope.medicationList}">
            <tr>
                <td><c:out value="${medicine.id}"/></td>
                <td><c:out value="${medicine.name}"/></td>
                <td><c:out value="${medicine.quantity}"/></td>
                <td><c:out value="${medicine.expiryDate}"/></td>
                <td>
                    <c:choose>
                    <c:when test="${medicine.isMorning == true}">
                        <img width="15px" height="15px" src="${pageContext.request.contextPath}/resources/images/check.png"/>
                    </c:when>
                    <c:otherwise>
                        <img width="15px" height="15px" src="${pageContext.request.contextPath}/resources/images/remove.png"/>
                    </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                    <c:when test="${medicine.isAfternoon == true}">
                        <img width="15px" height="15px" src="${pageContext.request.contextPath}/resources/images/check.png"/>
                    </c:when>
                    <c:otherwise>
                        <img width="15px" height="15px" src="${pageContext.request.contextPath}/resources/images/remove.png"/>
                    </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                    <c:when test="${medicine.isEvening == true}">
                        <img width="15px" height="15px" src="${pageContext.request.contextPath}/resources/images/check.png"/>
                    </c:when>
                    <c:otherwise>
                        <img width="15px" height="15px" src="${pageContext.request.contextPath}/resources/images/remove.png"/>
                    </c:otherwise>
                    </c:choose>
                </td>
                </form>
            </tr>
        </c:forEach> 
        </table>
        <h4>From the above details which record you want to delete or update</h4>
            <form action="updateMedicines.htm" method="post">
                <label>Enter the Medicine ID</label>
                <input type="text" name="selection">
                <input type="submit" name="button" value="Delete">
                <input type="submit" name="button" value="Update">
            </form>
    </body>
</html>