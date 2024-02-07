<%-- 
    Document   : uploadfile
    Created on : 30-Jun-2023, 2:15:58 am
    Author     : namithajc
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Files</title>
    </head>
    <style>
        label{
    width:20px;
    font-size: 15px;
    padding: 10px 8px;
}

form select{
    padding: 10px 8px;
}

input[type=file] {
  width: 20%;
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
    </style>
    <body>
        <form action="goHome.htm" method="get">
                <input type="submit" name="button" value="Home">
            </form>
        <h2>Personal HealthCare App</h2>
        <h1>The Document Store</h1>
<!--        <form action="fileUpload.htm" method="post" enctype="multipart/form-data">
            <label for="types">Choose your file type:</label>
            <select id="types" name="types">
                <option value="reports">Reports</option>
                <option value="Bills">Bills</option>
                <option value="prescription">Prescription</option>
            </select>
            <input type="file" name="file"/>
            <input type="submit" value="Upload File"/>
        </form>-->
        <form:form modelAttribute="filePdf" method="post" enctype="multipart/form-data">
            <label>File Type:</label> <form:select path="reportType">
        <form:option value="Reports" label="Reports"/>  
        <form:option value="Bills" label="Bills"/>  
        <form:option value="Prescription" label="Prescription"/>  
            </form:select> <br>
         <label>Pdf File:</label> <input type="file" name="filePdf" required="required"/><form:errors path="filePdf" /><br>
            <input type="submit" value="Add File"/>
        </form:form>
            <form action="viewAll.htm" method="get">
                <input type="submit" value="View Files"/>
            </form>
    </body>
</html>
