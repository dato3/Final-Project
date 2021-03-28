<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pharmacy</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/normalize.css">
    <link rel="stylesheet" href="assets/css/product.css">
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
        </div>
        <div class="content">
            <div class="blogHeader">
                <p>Medicine Info</p>
            </div>
            <div class="product-content">
                <div class="product-header">
                    <img src="${medicine.image}" alt="">
                    <div class="product-info">
                        <h2>${medicine.medicineName}</h2>
                        <p><strong>Barcode: </strong>${medicine.barcode}</p>
                        <p><strong>Vendor Code: </strong>${medicine.vendorCode}</p>
                        <p><strong>Price(for 1 pcs): </strong>${medicine.price} KZT</p>
                        <p><strong>In Stock: </strong>${medicine.availability} pcs</p>
                        <p><strong>Quantity: </strong><input type="number" id="quantity" value="1" min="1" max="${medicine.availability}"></p>
                        <c:if test="${medicine.availability == 0}">
                        	<button class="product-btn" style="background: red;cursor: default" disabled>Not Available</button> 
                        </c:if>
                        <c:if test="${medicine.availability != 0}">
                        	<form action="addtocart.do" method="POST">
                        		<input type="hidden" name="medicineName" value="${medicine.medicineName}">
                        		<input type="hidden" name="image" value="${medicine.image}">
                        		<input type="hidden" name="price" value="${medicine.price}">
                        		<input type="hidden" name="vendorCode" value="${medicine.vendorCode}">
                        		<input type="hidden" name="barcode" value="${medicine.barcode}">
                        		<input type="hidden" name="availability" value="${medicine.availability}">
                        		<input type="hidden" id="quan" name="quantity" value="">
                        		<c:if test="${sessionScope.user == null}">
                        			<button type="submit" class="product-btn">Add to cart</button>
                        		</c:if>
                        		<c:if test="${sessionScope.user != null}">
                        			<button type="submit" class="product-btn" onclick="myFunction()">Add to cart</button>
                        		</c:if>                  	                        	
                        		<script>
									function myFunction() {
										var temp = document.getElementById("quantity").value;
	                        			document.getElementById("quan").value = temp;
									 	alert("Medicine added to your cart successfully !");
									}
								</script>
                        	</form>
                        </c:if>
                    </div>
                    
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
                <h2>CONTAC INFO</h2>
                <p>Address: Almaty, Abay 12/1</p>
                <p>Working hours: 8AM - 10PM</p>
                <p>Working days: Monday - Saturday</p>
                <p>Phone: +7(000)000 00 00</p>
                <p>Email: support@company.com</p>
            </div>
        </div>
        <div class="copyright">
            <p>&copy; Copyright 2020 - PharmaDAD</p>
        </div>
    </div>
    <script src="assets/js/products.js"></script>
</body>
</html>