
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container-fluid">
    <div class="row align-items-center py-3 px-xl-5">
        <div class="col-lg-3 d-none d-lg-block">
            <a href="home" class="text-decoration-none">
                <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">D</span>reamsneaker</h1>
            </a>
        </div>
        <div class="col-lg-6 col-6 text-left">
            <form action="search">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Tìm kiếm" name="searchName">
                    <div class="input-group-append">                                                            
                        <button type="submit" class="input-group-text bg-transparent text-primary">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-lg-3 col-6 text-right">
            <c:set value="${sessionScope.size}" var="s"></c:set>
            <a href="cart.jsp" class="btn border">
                <i class="fas fa-shopping-cart text-primary"></i>
                <span class="badge">${s}</span>
            </a>
        </div>
    </div>
</div>