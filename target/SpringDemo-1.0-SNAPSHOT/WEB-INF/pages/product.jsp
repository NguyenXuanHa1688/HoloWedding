<%-- 
    Document   : product
    Created on : Apr 11, 2022, 11:05:53 PM
    Author     : billg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <style>
            #featured img {
                width: 80%;
                height: auto;
                box-sizing: border-box;
                object-fit: cover;
            }

            .filter-condition{
                padding: 20px;
                height: 100px;
                font-size: 20px;
                font-weight: bold;
            }
        </style>
    </head>
    <!--PRODUCT SECTION-->
    <section id="featured" class="my-5 py-5 container">
        <div class="product-field">
            <div class="container mt-5 py-5">
                <h2 class="font-weight-bold">OUR AVAIBLE PRODUCT</h2>
                <hr>
                <p>Here you can check out our latest product with good prices</p>
                <div class="filter-condition">
                    <span>Sort as:</span>
                    <select onchange="changeFunc(value);" id="select" name="">
                        <option value="HighestPrice">Default</option>
                        <option value="HighestPrice">Highest Price</option>
                        <option value="LowestPrice">Lowest Price</option>
                    </select>
                </div>
                <!--If admin-->
                <c:if test = "${user.role == 'Admin'}">
                    <div class="w3-padding">
                        <a class="w3-button w3-green w3-right" title="Add Product" href="/SpringDemo/admin/wedding-add">+</a>
                    </div>
                </c:if>
            </div>

            <div class="row mx-auto container-fluid">
                <c:forEach items="${weddings}" var = "w">
                    <div class="product text-center col-lg-3 col-md-4 col-12">
                        <img class="img-fluid mb-3" src="<c:url value="${w.img}" />" alt="">
                        <div class="star">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                        </div>
                        <h5 class="p-name">${w.name}</h5>
                        <h4 class="p-price">$${w.price}</h4>
                        <form action="<c:url value="/weddings/${w.idWedding}"/>" method="POST">
                            <c:if test = "${user.role != 'Admin'}">
                                <input type="text" style="display: none;" >
                                <button class="buy-btn">Book now</button>
                            </c:if>                                  
                        </form>

                        <c:if test = "${user.role == 'Admin'}">
                            <form action="<c:url value="/admin/upWed/${w.idWedding}"/>" method="">                                       
                                <input type="text" style="display: none;" >
                                <a href="<c:url value="/admin/upWed/${w.idWedding}"/>" >
                                    <button class="buy-btn" >Update</button>
                                </a>
                            </form> 
                            <br>   
                            <form action="<c:url value="/admin/delete/${w.idWedding}"/>" method="">    
                                <input type="text" style="display: none;" >
                                <a href="<c:url value="/admin/delete/${w.idWedding}"/>" >
                                    <button class="buy-btn" style="background-color:indianred;">Delete</button>
                                </a>                           
                            </form>
                        </c:if>
                    </div>
                </c:forEach>
            </div>

        </div>
        <ul class="pagination">
            <c:forEach begin="1" end="${Math.ceil(wedCounter/8)}" var="i">
                <li class="page-item"><a class="page-link" href="/SpringDemo/product/?page=${i}">${i}</a></li>
                </c:forEach>
        </ul>
    </section>
    <script>
        function changeFunc(i) {
            console.log(i);
            if(i== "HighestPrice"){
                window.location.href = "http://localhost:8080/SpringDemo/descsort";
            }
            else if(i == "LowestPrice"){
                window.location.href = "http://localhost:8080/SpringDemo/ascsort";
            }
            else if(i == "Default"){
                window.location.href = "http://localhost:8080/SpringDemo/product";
            }
        }   
    </script>





























