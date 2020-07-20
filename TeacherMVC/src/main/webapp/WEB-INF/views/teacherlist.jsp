
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teachers' List</title>
            <style>

            #msg {
                color: #ff0000;
            }
        </style>
    </head>
    <body>
        <h1>Teachers' List</h1>
        <table>
		<tr>
                    <td>ID</td><td>FIRST NAME</td><td>LAST NAME</td><td>SUBJECT</td><td></td>
		</tr>
		<c:forEach items="${teachers}" var="teacher">
			<tr>                         
                            <td><a href="<c:url value='${editurl}/${teacher.id}' />">${teacher.id}</a></td>
                            <td>${teacher.firstName}</td>
                            <td>${teacher.lastName}</td>
                            <td>${teacher.subject}</td>                 
                            <td><a href="<c:url value='${deleteurl}/${teacher.id}' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
        <br>
        <div id="msg">${msg}</div>
        <br>
        <a href="<c:url value='/new' />">Add New Teacher</a>
    </body>
</html>
