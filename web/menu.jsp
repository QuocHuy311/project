
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
    <a href="" class="text-decoration-none d-block d-lg-none">
        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">D</span>reamsneaker</h1>
    </a>
    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
        <div class="navbar-nav mr-auto py-0">
            <a href="home" class="nav-item nav-link active">Trang chủ</a>
            <!--            <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Thêm</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                <a href="cart.jsp" class="dropdown-item">Giỏ hàng</a>
                                <a href="checkout.jsp" class="dropdown-item">Thanh toán</a>
                            </div>
                        </div>-->
            <!--            <a href="contact.jsp" class="nav-item nav-link">Liên hệ</a>-->
            <c:if test="${sessionScope.account.issell == true}">
                <a href="managerproduct" class="nav-item nav-link">Quản lý sản phẩm</a>
            </c:if>
            <c:if test="${sessionScope.account.isadmin == true}">
                <a href="manageraccount" class="nav-item nav-link">Quản lý tài khoản</a>
            </c:if>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Biểu đồ</a>
                <div class="dropdown-menu rounded-0 m-0">
                    <c:if test="${sessionScope.account.isadmin == true}">
                        <a href="chart" class="dropdown-item">Doanh thu</a>
                    </c:if>
                    <c:if test="${sessionScope.account.isadmin == true || sessionScope.account.issell == true}">
                        <a href="piechart" class="dropdown-item">Sản phẩm ưa chuộng</a>
                    </c:if>
                </div>
            </div>

        </div>
        <c:if test="${sessionScope.account == null}" >
            <div class="navbar-nav ml-auto py-0">
                <a href="login.jsp" class="nav-item nav-link">Đăng nhập</a>
            </div>
        </c:if>
        <c:if test="${sessionScope.account != null}" >
            <div class="navbar-nav ml-auto py-0">
                <p class="nav-item nav-link">Xin chào ${sessionScope.account.fullname}!</p>
            </div>
            <div class="navbar-nav ml-auto py-0">
                <a href="logout" class="nav-item nav-link">Đăng xuất</a>
            </div>
        </c:if>
    </div>
</nav>