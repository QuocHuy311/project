<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Dreamsneaker</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Chỉnh sửa <b>Tài khoản</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="editaccount" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Chỉnh sửa tài khoản</h4>
                                <!--                                <button type="submit" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>-->
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${detail.id}" name="id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input value="${detail.email}" name="email" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Mật khẩu</label>
                                    <input value="${detail.password}" name="pass" type="text" class="form-control" required>

                                </div>
                                <div class="form-group">
                                    <label>Tên tài khoản</label>
                                    <input value="${detail.fullname}" name="name" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Số điện thoại</label>
                                    <input value="${detail.phone}" name="phone" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Địa chỉ</label>
                                    <input value="${detail.address}" name="address" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Người bán</label><br>
                                    <input value="${true}" name="issell" type="radio"  required>Có
                                    <input value="${false}" name="issell" type="radio" required>Không
                                </div>
                                <div class="form-group">
                                    <label>Admin</label><br>
                                    <input value="${true}" name="isadmin" type="radio" required>Có
                                    <input value="${false}" name="isadmin" type="radio" required>Không
                                </div>
                            </div>
                            <div class="modal-footer">                              
                                <a href="manageraccount" style="border: 1px" class="btn btn-default">Trở về</a>
                                <input type="submit" class="btn btn-success" value="Sửa">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>


        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>