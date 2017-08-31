<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="Shortcut Icon"
	href="${pageContext.request.contextPath}/res/imgs/shortcut.ico">
<title>Bkav Code Signing</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/css/bootstrap.min.css">


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bank/bankInfoAccount.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/plugins/jquery-2.1.1/jquery.js"></script>

<style>

</style>

</head>
<body>
	<%@include file="../common/navbar/navbarBank.jsp"%>
	
	<div class="content" style="margin-left: 25%; margin-right: 25%; margin-top: 50px;">
		<div class="uiHeader">
			<div><h2 class="uiHeaderTitle">Thông Tin Tài Khoản </h2></div>
		</div>
		
		<div class="contentArea">
			<div class="contentShow">
				<ul class="uiList infoCertificate">
					<li class="infoCertificateListItem">						
						<div>
							<span class="infoCertificateListItemLabel">Tên chủ tài khoản</span>
							<span class="infoCertificateListItemContent">Demo CoreCA</span>
						</div>
					</li>
					<li class="infoCertificateListItem">						
						<div>
							<span class="infoCertificateListItemLabel">Số tài khoản</span>
							<span class="infoCertificateListItemContent">2794156124145525</span>
						</div>
					</li>
					<li class="infoCertificateListItem">						
						<div>
							<span class="infoCertificateListItemLabel">Số dư hiện tại</span>
							<span class="infoCertificateListItemContent">9,000,000,000 VND</span>
						</div>
					</li>
					<li class="infoCertificateListItem">						
						<div>
							<span class="infoCertificateListItemLabel">Số dư khả dụng</span>
							<span class="infoCertificateListItemContent">9,000,000,000 VND</span>
						</div>
					</li>
					<li class="infoCertificateListItem">						
						<div>
							<span class="infoCertificateListItemLabel">Số tiền phong tỏa</span>
							<span class="infoCertificateListItemContent">0 VND</span>
						</div>
					</li>		
					<li class="infoCertificateListItem">						
						<div>
							<span class="infoCertificateListItemLabel">Loại tiền</span>
							<span class="infoCertificateListItemContent">VND</span>
						</div>
					</li>
					<li class="infoCertificateListItem">						
						<div>
							<span class="infoCertificateListItemLabel">Chi nhánh mở</span>
							<span class="infoCertificateListItemContent">NHBKAV CAU GIAY</span>
						</div>
					</li>
				</ul>
			</div>
			<div class="contentRegister">
				<a href="BankTransaction">
					<button id="" class="btn btnRegister">Chuyển tiền</button>
				</a>				
			</div>
		</div>
	</div>
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
		
	<script type="text/javascript">
		$("#brand-label").text("Bkav Core CA")
		$(".navbarHome").attr("href", "/bkavcoreca")
	</script>
</body>
</html>