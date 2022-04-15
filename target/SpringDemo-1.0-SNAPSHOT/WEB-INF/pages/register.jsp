<%-- 
    Document   : register
    Created on : Apr 9, 2022, 11:14:08 PM
    Author     : billg
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register Page</title>
        <link href="<c:url value="/css/regstyle.css"/>" rel="stylesheet"/>
    </head>
    <body>
        <div class="wrapper">
            <h2>Registration</h2>
            <c:url value="/register" var="action" />
            <form:form method="post" action="/SpringDemo/register" modelAttribute="user" enctype="multipart/form-data">
                <div class="input-box">
                    <form:input path="username" class="form-control" placeholder="Enter your name" />
                </div>
                <div class="input-box">
                    <form:password path="password" class="form-control" placeholder="Create password" />
                </div>       
                <p style="color:#4070f4">Upload avatar</p>
                <div class="policy">
                     <form:input type="file" path="file" class="form-control" placeholder="Enter your avatar" />
                </div>
                <div class="input-box button">
                    <input type="Submit" value="Register">
                </div>
                <div class="text">
                    <h3>Already have an account? <a href="<c:url value="/login"/>">Login now</a></h3><br>
                    <a href="/SpringDemo/" class="text signup-link" style="text-decoration: none;
                       margin-left: 30%;">Back Home Page</a>
                </div>
            </form:form>
        </div>
    </body>
</html>

