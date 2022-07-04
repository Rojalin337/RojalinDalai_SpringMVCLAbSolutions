<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<body>
 <spring:url value="/student/add" var="addURL" />
 <a href="${addURL }">Add new Student</a>
 
 <table width="100%" border="1">
  <tr>
   <td>ID</td>
   <td>Name</td>
   <td>Department</td>
   <td>Country</td>
   
   <td colspan="2">Action</td>
  </tr>  
  <c:forEach items="${listStudent}" var="student" >
   <tr>
    <td>${student.id }</td>
    <td>${student.name }</td>
    <td>${student.department}</td>
    <td>${student.country}</td>
    
    <td>
     <spring:url value="/student/update/${student.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/student/delete/${student.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>
  </c:forEach>
 </table>
</body>
</html>