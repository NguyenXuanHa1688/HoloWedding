<%-- 
    Document   : empManager
    Created on : Apr 13, 2022, 9:19:55 PM
    Author     : billg
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <link href="<c:url value="/css/userlist.css"/>" rel="stylesheet"/>
</head>
<br>
<br>
<br>
<br>

<h2>USER LIST</h2>
<div class="table-box">

    <div class="table-row table-head">
        <div class="table-cell">
            <p>ID</p>
        </div>
        <div class="table-cell">
            <p>NAME</p>
        </div>
        <div class="table-cell">
            <p>ROLE</p>
        </div>
        <div class="table-cell">
            <p>OPTIONS</p>
        </div>
    </div>
    <c:forEach items="${users}" var = "u" varStatus="loop">
        <div class="table-row">
            <div class="table-cell">
                <p>${loop.index + 1}</p>
            </div>
            <div class="table-cell">
                <p>${u.username}</p>
            </div>
            <div class="table-cell">
                <p>${u.role}</p>
            </div>
            <div class="table-cell">
                <a href="/SpringDemo/admin/deleteEmp/${u.username}" class="btn" style="background-color: red">DELETE</a>
            </div>
        </div>
    </c:forEach>

</div>

<div class="bg-modal">
    <div class="modal-content">
        <div onclick="closeEdit()" class="close">+</div>
        <img src="<c:url value="/img/default.jpg"/>" alt="test" />
        <form:form method="post" action="/SpringDemo/admin/addEmp" class="edit-form" modelAttribute="user" enctype="multipart/form-data">

            <form:input path="username" class="input" value="" placeholder="Enter your name" />

            <form:input type="text" path="role" value="" placeholder="Enter your role"/>

            <form:password path="password" value = "" placeholder="Enter password" />



            <form:input type="file" path="file" placeholder="Enter your avatar" />
            <button class="change-btn">Add</button>
        </form:form>
    </div>
</div>


<div>
    <button class="add-btn" onclick="openEdit()">Add</button>
</div>

<script>
    function openEdit() {
        document.querySelector('.bg-modal').style.display = 'flex';
    }
    function closeEdit() {
        document.querySelector('.bg-modal').style.display = 'none';
    }
</script>