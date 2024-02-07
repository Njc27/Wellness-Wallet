<%-- 
    Document   : updateMedication
    Created on : 04-Jul-2023, 6:00:13 am
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
        <title>Edit Medication</title>
    </head>
    <style>
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
    </style>
    <body>
        <form action="goHome.htm" method="get">
                <input type="submit" name="button" value="Home">
            </form>
        <h2>Personal HealthCare App</h2>
        <h1>Edit Medications</h1>
        <form action="updateMedi.htm" method="post">
            <input type ="checkbox" name = "selection" value =${medicationList.id} checked hidden="true"/>
            Name :<input type="text" name="medicineName" value=${medicationList.name} placeholder="Medicine"/>
            Quantity : <input type ="number" name="quantity" value=${medicationList.quantity} />
            Expiry Date :<input type="date" name="expiryDate" value=${medicationList.expiryDate} />
            Morning :<input type="checkbox" name ="morning" value=${medicationList.isMorning}/>
            Afternoon :<input type="checkbox" name ="afternoon" value=${medicationList.isAfternoon}/>
            Night :<input type="checkbox" name ="evening" value=${medicationList.isEvening} />
            <input type="submit" value="Edit Medicine"/>
        </form>
    </body>
</html>
