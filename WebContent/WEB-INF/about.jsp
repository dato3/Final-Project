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
                <p>about our pharmacy</p>
            </div>
            <div class="about-us">
                <div class="about-info">
                    <h3>Our mission</h3>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Libero, repudiandae aliquid! Odit itaque illo laudantium iusto aliquid qui quasi dolorum.</p>
                </div>
                <div class="about-info">
                    <h3>Our essence</h3>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Libero, repudiandae aliquid! Odit itaque illo laudantium iusto aliquid qui quasi dolorum.</p>
                </div>
                <div class="about-info">
                    <h3>Our promise</h3>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Libero, repudiandae aliquid! Odit itaque illo laudantium iusto aliquid qui quasi dolorum.</p>
                </div>
                <div class="about-info">
                    <h3>Our vibe</h3>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Libero, repudiandae aliquid! Odit itaque illo laudantium iusto aliquid qui quasi dolorum.</p>
                </div>
            </div>
            <div class="about-us">
                <div class="about-info">
                    <img src="assets/css/img/logo.png" alt="">
                    <h3>About Company</h3>
                </div>
                <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Molestias tempora ratione voluptatum, amet vero veniam quasi soluta consequuntur ullam numquam labore natus fugiat enim iusto cupiditate nisi maiores consectetur. Cupiditate unde soluta deleniti eius eum quasi consequuntur quibusdam natus? Exercitationem placeat quibusdam obcaecati at praesentium officiis quisquam eaque nulla possimus autem impedit iure, eos vitae ut! Cumque dicta qui laboriosam, facilis laborum ipsam exercitationem facere sequi labore assumenda necessitatibus ab fugiat officiis similique quisquam illum. Exercitationem, voluptate! Nostrum magnam eos, quia ipsa laborum eligendi recusandae inventore similique accusantium ut placeat atque sequi laudantium labore facilis ab dolorum, aut porro maxime et optio voluptas delectus quaerat aliquam. Nam et fugiat odit quae eius amet veniam dicta quam dolorem, deleniti quas reprehenderit facilis ab consequatur vel vero adipisci cumque nihil mollitia deserunt tenetur temporibus aperiam corporis explicabo. Praesentium excepturi facere voluptatibus, doloremque adipisci atque sit, rerum error consequatur earum expedita accusantium saepe ab quam totam. Commodi quis quasi inventore praesentium aliquam ratione eum! Commodi, porro quisquam. Accusantium natus tenetur vitae earum beatae minima perferendis provident nostrum itaque adipisci, praesentium consequuntur cupiditate tempore facilis ullam ab velit eveniet facere magnam, officia eaque. Neque, tempora qui aliquid natus, debitis repellendus quia soluta ullam consectetur mollitia quod accusamus quaerat veniam quae saepe asperiores, odit aspernatur iste iusto? Eligendi reiciendis quibusdam nostrum, nihil laboriosam accusamus odit praesentium quo quidem deleniti dolores dolor molestias ipsam optio, repellendus id facilis assumenda perspiciatis ducimus maiores beatae quia perferendis repudiandae tenetur! Exercitationem, officiis quaerat. Tempore magnam voluptatibus perferendis nemo incidunt non reiciendis voluptas veniam ea dolores debitis repellat earum numquam tempora, aut sint aspernatur nisi nihil nostrum. Accusamus hic consequatur minus nesciunt at porro laboriosam quos, accusantium fuga repudiandae autem, amet adipisci! Est aliquid maiores, incidunt cumque, repellendus quod consequuntur ab odio delectus rerum ad nam libero harum velit molestias.</p>
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
    <script src="assets/js/products.js"></script>
</body>
</html>