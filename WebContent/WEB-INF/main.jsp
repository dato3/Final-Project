<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pharmacy</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/normalize.css">
    <link rel="shortcut icon" type="image/png" href="pharmacy.png">
</head>
<body>
    <div class="wrapper">
        <div class="header">
        	<c:if test="${sessionScope.user == null}">
	            <form class="elementor-wget" action="login.do" method="GET">
	                <button type="submit"><img src="assets/css/img/user.png" alt=""> Login / Register</button>
	            </form>            	
            </c:if>
            <c:if test="${sessionScope.user != null}">
            	<form class="elementor-wget2V" action="logout.do" method="POST">
            		<p>Currently logged in as <span style="color: green">${user.firstName} ${user.lastName}</span></p>
	                <button type="submit"><img src="assets/css/img/user.png" alt=""> Logout</button>
	            </form> 
            </c:if>
            <div class="header-sidebar">
                <img src="assets/css/img/logo.png" alt="" class="logo">
                <div class="sidebar">
                    <nav class="navbar">
                        <li><a href="main.do">HOME</a></li>
                        <li><a href="blog.do">NEWS</a></li>
                        <li><a href="about.do">ABOUT</a></li>
                        <li><a href="contact.do">CONTACT</a></li>
                    </nav>
                    <div class="searchBasket">
                        <form class="search" action="search.do" method="POST">
	                        <input type="hidden" name="currentPage" value="1">
	                        <input type="text" class="search" name="inputText" placeholder="I'm looking for...">
                        	<button type="submit" class="btn-search">Search</button>
                        </form>
                        <c:if test="${totalPrice == null}">
	                        <a href="basket.do" class="basket"><img src="assets/css/img/shopping-cart.png" alt=""> <p>0 KZT</p></a>                        	
                        </c:if>
                        <c:if test="${totalPrice != null}">
                       		<a href="basket.do" class="basket"><img src="assets/css/img/shopping-cart.png" alt=""> <p>${totalPrice} KZT</p></a>                        	
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="slider">
                <h1>healthy life recipe</h1>
                <form action="shop.do" method="POST">
                	<input type="hidden" name="currentPage" value="1">
                	<button type="submit" class="innerAtag">Shop now</button>
                </form>
            </div>
        </div>
        <div class="content">
            <div class="productsHeader">
                <p>Recent products</p>
            </div>
            <div class="recentProducts">
            	<c:forEach var="medicine" items="${recentMedicines}">
            		<a href="medicine.do?medicineName=${medicine.medicineName}" class="product">
            			<div class="imgProduct">
	                        <img src="${medicine.image}" alt="">
	                    </div>
	                    <div class="textProduct">
	                        <p class="nameProduct">${medicine.medicineName}</p>
	                        <p class="costProduct">${medicine.price} KZT</p>
	                    </div>
            		</a>
            	</c:forEach>
            </div>
            <div class="productsHeader">
                <p>Featured products</p>
            </div>
            <div class="recentProducts">
            	<c:forEach var="medicine" items="${featuredMedicines}">
            		<a href="medicine.do?medicineName=${medicine.medicineName}" class="product">
	                    <div class="imgProduct">
	                        <img src="${medicine.image}" alt="">
	                    </div>
	                    <div class="textProduct">
	                        <p class="nameProduct">${medicine.medicineName}</p>
	                        <p class="costProduct">${medicine.price} KZT</p>
	                    </div>
	                </a>
            	</c:forEach>
            </div>
            <div class="imgContact">
                <img src="assets/css/img/Screenshot from 2020-12-02 13-15-30.png" alt="">
            </div>
            <div class="newsMore">
                <div class="newsHeader">
                    <p>News</p>
                </div>
                <div class="newsBlog">
                	<c:forEach var="news" items="${news}">
                		<div class="newsRead">
	                        <div class="newsText">
	                            <p>${news.header}</p>
	                            <a href="blog.do"><p>Read more</p></a>
	                        </div>
	                    </div>
                	</c:forEach>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="footerNav">
                <h2>Navigation</h2>
                <nav>
                    <li><a href="main.do">HOME</a></li>
                    <li><a href="blog.do">NEWS</a></li>
                    <li><a href="about.do">ABOUT</a></li>
                    <li><a href="contact.do">CONTACT</a></li>
                </nav>
            </div>
            <div class="footerContact">
                <h2>CONTACT INFO</h2>
                <p>Add: No 1104 Super Sky Tower, Los Angeles</p>
                <p>Openning time: 8am to 10pm from Monday to Saturday</p>
                <p>+7(000)000 00 00</p>
                <p>support@company.com</p>
            </div>
        </div>
        <div class="copyright">
            <p>&copy; Copyright 2020</p>
        </div>
    </div>
</body>
</html>