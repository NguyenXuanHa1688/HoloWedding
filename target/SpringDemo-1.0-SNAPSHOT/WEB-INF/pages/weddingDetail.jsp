<%-- 
    Document   : weddingDetail
    Created on : Apr 9, 2022, 12:09:06 AM
    Author     : billg
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <link href="<c:url value="/css/detailstyle.css" />" rel="stylesheet"/>
    <style>
        #desc-line{
            width: 100%;
            height: 1px;
            background-color: gray;
            justify-content: center;
        }
    </style>
</head>

<section class="container sproduct my-5 pt-5">
    <div class="container text-center mt-5 py-5">
        <H3>WEDDING PARTY</H3>
        <hr class="mx-auto">
        <p>Here you can check out our latest deals with good prices</p>
    </div>
    <div class="row">
        <div class="col-lg-5 col-md-12 col-12">
            <img class="img-fluid w-100 pd-1" src="${wedding.img}" id="MainImg" alt="">
            <div class="small-img-group">
                <div class="small-img-col">
                    <img src="${wedding.img}" width="100%" class="small-img" alt="">
                </div>
                <div class="small-img-col">
                    <img src="${wedding.img}" width="100%" class="small-img" alt="">
                </div>
                <div class="small-img-col">
                    <img src="${wedding.img}" width="100%" class="small-img" alt="">
                </div>
                <div class="small-img-col">
                    <img src="${wedding.img}" width="100%" class="small-img" alt="">
                </div>
            </div>
        </div>

        <div class="col-lg-5 col-md-12 col-12">
            <h2 id="product_name">${wedding.name}</h2>
            <h3>Price: <span style="color: red;"> $${wedding.price}</span></h3>
            <h3>People Booked: ${count}</h3>
            <form action="<c:url value="/book/${wedding.idWedding}"/>" method="GET">                               
                <button class="buy-btn">Add to cart</button>
                <input type="text" style="visibility: hidden" id="pname" name="pname" value="">
                <input type="text" style="visibility: hidden" id="price" name="price" value="">
            </form>
        </div>

        <hr id="desc-line">
        <div class="wed-info text-center">
            <h4 style="color:CornflowerBlue;">Description</h4>

            <span id="description">
                ${wedding.detail}
            </span>
        </div>
    </div>
</section>

<!--COMMENT SECTION-->
<div class="comment-body">
    <div class="container text-center mt-5 py-5">
        <H3 style="color:CornflowerBlue;" >Comments section</H3>
        <hr class="mx-auto">
        <p>We want to hear your thought!! Give us something feedback</p>
    </div>
    <div class="container mt-5">
        <div class="d-flex justify-content-center row">
            <div class="col-md-8">
                <div class="d-flex flex-column comment-section">
                    <c:forEach items="${comments}" var="c">
                        <div class="bg-white p-2">
                            <div class="d-flex flex-row user-info"><img class="rounded-circle" src="${c.username.avatar}" width="40">
                                <div class="d-flex flex-column justify-content-start ml-2"><span class="d-block font-weight-bold name">${c.username.username}</span><span class="date text-black-50">${c.dateCreate}</span></div>
                            </div>
                            <div class="comment-box mt-2">
                                <p class="comment-text">${c.content}</p>
                            </div>
                        </div>
                    </c:forEach>
                    <h3>${err}</h3>
                    <div class="bg-white">
                        <div class="d-flex flex-row fs-12">
                            <div class="like p-2 cursor"><i class="fa fa-thumbs-o-up"></i><span class="ml-1">Like</span></div>
                            <div class="like p-2 cursor"><i class="fa fa-commenting-o"></i><span class="ml-1">Comment</span></div>
                            <div class="like p-2 cursor"><i class="fa fa-share"></i><span class="ml-1">Share</span></div>
                        </div>
                    </div>
                    <form action="/SpringDemo/comment/${wedding.idWedding}" method="post" class="bg-light p-2" id = "comment">
                        <div class="d-flex flex-row align-items-start"><img class="rounded-circle" src="${c.username.avatar}" width="40"><textarea form="comment" name="content" class="form-control ml-1 shadow-none textarea"></textarea></div>
                        <div class="mt-2 text-right"><button class="btn btn-primary btn-sm shadow-none" type="submit">Post comment</button><button class="btn btn-outline-primary btn-sm ml-1 shadow-none" type="button">Cancel</button></div>
                    </form>
                </div>
            </div>
        </div>
    </div>


</div>


<!--RELATIVE PRODUCT-->
<section id="featured" class="my-5 pd-5">
    <div class="container text-center mt-5 py-5">
        <H3 style="color:CornflowerBlue;" >Relative Product</H3>
        <hr class="mx-auto">
        <p>If you like what above, check out these product too!!!</p>
    </div>
    <div class="row mx-auto container-fluid">
        <div class="product text-center col-lg-3 col-md-4 col-12">
            <img class="img-fluid mb-3" src="https://res.cloudinary.com/xha1688/image/upload/v1649687337/imgForWeb/e431469d0f4c8d1db6ae3e888647e94a_azhp40.png" alt="">
            <div class="star">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
            </div>
            <h5 class="p-name">Peko-Drink</h5>
            <h4 class="p-price">$500.0</h4>
            <button class="buy-btn">Buy now</button>
        </div>
        <div class="product text-center col-lg-3 col-md-4 col-12">
            <img class="img-fluid mb-3" src="https://res.cloudinary.com/xha1688/image/upload/v1649687337/imgForWeb/e431469d0f4c8d1db6ae3e888647e94a_azhp40.png"
                 alt="">
            <div class="star">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
            </div>
            <h5 class="p-name">Peko-Drink</h5>
            <h4 class="p-price">$500.0</h4>
            <button class="buy-btn">Buy now</button>
        </div>
        <div class="product text-center col-lg-3 col-md-4 col-12">
            <img class="img-fluid mb-3" src="https://res.cloudinary.com/xha1688/image/upload/v1649687337/imgForWeb/e431469d0f4c8d1db6ae3e888647e94a_azhp40.png" alt="">
            <div class="star">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
            </div>
            <h5 class="p-name">Peko-Drink</h5>
            <h4 class="p-price">$500.0</h4>
            <button class="buy-btn">Buy now</button>
        </div>
        <div class="product text-center col-lg-3 col-md-4 col-12">
            <img class="img-fluid mb-3" src="https://res.cloudinary.com/xha1688/image/upload/v1649687337/imgForWeb/e431469d0f4c8d1db6ae3e888647e94a_azhp40.png" alt="">
            <div class="star">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
            </div>
            <h5 class="p-name">Peko-Drink</h5>
            <h4 class="p-price">$500.0</h4>
            <button class="buy-btn">Buy now</button>
        </div>
    </div>
</section>

<script>
    var MainImg = document.getElementById('MainImg');
    var smallimg = document.getElementsByClassName('small-img');

    smallimg[0].onclick = function () {
        MainImg.scr = smallimg[0].scr;
    }

    smallimg[1].onClick = function () {
        MainImg.scr = smallimg[1].scr;
    }

    smallimg[2].onClick = function () {
        MainImg.scr = smallimg[2].scr;
    }

    smallimg[3].onClick = function () {
        MainImg.scr = smallimg[3].scr;
    }

</script>
