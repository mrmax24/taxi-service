<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/login.css' %>
</style>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <h1>LOGIN</h1>
        <h4 style="color: red">${errorMsg}</h4>
            <form method="post" action="${pageContext.request.contextPath}/login">
            <input type="text" name="login" placeholder="username" required>
            <input type="password" name="password" placeholder="password" required>
                <button type="submit">Login</button>
        </form>
            <p class="message">Not registered? <b>
                <a href="${pageContext.request.contextPath}/drivers/add">Create an account</a></b></p>
    </div>
</div>
</body>
</html>
