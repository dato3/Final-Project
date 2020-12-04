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
                        <li><a href="blog.do">BLOG</a></li>
                        <li><a href="about.html">ABOUT</a></li>
                        <li><a href="contact.html">CONTACT</a></li>
                    </nav>
                    <div class="searchBasket">
                        <div class="search">
                            <input type="text" class="search" placeholder="I'm looking for...">
                            <a class="btn-search" href="#">Search</a>
                        </div>
                        <a href="#" class="basket"><img src="assets/css/img/shopping-cart.png" alt=""> <p> $0.00</p></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="content">
            <div class="blogHeader">
                <p>Home</p>
            </div>
            <div class="blogContent">
                <img src="assets/css/img/news/1n.jpg" alt="">
                <h2>Proin gravida nibh vel velit auctor aiquet Aeneansoudin</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Dignissimos eos quae pariatur velit quod facere culpa, 
                    ad laborum esse quas quidem a atque porro alias dolorem itaque cum consectetur blanditiis voluptate autem incidunt. 
                    Nam asperiores nulla nesciunt ab voluptatum, possimus est deleniti. 
                    Dolorem laudantium non est, necessitatibus saepe quam nam quis iure accusamus temporibus aliquam, assumenda odit suscipit soluta eos veritatis cupiditate corrupti placeat. 
                    Expedita doloribus delectus ipsam dolore eius ex modi, illum magnam explicabo! 
                    Enim expedita iste deleniti aliquid voluptatibus modi, similique sequi? 
                    Dignissimos qui animi modi esse porro, quibusdam velit tenetur accusamus similique recusandae itaque necessitatibus possimus quas aspernatur vero pariatur reprehenderit voluptas enim culpa amet ad! 
                    Corrupti, eos atque nihil iusto illo at placeat numquam voluptatum dignissimos voluptas doloremque quos aliquid porro fugiat error laboriosam optio magni molestiae consectetur facilis ut!
                     Magni maiores corrupti praesentium a architecto eius suscipit aliquam aspernatur? 
                    Pariatur nobis nam nulla libero autem vitae eveniet tenetur. Aspernatur maxime corrupti iste, sit inventore eum incidunt. Eius rem pariatur sunt consequatur illum nesciunt accusamus? 
                    Sint architecto voluptates totam fugit debitis numquam consequatur, mollitia autem natus officiis quo voluptas, vel voluptatum. Ducimus delectus provident velit placeat maxime vitae! 
                    Sapiente aspernatur, molestiae eos suscipit culpa libero iusto?</p>
                    <p>18.11.2020 / by Daulet</p>
            </div>
            <div class="blogContent">
                <img src="assets/css/img/news/2n.jpg" alt="">
                <h2>Proin gravida nibh vel velit auctor aiquet Aeneansoudin</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Dignissimos eos quae pariatur velit quod facere culpa, 
                    ad laborum esse quas quidem a atque porro alias dolorem itaque cum consectetur blanditiis voluptate autem incidunt. 
                    Nam asperiores nulla nesciunt ab voluptatum, possimus est deleniti. 
                    Dolorem laudantium non est, necessitatibus saepe quam nam quis iure accusamus temporibus aliquam, assumenda odit suscipit soluta eos veritatis cupiditate corrupti placeat. 
                </p>
                <p>18.11.2020 / by Alisher</p>                
            </div>
            <div class="blogContent">
                <img src="assets/css/img/news/3n.jpg" alt="">
                <h2>Proin gravida nibh vel velit auctor aiquet Aeneansoudin</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Dignissimos eos quae pariatur velit quod facere culpa, 
                    ad laborum esse quas quidem a atque porro alias dolorem itaque cum consectetur blanditiis voluptate autem incidunt. 
                    Nam asperiores nulla nesciunt ab voluptatum, possimus est deleniti. 
                    Dolorem laudantium non est, necessitatibus saepe quam nam quis iure accusamus temporibus aliquam, assumenda odit suscipit soluta eos veritatis cupiditate corrupti placeat. 
                    Expedita doloribus delectus ipsam dolore eius ex modi, illum magnam explicabo! 
                    Enim expedita iste deleniti aliquid voluptatibus modi, similique sequi? 
                    Dignissimos qui animi modi esse porro, quibusdam velit tenetur accusamus similique recusandae itaque necessitatibus possimus quas aspernatur vero pariatur reprehenderit voluptas enim culpa amet ad! 
                </p>
                <p>18.11.2020 / by Alisher</p>
            </div>
        </div>
        <div class="footer">
            <div class="footerNav">
                <h2>Navigation</h2>
                <nav>
                    <li><a href="main.do">HOME</a></li>
                    <li><a href="blog.do">BLOG</a></li>
                    <li><a href="#">ABOUT</a></li>
                    <li><a href="#">CONTACT</a></li>
                </nav>
            </div>
            <div class="footerContact">
                <h2>CONTAC INFO</h2>
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
</body>
</html>