<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="assets/css/loginLogout.css">
    <link rel="shortcut icon" type="image/png" href="pharmacy.png">
</head>
<body>
    <div class="login-page">
        <div class="form">
            <img class="logo" src="assets/css/img/logo.png" alt="">
            <c:forEach var="error" items="${form.formErrors}">
				<h3 style="color:red"> ${error} </h3>
			</c:forEach>
          	<form action="login.do" method="POST">
          		<table>
          			<c:forEach var="field" items="${form.visibleFields}">
          				<tr>
          					<td>
          						<input class="innerInput" id="${field.name}" type="${field.type}" name="${field.name}" value="${field.value}" placeholder="${field.label}"/>
          					</td>
          				</tr>
          				<tr>
          					<td style="color: red;padding-bottom: 15px">
          						${field.error}
          					</td>
          				</tr>
          			</c:forEach>
          		</table>
                <button class="innerButton" type="submit">Login</button>
          	</form>
            <p class="message">Not registered? <a href="register.do">Create an account</a></p>
        </div>
    </div>
</body>
</html>