
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Teacher</title>

        <style>

            .error, #msg{
                color: #ff0000;
            }
        </style>
    </head>
    <body>
        <h1>Register a new Teacher</h1>       
        <form:form method="POST" action="new" modelAttribute="teacher">
            <form:input type="hidden" path="id" id="id"/>
            First Name: <form:input path="firstName" /> <form:errors path="firstName" cssClass="error"/><br />
            Last Name: <form:input path="lastName" /> <form:errors path="lastName" cssClass="error"/><br />
            Subject: <form:input path="subject" /> <form:errors path="subject" cssClass="error"/><br />
            <input type="submit">
        </form:form>
        <br>
        <div id="msg">${message}</div>
        <br>
        <div id="list"><a href="<c:url value='/${listurl}' />">Back to the list of Teachers</a></div>
    </body>
</html>
