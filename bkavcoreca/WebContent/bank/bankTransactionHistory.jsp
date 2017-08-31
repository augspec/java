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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bank/bankTransactionHistory.css">
</head>
<body>
	<%@include file="../common/navbar/navbarBank.jsp"%>
	<div class="container content">
		<div class="row">
			<div class="col-md-12 col-xs-12 col-sm-12 col-lg-12">
				<div id="panel">
					<div class="paper-header">
						<span id="content-label">LỊCH SỬ</span>
					</div>
					<div id="list-user">
						<table class="table table-striped">
							<thead id="list-user-head">
								<tr>
									<th class="center">#</th>
									<th>Thời gian</th>
									<th>Số TK thụ hưởng</th>
									<th>Loại giao dịch</th>
									<th>Số tiền</th>
									<th class="center">NK Server</th>
									<th class="center">NK Nguoi dung</th>
								</tr>
							</thead>
							<tbody id="list-user-body">
								<c:set var="count" value="0" scope="page" />
								<c:forEach items="${bankTranscations}" var="log">
									<c:set var="count" value="${count + 1}" scope="page" />
									<tr>
										<td class="test-rowspan-right center">${count }</td>
										<td class="center"><fmt:formatDate pattern="dd/MM/yyyy"
												value="${log.dateTransaction }" /><br> <b class="trantime"><fmt:formatDate
												pattern="HH:mm:ss" value="${log.dateTransaction }" /></b></td>
										<td>${log.numberBeneficiary }</td>
										<td>${log.typeTransaction }</td>
										<td>${log.numberMoney }</td>										
										<td class="test-rowspan-left center">
											<a target="_blank" 
											href="BankTransactionHistory?id=download&file=${log.id }">
												<i class="fa fa-download"></i>
											</a> 
								<%-- 			<a href="#" class="remove_link" id="${log.id }">
											<i class="fa fa-trash-o"></i></a> --%>
										</td>
										<td class="test-rowspan-left center">
											<a target="_blank" 
											href="BankTransactionHistory?id=downloadxml&file=${log.id }">
												<i class="fa fa-download"></i>
											</a> 
								<%-- 			<a href="#" class="remove_link" id="${log.id }">
											<i class="fa fa-trash-o"></i></a> --%>
										</td>										
									</tr>
								</c:forEach>
							</tbody>
						</table>
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
	<script type="text/javascript">
		$('.page-scroll').each(function() {
			$(this).removeClass('active');
		});
		$('#nav-history').addClass('active');
		var file = "";
		doConfirm(callBack);
		$('.remove_link').each(function(){
			$(this).bind('click', function(){
				file = $(this).attr('id');
				var fileNae = $(this).closest("tr").find("td.filename").text();
				confirm("Are you sure want to remove <b>" + fileNae + "</b>?");
			});
		});
		function callBack(){
			location.href = "TransactionLogServlet?id=remove&file=" + file;
		}
	</script>
</body>
</html>