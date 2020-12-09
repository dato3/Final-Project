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
        </div>
        <div class="contentBasket">
            <div class="basketHeader">
                <h2>Your Basket</h2>
            </div>
            <form class="purchaseInBasket">
                <div class="listProduct">

                    <div class="shopping-cart">

                        <div class="column-labels">
                            <label class="product-image">Image</label>
                            <label class="product-details">Product</label>
                            <label class="product-price">Price</label>
                            <label class="product-quantity">Quantity</label>
                            <label class="product-removal">Remove</label>
                            <label class="product-line-price">Total</label>
                        </div>
						<c:forEach var="cart" items="${cartData}">
							<div class="product-inner">
	                            <div class="product-image">
	                                <img src="${cart.image}">
	                            </div>
	                            <div class="product-details">
	                                <div class="product-title">${cart.medicineName}</div>
	                                <p class="product-description"><strong>Vendor Code: </strong>${cart.vendorCode}</p>
	                                <p class="product-description"><strong>Barcode: </strong>${cart.barcode}</p>
	                            </div>
	                            <div class="product-price">${cart.price} KZT</div>
	                            <div class="product-quantity">
	                                <p>${cart.quantity}</p>
	                            </div>
	                            <div class="product-removal">
	                                <form action="remove.do" method="POST">
	                                	<input type="hidden" name="medicineName" value="${cart.medicineName}">
		                                <button type="submit" class="remove-product">Remove</button>                                
	                                </form>
	                            </div>
	                            <div class="product-line-price">${cart.quantity * cart.price} KZT</div>
	                        </div>
						</c:forEach>
                        <div class="user-info">
                            <h2 class="user-header">Write your details</h2>
                            <div class="user-inner">
                                <p>Your name:</p>
                                <input type="text" id="userName" value="${user.firstName} ${user.lastName}">
                            </div>
                            <div class="user-inner">
                                <p>Your Email Address:</p>
                                <input type="text" id="emailAddr" value="${user.userName}">
                            </div>
                            <div class="user-inner">
                                <p>Your address:</p>
                                <input type="text" id="addr" placeholder="Almaty, Abay 12/1">
                            </div>
                            <div class="user-inner">
                                <p>Your phone number:</p>
                                <input type="phone" id="phone" placeholder="+7(707)777-77-77">
                            </div>
                            <div class="user-inner">
                                <p>Bankcard number:</p>
                                <input type="phone" id="bank" placeholder="4257 7285 2918 2914">
                            </div>
                            <div class="user-inner">
                                <p>CVV:</p>
                                <input type="password" placeholder="829">
                            </div>
                        </div>
                        <div class="totals">
                            <div class="totals-item">
                                <label>Subtotal</label>
                                <div class="totals-value" id="cart-subtotal">${totalPrice} KZT</div>
                            </div>
                            <div class="totals-item">
                                <label>Tax (5%)</label>
                                <div class="totals-value" id="cart-tax">${totalPrice * 0.05} KZT</div>
                            </div>
                            <c:if test="${totalPrice == 0}">
                            	<div class="totals-item">
	                                <label>Shipping</label>
	                                <div class="totals-value" id="cart-shipping">0 KZT</div>
	                            </div>
	                            <div class="totals-item totals-item-total">
	                                <label>Grand Total</label>
	                                <div class="totals-value" id="cart-total">0 KZT</div>
	                            </div>
                            </c:if>
                            <c:if test="${totalPrice > 0}">
                            	<div class="totals-item">
	                                <label>Shipping</label>
	                                <div class="totals-value" id="cart-shipping">1000 KZT</div>
	                            </div>
	                            <div class="totals-item totals-item-total">
	                                <label>Grand Total</label>
	                                <div class="totals-value" id="cart-total">${totalPrice + totalPrice*0.05 + 1000} KZT</div>
	                            </div>
                            </c:if>
                        </div>
						<form action="buy.do" method="POST">
							<input type="hidden" name="userName" id="rusrname" value="">
							<input type="hidden" name="emailaddress" id="emaddr" value="">
							<input type="hidden" name="address" id="raddr" value="">
							<input type="hidden" name="phoneNumber" id="phonenum" value="">
							<input type="hidden" name="bankNumber" id="banknum" value="">
							<input type="hidden" name="grandTotal" value="${totalPrice + totalPrice*0.05 + 1000}">
	                        <button type="submit" class="checkout" onclick="myFunction()">BUY</button>					
						</form>
						<script>
									function myFunction() {
	                        			document.getElementById("rusrname").value = document.getElementById("userName").value;
	                        			document.getElementById("emaddr").value = document.getElementById("emailAddr").value;
	                        			document.getElementById("raddr").value = document.getElementById("addr").value;
	                        			document.getElementById("phonenum").value = document.getElementById("phone").value;
	                        			document.getElementById("banknum").value = document.getElementById("bank").value;
									 	alert("Your purchase was successful !");
									}
						</script>
                    </div>
                </div>
            </form>
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
            <p>&copy; Copyright 2020 - Java EE Team</p>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="assets/js/basket.js"></script>
</body>
</html>