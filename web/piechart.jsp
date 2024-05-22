<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
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
        <div class="col-lg-3 d-none d-lg-block">
            <a href="home" class="text-decoration-none">
                <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">D</span>reamsneaker</h1>
            </a>
        </div>
        <div id="piechart" style="width: 900px; height: 500px;"></div>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {

                var data = google.visualization.arrayToDataTable([
                    ['Task', 'Hours per Day'],
                    ['${requestScope.cdto1.name}', ${requestScope.cdto1.quantity}],
                    ['${requestScope.cdto2.name}', ${requestScope.cdto2.quantity}],
                    ['${requestScope.cdto3.name}', ${requestScope.cdto3.quantity}],
                    ['${requestScope.cdto4.name}', ${requestScope.cdto4.quantity}],
                    ['${requestScope.cdto5.name}', ${requestScope.cdto5.quantity}],
                    ['${requestScope.cdto6.name}', ${requestScope.cdto6.quantity}],
                    ['${requestScope.cdto7.name}', ${requestScope.cdto7.quantity}]
                ]);

                var options = {
                    title: 'Hãng sản phẩm được ưa chuộng'
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                chart.draw(data, options);
            }
        </script>
    </body>
</html>

