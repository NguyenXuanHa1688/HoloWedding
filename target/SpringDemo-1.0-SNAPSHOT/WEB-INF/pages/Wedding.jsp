<%-- 
    Document   : Wedding
    Created on : Apr 7, 2022, 4:03:50 PM
    Author     : billg
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script scr="<c:url value="/js/main.js"/>"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker();
        });
    </script>
    <style>
        hr {
            width: 60%;
            height: 2px;
            background-color: DeepSkyBlue;
        }
        #submit{
            background-color: DeepSkyBlue;
            color: white;
        }
        #cancel{
            background-color: orangered;
            color: white;
            margin-left: 10px;
        }
    </style>
</head>

<!--Adding-->

<br> <br> <br> <br> <br> <br>
<div class="w3-content w3-padding w3-card" style="max-width:500px">
    <div class="w3-container w3-padding-32">
        <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16"
            style="color: DeepSkyBlue;">Add Party</h3>
            <hr>
        <form method="post" action="" modelAttribute="wedding" enctype="multipart/form-data">
            <p>
                <label>wedding id</label>

                <input  class="w3-input w3-border fixedinput" type="text" id="" name="idWedding" >
            </p>
            <p>
                <label>wedding name</label>
                <input class="w3-input w3-border fixedinput" type="text" id="" name="name">
            </p>
            <p>
                <label>wedding Price</label>
                <input class="w3-input w3-border fixedinput" type="text" id="" name="price">
            </p>
            <p>
                <label>wedding detail</label>
                <input class="w3-input w3-border fixedinput" type="text" id="" name="detail">
            </p>
            <p>
                <label>wedding duration</label>
                <input class="w3-input w3-border fixedinput" type="text" id="" name="duration">
            </p>
            <p>
                <label>wedding Images</label>
                <input type="file" class="w3-input w3-border fixedinput" id="" name="file">
            </p>
            <div class="form-group">
                <label>Wedding start date</label>
                <input type="text" name="start_date" id="datepicker" value="">
            </div>
            <div class="w3-center">
                <button id="submit" type="submit" class="w3-button">SAVE</button>
                <a id="cancel" class="w3-button" href="/SpringDemo">CANCEL</a>
            </div>
        </form>
    </div>
</div>
<br> <br> <br>

