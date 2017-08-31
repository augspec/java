<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="Shortcut Icon"
	href="${pageContext.request.contextPath}/res/imgs/shortcut.ico">
<title>Giải pháp Bkav Core CA</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/res/plugins/font-awesome-4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/common/modal/modal.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/plugins/jquery-2.1.1/jquery.js"></script>
<%-- <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bank/bankHome.css"> --%>
</head>
<style>

	.contents {
		margin-top: 100px;
	}
	
	.box_card .main {		
   		margin: auto;
   		margin-left: 5%;
   		margin-right: 5%;
	}
	
	.main .box_title {
	    background: url(bank/img/line_title.png) no-repeat left bottom;
  	 	padding-bottom: 60px;
	}
	.box_title h3 {
		color: #17257d;
	    padding-left: 1.875%;
	    font-family: "Open Sans", sans-serif;
	    font-size: 200%;
	    font-weight: normal;
	    line-height: 2;
	    margin-left: 500px;
	    position: absolute;
	}
	.box_title .box_img {
/* 		max-width: 60%; */
	}
	.box_inner .box_img {
		float: right;
		width: 60%;
	}
	.box_inner .box_img img {		
		width: 100%;
		height: 60%;	
		float: right;	
	}
	
	.box_inner {
		margin-top: 3%;
	}
	.box_inner .box_txt {
		float: left;
		width: 40%
	}
	
	.box_txt h4 {
	    color: #17257d;
	    font-size: 188%;
	    font-family: "Open Sans", sans-serif;
	    margin-bottom: .5em;
	    line-height: 1.3;
	    font-weight: 700;
	    text-transform: uppercase;
	}
	
	.box_txt .txt {
		margin-bottom: 1em;
	}
	
@media only screen and (max-device-width: 480px) and (orientation: portrait) {
	
	.contents {
		margin-top: 60px;
	}
	
	.box_card .main {
   		margin: auto;
   		margin-left: 1%;
   		margin-right: 1%;
	}
	
	.box_title h3 {
	   /*  margin-left: 0px; */
	   position: inherit !important;
	   margin-left: 0px !important;
	   font-size: 170%;
	   font-weight: 700;
	}
	
	.box_title .box_img {
		margin: 0 auto;
	}
	
	.box_txt h4 {
	    font-size: 165% !important;
	}
		
	.box_inner .box_img {
		float: none !important;
		width: 100% !important;
	}
	
	.box_inner .box_txt {
		float: left !important;
		width: 100% !important;
	}
	
	.box_title .box_img img {
		display: block;
		margin: 0 auto;
	}
}	
</style>
<body>
	<%@include file="../common/navbar/navbarBank.jsp"%>
	
	<div class="contents">
		<div class="conCard" id="">
			<div class="box_card">
				<div class="main">
					<div class="box_title">
						<h3 class="">Thẻ tín dụng Platinum/Premier</h3>
						<div class="box_img animated fadeInLeft">
							<img alt="The tin dung" src="bank/img/card_1.png">
							<img alt="The tin dung" src="bank/img/card_2.png">
						</div>
					</div>
					<div class="box_inner">
				
						<div class="box_txt">
							<h4>TRẢI NGHIỆM ĐẲNG CẤP DUBAI</h4>
							<div class="txt animated fadeInUp delayp3">
							Trải nghiệm đẳng cấp quốc tế và tận hưởng các ưu đãi từ hệ thống khách sạn 
							Accor khi phát hành mới thẻ tín dụng hạng Platinum và chi tiêu tối thiểu 01 giao dịch từ 2,5 triệu VNĐ.  
							</div>
							<div></div>
						</div>
						<div class="box_img animated fadeInRight delayp2">
							<img alt="The tin dung" src="bank/img/dubai.jpg">
						</div>
   
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="../common/modal/modal.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/common/modal/modal.js"></script>
	
</body>
</html>