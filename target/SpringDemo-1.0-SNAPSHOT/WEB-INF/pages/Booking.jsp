<%-- 
    Document   : Booking
    Created on : Apr 10, 2022, 8:00:43 PM
    Author     : billg
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <link href="<c:url value="/css/bookstyle.css"/>" rel="stylesheet"/>
    <style>
        .details{
            font-size: 28px;
        }
        #totalPrice{
            font-size: 24px;
        }
    </style>
</head>

<br>
<br>
<br>
<br>
<br>

<!-- FEATURED SECTION -->
<div class="b-container">
    <div class="a-container">
        <div class="title">Booking</div>
        <div class="content">
            <form method = "post" action = "/SpringDemo/book/${wedding.idWedding}">
                <div class="wed-detail">
                    <div class="wed-img">
                        <img src="${wedding.img}" alt="test" />
                    </div>
                    <div class="wed-info">
                        <h2>${wedding.name}</h2>
                        <p>Start date : ${wedding.startDate}</p>
                        <p> <p>Price : ${wedding.price}</p></p>
                        <p id = "price" hidden="true">${wedding.price}</p>
                    </div>
                </div>
                <div class="gender-details">
                    <input onclick ="changeTotalPrice(this)" value="100" type="radio" name="gender" id="dot-1">
                    <input onclick ="changeTotalPrice(this)" value="200" type="radio" name="gender" id="dot-2">
                    <input onclick ="changeTotalPrice(this)" value="300" type="radio" name="gender" id="dot-3">
                    <span class="gender-title">Service</span>
                    <div class="category">
                        <label for="dot-1">
                            <span class="dot one"></span>
                            <span class="gender">10 Table ($100)</span>
                        </label>
                        <label for="dot-2">
                            <span class="dot two"></span>
                            <span class="gender">15 Table + Wedding Cake ($200)</span>
                        </label>
                        <label for="dot-3">
                            <span class="dot three"></span>
                            <span class="gender">20 Table + Wedding Cake + Musician Band ($300)</span>
                        </label>
                    </div>
                </div>
                <div class="user-details">
                    <div class="input-box">
                        <span class="details">Total Price</span>
                        <p id="totalPrice">$${wedding.price}</p>
                    </div>
                </div>

                <input hidden value = "${wedding.price}" name="totalPrice" id="total"/>

                <div class="button">
                    <input type="submit" value="Confirm">
                </div>
            </form>
        </div>
    </div>        
</div>

<script>
    var price = parseInt(document.getElementById("price").innerHTML.trim());
    function changeTotalPrice(service) {
        var total = document.getElementById("total");
        var totalPrice = document.getElementById("totalPrice");
        total.value = price + parseInt(service.value);
        totalPrice.innerHTML = "$" + total.value + ".00";
    }
</script>




