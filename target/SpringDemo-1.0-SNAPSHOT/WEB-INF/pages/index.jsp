<%-- 
    Document   : Index
    Created on : Mar 20, 2022, 9:20:10 PM
    Author     : billg
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<section id="home">
    <div class="container">
        <h5 id="new-title">NEW</h5>
        <h1><span>BEST PRICE</span> This Year</h1>
        <form action="/SpringDemo/product" method="get">
            <button>Shop Now</button>
        </form>

    </div>
</section>

<!-- BRAND SECTION -->

<!-- PREVIEW SECTION -->
<section id="preview" class="w-100">
    <div class="row p-0 m-0 ">
        <div class="one col-lg-4 col-md-12 col-12 p-0">
            <img class="img-fluid" src="<c:url value="https://res.cloudinary.com/xha1688/image/upload/v1649686062/imgForWeb/animesher.com_your-lie-in-april-anime-wedding-anime-bride-1229546_wptaiv.jpg" />" alt="">
            <div class="details">
                <h2>YOUR DREAM IS HERE</h2>
                <form action="/SpringDemo/product" method="get">
                    <input class="form-control me-2" style="display: none;" id="search" name="sname" type="text"
                           placeholder="Search" aria-label="Search" value="Pekora">
                    <button class="text-uppercase">Book now</button>
                </form>

            </div>
        </div>
        <div class="one col-lg-4 col-md-12 col-12 p-0">
            <img class="img-fluid" src="<c:url value="https://res.cloudinary.com/xha1688/image/upload/v1649687077/imgForWeb/__minato_aqua_hololive_drawn_by_mikanagi_yuri__eb6ed33e01d44f062b66fd39697dac8e_zxh2h3.jpg"/>" alt="">
            <div class="details">
                <h2>BEST PRICE FOR YOU</h2>
                <form action="/SpringDemo/product" method="get">
                    <input class="form-control me-2" style="display: none;" id="search" name="sname" type="text"
                           placeholder="Search" aria-label="Search" value="Fubuki">
                    <button class="text-uppercase">Book now</button>
                </form>
            </div>
        </div>
        <div class="one col-lg-4 col-md-12 col-12 p-0">
            <img class="img-fluid" src="<c:url value="https://res.cloudinary.com/xha1688/image/upload/v1649687337/imgForWeb/e431469d0f4c8d1db6ae3e888647e94a_azhp40.png" />" alt="">
            <div class="details">
                <h2>DON'T MISS IT!!!!</h2>
                <form action="/SpringDemo/product" method="get">
                    <input class="form-control me-2" style="display: none;" id="search" name="sname" type="text"
                           placeholder="Search" aria-label="Search" value="suisei">
                    <button class="text-uppercase">Book now</button>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- FEATURED SECTION -->
<c:if test = "${user.role != 'Admin'}">
<section id="featured" class="my-5 pd-5" >
    <div class="container text-center mt-5 py-5">
        <H3>OUR FEATURED</H3>
        <hr class="mx-auto">
        <p>Here you can check out our latest deals with good prices</p>
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
                    <input type="text" style="display: none;" >
                    <button class="buy-btn">Book now</button>
                </form>
            </div>
        </c:forEach>
    </div>

</section>
</c:if>

<!--MID SECTION-->
<section id="banner" class="my-5 py-5">
    <div class="container">
        <h4>SUPER SALE</h4>
        <h1>Special Collection<br>One time only</h1>
        <form action="/SpringDemo/product" method="get">
            <button>Shop Now</button>
        </form>
    </div>
</section>