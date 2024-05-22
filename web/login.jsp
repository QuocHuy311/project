<%-- 
    Document   : login
    Created on : Feb 29, 2024, 8:49:59 PM
    Author     : quoch
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style_login.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="login-wrap">
            <div class="login-html">
                <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Đăng nhập</label>
                <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Đăng ký</label>
                <div class="login-form">
                    <div class="sign-in-htm">
                        <form action="login" method="post">
                            <div class="group" style="color: white;">
                                <p>${mess}</p>
                            </div>
                            <div class="group">
                                <label for="user" class="label">Email</label>
                                <input id="email" type="text" class="input" name="email">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Mật khẩu</label>
                                <input id="pass" type="password" class="input" data-type="password" name="pass">
                            </div>
                            <!--                        <div class="group">
                                                        <input id="check" type="checkbox" class="check" checked>
                                                        <label for="check"><span class="icon"></span> Keep me Signed in</label>
                                                    </div>-->
                            <div class="group">
                                <input type="submit" class="button" value="Đăng nhập" style="cursor: pointer">
                            </div>
                        </form>
                        <div class="hr"></div>
                        <!--                        <div class="foot-lnk">
                                                    <a href="#forgot">Forgot Password?</a>
                                                </div>-->
                    </div>
                    <div class="sign-up-htm">
                        <form action="register" method="post">
                            <div class="group" style="color: white;">
                                <p>${mess1}</p>
                            </div>
                            <div class="group">
                                <label for="name" class="label">Tên của bạn</label>
                                <input id="name" type="text" class="input" name="name">
                            </div>
                            <div class="group">
                                <label for="user" class="label">Email</label>
                                <input id="email" type="text" class="input" name="email">
                            </div>
                            <div class="group">
                                <label for="address" class="label">Địa chỉ</label>
                                <input id="address" type="text" class="input" name="address">
                            </div>
                            <div class="group">
                                <label for="phonenumber" class="label">Số điện thoại</label>
                                <input id="phonenumber" type="text" class="input" name="phonenumber">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Mật khẩu</label>
                                <input id="pass" type="password" class="input" data-type="password" name="pass">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Nhập lại mật khẩu</label>
                                <input id="pass" type="password" class="input" data-type="password" name="re_pass">
                            </div>
                            <div class="group">
                                <input type="submit" class="button" value="Đăng ký" style="cursor: pointer">
                            </div>
                            <div class="hr"></div>
                        </form>
                        <div class="foot-lnk">
                            <label for="tab-1">Already Member?</a>
                        </div>
                    </div



                </div>
            </div>
        </div

    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>


</html>
