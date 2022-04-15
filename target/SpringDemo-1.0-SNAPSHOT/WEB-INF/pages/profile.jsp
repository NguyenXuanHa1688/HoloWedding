<%-- 
    Document   : profile
    Created on : Apr 12, 2022, 3:15:55 PM
    Author     : billg
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <link href="<c:url value="/css/profilestyle.css"/>" rel="stylesheet"/>
</head>

<body1>
    <!--USER SECTION-->
    <div class="container1">
        <div class="leftbox">
            <nav1>
                <a1 onclick="tabs(0)" class="tab" active>
                    <i class="fa fa-user"></i>
                </a1>
                <a1 onclick="tabs(1)" class="tab">
                    <i class="fa fa-credit-card"></i>
                </a1>
                <a1 onclick="tabs(2)" class="tab">
                    <i class="fa fa-tv"></i>
                </a1>
                <a1 onclick="tabs(3)" class="tab">
                    <i class="fa fa-tasks"></i>
                </a1>
                <a1 onclick="tabs(4)" class="tab">
                    <i class="fa fa-cog"></i>
                </a1>
            </nav1>
        </div>
        <div class="rightbox">
            <form:form method="post" action="/SpringDemo/profile/updateprofile" class="profile tabShow" modelAttribute="user" enctype="multipart/form-data">
                <h1>Personal info</h1>
                <h2>Username</h2>
                <form:input path="username" class="input" disabled= "true" value="${user.username}" placeholder="Enter your name" />
                <c:if test = "${user.role == 'Admin'}">
                    <h2>Role</h2>
                    <input type="text" name="gender" class="input" value="${user.role}">
                </c:if>
                <h2>Password</h2>
                <form:password path="password" class="input" value = "${user.password}" placeholder="Update password" />

                <button class="btn1">Update</button>

                <%--<form:input type="file" path="file" class="form-control" placeholder="Enter your avatar" />--%>

            </form:form>


            <div class="payment tabShow">

                <h1>Payment info</h1>
                <h2>Payment</h2>
                <input type="text" disabled="true" class="input" value="Paypal">
                <h2>Billing Adress</h2>
                <input name="adress" type="text" class="input" disabled="true" value="Custmoer Address">
                <h2>Zipcode</h2>
                <input name="zipcode" type="number"disabled="true" class="input" value="94043">
                <h2>Phone</h2>
                <input name="phone" type="text" disabled="true" class="input" value="Customer Phone">
                <h2>Redeem Card</h2>
                <input name="redeem_card" disabled="true" type="number" class="input" value="6548546321">

            </div>

            <form:form method="post" action="/SpringDemo/up_avatar" modelAttribute="user" class="avatar tabShow" enctype="multipart/form-data">

                <h2>Avatar</h2>
                <img src="${user.avatar}" alt="" srcset="" width="300" height="300">
                <form:input path="username" style= "" class="input" disabled= "true" value="${user.username}" placeholder="Enter your name" />
                <form:input type="file" path="file" class="input" placeholder="Enter your avatar" />
                <button class="btn1">Update</button>
            </form:form>

            <div class="history tabShow">
                <table class="content-table">
                    <colgroup>
                        <col span="1" style="width: 50%;">
                        <col span="1" style="width: 50%;">
                    </colgroup>
                    <thead>
                        <tr>
                            <th>Wedding Name</th>
                            <th>Total Price</th>
                        </tr>
                    </thead>

                    <tbody>
                        <!-- Bullshit, no need -->
                        <c:forEach items="${bookings}" var = "b">
                            <tr>
                                <td>${b.idWedding.name}</td>
                                <td> ${b.totalPrice} </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="coupon tabShow">
                <div class="container">
                    <h1>Coupon</h1>
                    <div class="list-group">
                        in development
                        <p class="list-group-item" id="coupon"> </p>                         
                        
                    </div>
                    <button class="btn1" onclick="get_coupon_btn()">Get Coupon</button>
                </div>
            </div>

        </div>
    </div>

    <br>
    <br>
    <br>
    <br>

    <script>
        const tabBtn = document.querySelectorAll(".tab")
        const tab = document.querySelectorAll(".tabShow")

        function tabs(panelIndex) {
            tab.forEach(function (node) {
                node.style.display = "none";
            });
            tab[panelIndex].style.display = "block";
        }
        tabs(0);
    </script>

    <script>
        $(".tab").click(function () {
            $(this).addClass("active").siblings().removeClass("active")
        })
    </script>

</body1>


