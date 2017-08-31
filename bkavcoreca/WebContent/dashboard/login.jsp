<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
<link type="text/css" rel="stylesheet" href="common/footer/footer.css">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html {
	background: url(dashboard/img/background-image.jpg) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	height: 100%;
}

body {
	background: transparent;
}
/*
 * Specific styles of signin component
 */
/*
 * General styles
 */
.card-container.card {
	max-width: 350px;
	padding: 40px 40px;
	position: absolute;
	margin: auto;
	position: absolute;
	height: 70%;
	min-height: 430px;
	top: 0;
	bottom: 0;
	right: 100px;
	background-color: #ff6e01;
}

@media ( max-width :767px) {
	.card-container.card {
		top: 0 !important;
		bottom: 0 !important;
		left: 0 !important;
		right: 0 !important;
		width: 80% !important;
		background-color: #ff6e01;
	}
}

.btn {
	font-weight: 700;
	height: 36px;
	-moz-user-select: none;
	-webkit-user-select: none;
	user-select: none;
	cursor: default;
}

/*
 * Card component
 */
.card {
	/* just in case there no content*/
	padding: 20px 25px 30px;
	margin: 0 auto 25px;
	margin-top: 50px;
	/* shadows and rounded borders */
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	-moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
	width: 96px;
	height: 96px;
	margin: 0 auto 10px;
	display: block;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	border-radius: 50%;
}

/*
 * Form styles
 */
.profile-name-card {
	font-size: 16px;
	font-weight: bold;
	text-align: center;
	margin: 10px 0 0;
	min-height: 1em;
}

.reauth-email {
	display: block;
	color: #404040;
	line-height: 2;
	margin-bottom: 10px;
	font-size: 14px;
	text-align: center;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin #inputEmail, .form-signin #inputPassword {
	direction: ltr;
	height: 44px;
	font-size: 16px;
	box-shadow: none;
    outline: none;
    border: solid 1px #fff;
    background: none;
    color: #fff !important;
}
input::-webkit-input-placeholder,
textarea::-webkit-input-placeholder {
  color: #666;
}
input:-moz-placeholder,
textarea:-moz-placeholder {
  color: #666;
}
input::-moz-placeholder,
textarea::-moz-placeholder {
  color: #666;
}
input:-ms-input-placeholder,
textarea:-ms-input-placeholder {
  color: #666;
}

.form-signin input[type=email], .form-signin input[type=password],
	.form-signin input[type=text], .form-signin button {
	width: 100%;
	display: block;
	margin-bottom: 10px;
	z-index: 1;
	position: relative;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	border-radius: 0px !important;
	box-shadow: none;
}

.form-signin .form-control:focus {
	border-color: rgb(104, 145, 162);
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgb(104, 145, 162);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgb(104, 145, 162);
}

.btn-signin {
	background: none;
	/*     background-color: rgb(104, 145, 162); */
	/* background-color: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));*/
	cursor: pointer;
	padding: 0px;
	font-weight: 700;
	font-size: 14px;
	height: 36px;
	-moz-border-radius: 1px;
	-webkit-border-radius: 1px;
	color: #fff;
	border-radius: 1px;
	border: solid 1px #fff;
	-o-transition: all 0.218s;
	-moz-transition: all 0.218s;
	-webkit-transition: all 0.218s;
	transition: all 0.218s;
}

.btn-signin:hover, .btn-signin:active, .btn-signin:focus {
	background-color: #ff6e01;
	color: #fff;
	border: none;
}
.btn-signin:hover::after, .btn-signin:hover::before {
  -webkit-transform: scale(1);
}

.btn-signin::before, .btn-signin::after {
  width: 100%;
  height:100%;
  z-index: 3;
  content:'';
  position: absolute;
  top:0;
  left:0;
  box-sizing: border-box;
  -webkit-transform: scale(0);
  transition: 0.5s;
}
.btn-signin::before {
  border-bottom: 3px solid #FFF;
  border-left: 3px solid #FFF;
  -webkit-transform-origin: 0 100%;
}

.btn-signin::after {
  border-top: 3px solid #FFF;
  border-right: 3px solid #FFF;
  -webkit-transform-origin: 100% 0%;
}

.forgot-password {
	color: rgb(104, 145, 162);
}

.forgot-password:hover, .forgot-password:active, .forgot-password:focus
	{
	color: rgb(12, 97, 33);
}

.error {
	color: red;
}
#remember{
	padding-top: 50px;
}
.footer {
	width: 100%;
	height: 60px;
	color: #ffffff;
    position: absolute;
    bottom: 15px;
    right: 100px;
}

.footer ul li {
	list-style: none;
	font-family: Tahoma;
	float: right;
	display: block;
	padding-bottom: 15px;
}

.footer ul li.iso {
	padding: 5px;
	margin-top: 22px;
	margin-right: 10px;
	border: 1px solid #ffffff;
	font-size: 10px;
	font-weight: bolder;
	border-radius: 4px 0px 4px 0px;
	margin-right: 10px;
}

.footer ul li.iso span {
	font-size: 8px;
}

.footer ul li.name {
	font-size: 10px;
	margin-right: 20px;
	margin-top: 20px;
}

.footer ul li.name span {
	font-size: 10px;
}

.footer ul li.logo {
	margin-top: 22px;
}


/* @media only screen and (max-device-width: 480px) and (orientation: portrait) {
	#card-container:before, #card-container:after {
          content: "";
          display: table;
          clear: both;
     }
     
     .card-container {
		width: 70% !important; 
		max-width: none !important;
		margin-left: 25% !important;
		height: 40% !important;
		min-height: none !important;			
     }
     
	.form-signin #inputEmail, .form-signin #inputPassword {
	    height: 100px;
	    font-size: 16px;
	}     
      
} */

</style>
</head>
<body>
	
	<%@include file="../common/navbar/navbarLogin.jsp"%>
	
	<div class="container">
		<div class="card card-container">
			<img id="profile-img" class="profile-img-card"
				src="res/imgs/profile-image-default.png" />
			<p id="profile-name" class="profile-name-card"></p>
			<form id="login-form" class="form-signin" action="login"
				method="post">
				<span id="reauth-email" class="reauth-email"></span> <input
					type="text" id="inputEmail" class="form-control"
					placeholder="Tên tài khoản" required autofocus name="username">
				<input type="password" id="inputPassword" class="form-control"
					placeholder="Mật khẩu" required name="password">
				<div id="remember">
				</div>
				<span class="error">${error }</span>
				<button id="signin"
					class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Đăng
					nhập</button>
			</form>
			<!-- /form -->
		</div>
		<!-- /card-container -->
	</div>
<%
	String context_footer = request.getContextPath();
%>

<%-- <div class="container">
	<div class="footer">
		<ul>
			<li class="logo"><a href="http://www.bkav.com/"><img
					alt="logo"
					src="<%=context_footer%>/res/imgs/bkav-footer-logo.png"></a></li>
			<li class="name"><span>© 1995 - 2014<br> Bkav
					Corporation
			</span></li>
			<li class="iso"><span>ISO 9001</span></li>
			<li class="iso"><span>ISO 27001</span></li>
		</ul>
	</div>
</div> --%>
	<!-- /container -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/jquery-2.1.1/jquery.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		// 		$('#signin').click(function(){
		// 			location.href="home/index.jsp";
		// 		});
		$("#login-form").on('keydown', $("#inputEmail"), function(e) {
			$('.error').text('');
		});
		$("#login-form").on('keydown', $("#inputPassword"), function(e) {
			$('.error').text('');
		});
	</script>
</body>
</html>