<%-- 
    Document   : cart
    Created on : Mar 3, 2024, 12:07:01 AM
    Author     : quoch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dreamsneaker</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <!-- Topbar Start -->
        <%@include file="topbar.jsp" %>
        <!-- Topbar End -->


        <!-- Navbar Start -->
        <div class="container-fluid">
            <div class="row border-top px-xl-5">
                <%@include file="left.jsp" %>
                <div class="col-lg-9">
                    <%@include file="menu.jsp" %>
                </div>
            </div>
        </div>
        <!-- Navbar End -->


        <!-- Page Header Start -->
        <div class="container-fluid bg-secondary mb-5">
            <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
                <h1 class="font-weight-semi-bold text-uppercase mb-3">Giỏ hàng</h1>
                <div class="d-inline-flex">
                    <p class="m-0"><a href="home">Trang chủ</a></p>
                    <p class="m-0 px-2">-</p>
                    <p class="m-0">Giỏ hàng</p>
                </div>
            </div>
        </div>
        <!-- Page Header End -->


        <!-- Cart Start -->
        <div class="container-fluid pt-5">
            <div class="row px-xl-5">
                <div class="col-lg-8 table-responsive mb-5">
                    <table class="table table-bordered text-center mb-0">
                        <thead class="bg-secondary text-dark">
                            <tr>
                                <th>Sản phẩm</th>
                                <th>Giá</th>
                                <th>Số lượng</th>
                                <th>Thành tiền</th>
                                <th>Xoá sản phẩm</th>
                            </tr>
                        </thead>
                        <tbody class="align-middle">
                            <c:set value="${sessionScope.cart}" var="c"></c:set>
                            <c:forEach items="${c.items}" var="i">
                                <tr>
                                    <td class="align-middle"><img src="${i.product.image}" alt="" style="width: 30px;">${i.product.name}</td>
                                    <td class="align-middle">${i.product.price}</td>
                                    <td class="align-middle">
                                        <div class="input-group quantity mx-auto" style="width: 100px;">
                                            <div class="input-group-btn">
                                                <button class="btn btn-sm btn-primary btn-minus" >
                                                    <a href="process?num=-1&id=${i.product.id}" style="color: white">-</a>
                                                </button>
                                            </div>
                                                    <input type="text" class="form-control form-control-sm bg-secondary text-center" readonly=""value="${i.quantity}">
                                            <div class="input-group-btn">
                                                <button class="btn btn-sm btn-primary btn-plus">
                                                    <a href="process?num=1&id=${i.product.id}" style="color: white">+</a>
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="align-middle">${i.quantity*i.price}</td>
                                    <td class="align-middle">
                                        <form action="process" method="post">
                                            <input type="hidden" name="id"  value="${i.product.id}">
                                            <input type="submit" value="X" style="background: #D19C97; border: 1px">
                                        </form></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-4">
<!--                    <form class="mb-5" action="sale">
                        <div class="input-group">
                            <input type="text" class="form-control p-4" placeholder="Mã giảm giá" name="sale">
                            <div class="input-group-append">
                                <button class="btn btn-primary">Áp dụng</button>
                            </div>
                        </div>
                    </form>-->
                    <form action="checkout" method="POST">
                        <div class="card border-secondary mb-5">
                            <div class="card-header bg-secondary border-0">
                                <h4 class="font-weight-semi-bold m-0">Chi tiết đơn hàng</h4>
                            </div>
                        <c:if test="${not empty c}">
                            <div class="card-body">
                                <div class="d-flex justify-content-between mb-3 pt-1">
                                    <h6 class="font-weight-medium">Tổng tiền đơn hàng</h6>
                                    <h6 class="font-weight-medium">${c.getTotalMoney()}00 VND</h6>
                                </div>
                            </div>
                            <div class="card-footer border-secondary bg-transparent">
                                <div class="d-flex justify-content-between mt-2">
                                    <h5 class="font-weight-bold">Tổng</h5>
                                    <h5 class="font-weight-bold">${c.getTotalMoney()}00 VND</h5>
                                </div>
                                
                            </div>
                                </c:if>
                            <button class="btn btn-block btn-primary my-3 py-3">Thanh toán</button>
                        </div>
                    </form>
                    <script type="text/javascript">
                        <% String successMessage = (String) request.getAttribute("successfull");
                            if (successMessage != null && !successMessage.isEmpty()) { %>
                        window.onload = function () {
                            alert("<%= successMessage %>");
                        };
                        <% } %>
                    </script>

                </div>
            </div>
        </div>
        <!-- Cart End -->


        <!-- Footer Start -->
        <%@include file="footer.jsp" %>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>

</html>
