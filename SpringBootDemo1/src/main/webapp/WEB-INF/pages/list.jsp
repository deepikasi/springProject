<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <table>
            <th>Id</th>
            <th>Username</th>
            <th>Phoneno</th>
            <th>City</th>
            <c:forEach var="lis" items="${User }">
                  <tr>
                        <td>${lis.id }</td>
                        <td>${lis.userName }</td>
                        <td>${lis.phoneNo }</td>
                         <td>${lis.city}</td>
                        <td><a href="Delete?id=${lis.id }">Delete</a>
                        <td><a href="Edit?id=${lis.id }">Edit</a>
                  </tr>
            </c:forEach>

      </table>
</body>
</html>

