
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Teacher</title>
          <style>

            .error ,#msg {
                color: #ff0000;
            }
        </style>
    </head>
    <body>
        <h1>Update a Teacher</h1>
        
        <% 
            String updateUrlFINAL = request.getContextPath() + "/" + request.getAttribute("updateurl");
            session.setAttribute("updateUrlFINAL", updateUrlFINAL);
        %>
        <form:form method="POST" action="${updateUrlFINAL}" modelAttribute="teacher">
            <form:input type="hidden" path="id" id="id"/>
            First Name: <form:input path="firstName"  /> <form:errors path="firstName" cssClass="error"/><br />
            Last Name: <form:input path="lastName" /> <form:errors path="lastName" cssClass="error"/><br />
            Subject: <form:input path="subject" /> <form:errors path="subject" cssClass="error"/><br />
            <input type="submit" value="Update">
        </form:form>
        <br>
        <div id="msg">${message}</div>
        <br>
        <div id="list"><a href="<c:url value='/${listurl}' />">Back to the list of Teachers</a></div>
    </body>
</html>
