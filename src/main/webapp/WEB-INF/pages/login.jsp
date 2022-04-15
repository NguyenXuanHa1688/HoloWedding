<%-- 
    Document   : login
    Created on : Mar 20, 2022, 9:58:22 PM
    Author     : billg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <h1 style="color: red;">${message}</h1>
<form:form method="post" action="/SpringDemo/login" modelAttribute="user" >
    Username: <form:input path="username" />
    Password: <form:password path="password" />
    <input type="submit" value="Login"/>
</form:form>
</body>
</html>-->

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <link href="<c:url value="/css/loginstyle.css"/>" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
            <div class="forms">
                <div class="form login">
                    <span class="title">Login</span>

                    <form:form method="post" action="/SpringDemo/login" modelAttribute="user" >
                        <div class="input-field">
                            <form:input path="username" placeholder="Enter your email" />
                            <i class="uil uil-envelope icon"></i>
                        </div>
                        <div class="input-field">
                            <form:password path="password" placeholder="Enter your password" />
                            <i class="uil uil-lock icon"></i>
                            <i class="uil uil-eye-slash showHidePw"></i>
                        </div>

                        <div class="checkbox-text">
                            <div class="checkbox-content">
                                <input type="checkbox" id="logCheck">
                                <label for="logCheck" class="text">Remember me</label>
                            </div>

                            <a href="#" class="text">Forgot password?</a>
                        </div>

                        <div class="input-field button">
                            <input type="submit" value="Login Now">
                        </div>
                    </form:form>

                    <div class="login-signup">
                        <span class="text">Not a member?
                            <a href="<c:url value="/register"/>" class="text signup-link">Signup now</a><br>
                            <a href="/SpringDemo/" class="text signup-link">Back Home Page</a>          
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
