<%--
  Created by IntelliJ IDEA.
  User: Алина
  Date: 27.10.2019
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>login</title>
    <link rel="stylesheet" href="assets_login/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets_login/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets_login/css/styles.min.css">
</head>
<body>
    <div class="login-dark" style="background-image: url('assets_login/img/three.jpg');">
    <form method="post" style="background-color: rgb(179,181,183);padding: 30px;filter: blur(0px) brightness(94%) contrast(103%) grayscale(0%);opacity: 0.81;">
        <h2 class="sr-only">Login Form</h2>
        <div class="illustration"><i class="icon ion-ios-body" style="background-color: rgba(255,255,255,0);color: rgba(255,255,255,0.97);"></i></div>
        <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email" style="filter: blur(0px) hue-rotate(0deg) invert(0%) saturate(117%);" /></div>
        <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password" /></div>
        <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background-color: #979797;">Log In</button></div><a class="forgot" href="#">Forgot your email or password?</a></form>
    </div>
    <script src="assets_login/js/jquery.min.js"></script>
    <script src="assets_login/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
