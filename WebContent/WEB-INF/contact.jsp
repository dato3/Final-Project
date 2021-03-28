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
            <div class="productsHeader">
                <p>Contacts</p>
            </div>
            <div class="contact">
                <div class="contact-card">
                    <h3>PHARMACY 01</h3>
                    <p><strong>Address:</strong> Almaty, Abay 12/1</p>
                    <p><strong>Openning time:</strong> 8AM-10PM</p>
                    <p><strong>Phone:</strong> +7(700)000 00 00</p>
                    <p><strong>Email:</strong> pharmacy@company.com</p>
                    <div class="network">
                        <a href="#"><img src="assets/css/img/whatsapp.png" alt=""></a>
                        <a href="#"><img src="assets/css/img/telegram.png" alt=""></a>
                        <a href="#"><img src="assets/css/img/facebook.png" alt=""></a>
                    </div>
                </div>
                <div class="contact-card">
                    <h3>Help & Support</h3>
                    <p>
                        If you have problems with the site or ordering method, please contact us. We are happy to help you!</p>
                    <p><strong>Working house:</strong> 10AM-8PM</p>
                    <p><strong>Phone:</strong> +7(700)000 00 00</p>
                    <p><strong>Email:</strong> support@company.com</p>
                </div>
                <div class="contact-card">
                    <h3>PHARMACY 02</h3>
                    <p><strong>Address:</strong> Almaty, Abay 12/1</p>
                    <p><strong>Openning time:</strong> 8AM-10PM</p>
                    <p><strong>Phone:</strong> +7(700)000 00 00</p>
                    <p><strong>Email:</strong> pharmacy@company.com</p>
                    <div class="network">
                        <a href="#"><img src="assets/css/img/whatsapp.png" alt=""></a>
                        <a href="#"><img src="assets/css/img/telegram.png" alt=""></a>
                        <a href="#"><img src="assets/css/img/facebook.png" alt=""></a>
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
                <h2>CONTACT INFO</h2>
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