<%-- 
    Document   : header
    Created on : Apr 15, 2022, 9:40:40 AM
    Author     : billg
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light py-3 fixed-top">
    <div class="container">
        <img src="https://res.cloudinary.com/xha1688/image/upload/v1649698291/imgForWeb/Webp.net-resizeimage_ybdbpk.png" alt="">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span><i id="bar" class="fas fa-bars"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/SpringDemo/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/SpringDemo/product">Parties</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Others
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="https://en.hololive.tv/goods">Real Shop</a></li>
                        <li><a class="dropdown-item" href="/SpringDemo/about">About</a></li>
                        <c:if test = "${user.role == 'Admin'}">
                            <li><a class="dropdown-item" href="/SpringDemo/chartBooking">report</a></li>
                            <li><a class="dropdown-item" href="/SpringDemo/admin/manager">User list</a></li>
                        </c:if>
                    </ul>
                </li>
                <c:if test = "${not empty user.username}">
                    <li class="nav-item">
                        <a class="nav-link" href="/SpringDemo/profile">${user.username}</a>
                    </li>
                    <li class="nav-item">
                        <a class="fas fa-shipping-fast" style="color: inherit" href=""></a>
                    </li>
                </c:if>
                <c:if test = "${empty user.username}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Guest</a>
                    </li>
                </c:if>


                <c:if test = "${empty user.username}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/login"/>">Login</a>
                    </li>
                </c:if>
                <c:if test = "${not empty user.username}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/logout"/>">Logout</a>
                    </li>
                </c:if>

            </ul>
            <form class="d-flex" method="get" action="<c:url value="/search"/>">
            <input class="form-control me-2" id="search" name="sname" type="search" placeholder="Search"
                   aria-label="Search">
            <button class="btn btn-outline-success" id="searchBtn" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>