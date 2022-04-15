<%-- 
    Document   : about
    Created on : Apr 14, 2022, 3:59:38 PM
    Author     : billg
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>
    <link href="<c:url value="/css/about.css" />" rel="stylesheet"/>
</head>
<!-- ABOUT US-->
<div class="container">
    <br>
    <br>
    <div class="container text-center mt-5 py-5">
        <H3>OUR TEAM</H3>
        <hr class="mx-auto">
        <p>THIS IS OUR AMAZING TEAM MEMBER</p>
    </div>

    <div class="sub-container">
        <div class="teams">
            <img src="<c:url value="/img/quy.jpg" />" alt="Quy">
            <div class="name"> Tran Dinh Quy</div>
            <div class="desig">Developer</div>
            <div class="about">I have 10 years of experience working with youth agencies. I have a bachelor’s degree
                in outdoor education. I raise money, train leaders, and organize units. I have raised over $100,000
                each of the last six years. I consider myself a good public speaker, and I have a good sense of
                humor.</div>

            <div class="social-links">
                <a href="#"><i class="fab fa-facebook"></i></a>
                <a href="#"><i class="fab fa-instagram"></i></a>
                <a href="#"><i class="fab fa-twitter"></i></a>
                <a href="#"><i class="fab fa-github"></i></a>
            </div>
        </div>

        <div class="teams">
            <img src="<c:url value="/img/ha.png" />" alt="Ha" >
            <div class="name"> Nguyen Xuan Ha</div>
            <div class="desig">Developer</div>
            <div class="about">I have 10 years of experience working with youth agencies. I have a bachelor’s degree
                in outdoor
                education. I raise money, train leaders, and organize units. I have raised over $100,000 each of the
                last six
                years. I consider myself a good public speaker, and I have a good sense of humor.</div>

            <div class="social-links">
                <a href="#"><i class="fab fa-facebook"></i></a>
                <a href="#"><i class="fab fa-instagram"></i></a>
                <a href="#"><i class="fab fa-twitter"></i></a>
                <a href="#"><i class="fab fa-github"></i></a>
            </div>
        </div>

        <div class="teams">
            <img src="<c:url value="/img/long.png" />" alt="Long">
            <div class="name"> Tran Phat Long</div>
            <div class="desig">Developer</div>
            <div class="about">I have 10 years of experience working with youth agencies. I have a bachelor’s degree
                in outdoor
                education. I raise money, train leaders, and organize units. I have raised over $100,000 each of the
                last six
                years. I consider myself a good public speaker, and I have a good sense of humor.</div>

            <div class="social-links">
                <a href="#"><i class="fab fa-facebook"></i></a>
                <a href="#"><i class="fab fa-instagram"></i></a>
                <a href="#"><i class="fab fa-twitter"></i></a>
                <a href="#"><i class="fab fa-github"></i></a>
            </div>
        </div>
    </div>
</div>

