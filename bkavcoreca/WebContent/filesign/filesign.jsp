<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0" />
<link rel="Shortcut Icon"
	href="${pageContext.request.contextPath}/res/imgs/shortcut.ico">
<title>Bkav Core CA</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/res/plugins/font-awesome-4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/common/modal/modal.css">
<link
	href="${pageContext.request.contextPath}/res/plugins/upload/css/style.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/filesign/filesign.css">
		
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/plugins/jquery-2.1.1/jquery.js"></script>


</head>
<body style="background-color: #d4b5b5 !important;">
	<%@include file="../common/navbar/navbarFileSign.jsp"%>
	<div class="container content">
		<div class="row">
			<div class="leftBox">
				<span>${message }</span>
				<form id="upload" method="post" action="FileSign?action=sign"
					enctype="multipart/form-data">
					<div id="drop">
						<a class="btn btn-signin btn-sign-upload">SIGN</a> 
						<input type="file" name="file" id="file-to-sign"/> <br /> 
							<span style="color: blue; font-size: 11px" id="name-file-sign"></span>
					</div>  
					   
<!-- 					<ul class="result">
						<li id="file-sign"></li>
					</ul>	 -->				
					
				</form>
			</div>
			<div class="rightBox">
				<span>${message }</span>
				<form id="upload" method="post" action="FileSign?action=verify" class="uploadVerify"
					enctype="multipart/form-data">
					<div id="drop">
						<a class="btn btn-signin">VERIFY</a> <input
							type="file" name="data" id="btn-verify"/> <br />
							<span style="color: blue; font-size: 11px" id="file-verity"></span>
					</div>	
					<script type="text/javascript">
				        $('#btn-verify').on('change',function ()
			                {
			                    var filePath = $(this).val();
			                    console.log(filePath.substr(filePath.lastIndexOf('\\') + 1));
			                    $("#file-verity").text(filePath.substr(filePath.lastIndexOf('\\') + 1));
			                });
					</script>
<!-- 					<ul class="result">
						<li id="file-verify"></li>
					</ul> -->
				</form>
			</div>
		</div>
			
	</div>
	

	<object id="plugin0" type="application/x-bkavcaplugin"> </object>
	<div id="ExtensionPlaceHolder" ClientIDMode='Static'></div>
	
	<%@include file="../common/modal/modal.jsp"%>
	<%@include file="../common/enterpinmobile/enterpinmobile.jsp"%>
	<%@include file="../common/loading/loading.jsp"%>
	<%@include file="../common/choosecerforsign/choosecerforsign.jsp"%>
	<script
		src="${pageContext.request.contextPath}/res/plugins/upload/js/jquery.knob.js"></script>

	<!-- jQuery File Upload Dependencies -->
	<script
		src="${pageContext.request.contextPath}/res/plugins/upload/js/jquery.ui.widget.js"></script>
	<script
		src="${pageContext.request.contextPath}/res/plugins/upload/js/jquery.iframe-transport.js"></script>
	<script
		src="${pageContext.request.contextPath}/res/plugins/upload/js/jquery.fileupload.js"></script>

	<!-- Our main JS file -->
	<script
		src="${pageContext.request.contextPath}/res/plugins/upload/js/script.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/jspdf/jspdf.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/jspdf/jspdf.plugin.standard_fonts_metrics.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/jspdf/jspdf.plugin.split_text_to_size.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/jspdf/jspdf.plugin.from_html.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/base64/jquery.base64.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/base64/Base64.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/jspdf/FileSaver.js"></script>

	<script
		src="${pageContext.request.contextPath}/res/plugins/jspdf_autotable/jspdf.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/res/plugins/jspdf_autotable/jspdf.plugin.autotable.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/bkav-signer-extension-2.0/signer-extension.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/bkav-signer-extension-2.0/utils.js"></script>	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/bkav-signer-extension-2.0/bkav-signer-plugin.js"></script>	
					<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/download/download2.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/filesign/filesign.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/common/modal/modal.js"></script>
	

</body>
</html>