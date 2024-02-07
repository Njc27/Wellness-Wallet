<%-- 
    Document   : viewFiles
    Created on : 04-Jul-2023, 4:45:23 pm
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
        <title>Uploaded Files</title>
    </head>
    
    <style>
        .files {
  border-collapse: collapse;
  width: 100%;
}

input[type=text], input[type=password] {
  width: 30%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

.files td, .files th {
  border: 1px solid #ddd;
  padding: 8px;
}

.files tr:nth-child(even){background-color: #f2f2f2;}

.files tr:hover {background-color: #ddd;}

.files th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: gainsboro;
  color: white;
  
  input[type=submit] {
  background-color: darkslategrey;
  color: white;
  padding: 10px 10px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 10%;
}
}
    </style>
    <body>
        <form action="goHome.htm" method="get">
                <input type="submit" name="home_button" value="Home">
            </form>
        <h2>Personal HealthCare App</h2>
        <h1>Uploaded files</h1>
         <table>
            <tr class="files">
                <td>Id</td>
                <td>File Name</td>
                <td>File Type</td>
            </tr>
         <c:forEach var="file" items="${requestScope.fileList}">
            <tr>
                <td><c:out value="${file.fileId}"/></td>
                <td><c:out value="${file.filename}"/></td>
                <td><c:out value="${file.reportType}"/></td>
                </form>
            </tr>
        </c:forEach> 
         </table>
        <form action="download.htm" method="post">
                <label>Enter the File ID</label>
                <input type="text" name="selection">
                <input type="submit" name="button" value="Download">
            </form>
    </body>
</html>
