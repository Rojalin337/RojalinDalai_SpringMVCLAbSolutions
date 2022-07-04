<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>
 <spring:url value="/student/save" var="saveURL" />
 
 <form:form action="${saveURL}" method="POST" modelAttribute="studentForm">
  <form:hidden path="id"/>
  <table>
   <tr>
    <td>Name</td>
    <td><form:input path="name"/></td>
   </tr>
   <tr>
    <td>Department</td>
    <td><form:input path="department"/></td>
   </tr>  
   
   <tr>
    <td>Country</td>
    <td><form:input path="country" /></td>
   </tr>
   <tr>
    <td></td>
    <td><button type="submit">Save</button></td>
   </tr>
  </table>
 </form:form>
</body>
</html>