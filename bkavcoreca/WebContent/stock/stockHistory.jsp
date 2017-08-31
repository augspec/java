<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/res/imgs/shortcut.ico">
		<title>Giải pháp Bkav Core CA</title>
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/plugins/font-awesome-4.3.0/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/modal/modal.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/res/plugins/jquery-2.1.1/jquery.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bank/bankTransactionHistory.css">
		<style>
			.flt {
				float: left;
			}
			.frt {
				float: right;
			}
			.stock-pagination {
				/*padding: 0 10px;*/
			}
		</style>
	</head>
	<body>
		<%@include file="../common/navbar/navbarStock.jsp"%>
		<div class="container content">
			<div class="row">
				<div class="col-md-12 col-xs-12 col-sm-12 col-lg-12">
					<div id="panel" style="border: none !important;">
						<div class="paper-header">
							<span id="content-label">LỊCH SỬ</span>
						</div>
						<div id="list-user">
							<table class="table table-striped table-bordered">
								<thead id="list-user-head">
									<tr>
										<th class="center">#</th>
										<th class="center">Loại</th>
										<th class="center">Tên</th>
										<th class="center">Số lượng</th>
										<th class="center">Lệnh</th>
										<th class="center">Giá (VNĐ)</th>
										<th class="center">Sàn giao dịch</th>
										<th class="center">Thời gian giao dịch</th>
										<th class="center">File ký bởi <br/>máy chủ</th>
										<th class="center">File ký bởi <br/>người dùng</th>
									</tr>
								</thead>
								<tbody id="list-user-body">
									<c:set var="count" value="0" scope="page" />
									<c:forEach items="${requestScope.stockList}" var="log">
										<c:set var="count" value="${count + 1}" scope="page" />
										<tr>
											<td class="test-rowspan-right center">${count }</td>
											<td class="center">${log.type }</td>
											<td class="center">${log.name }</td>
											<td class="center">${log.amounts }</td>
											<td class="center">${log.commandType }</td>
											<td class="center">${log.price }</td>
											<td class="center">${log.market }</td>
											<td class="center">
												<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${log.transactionTime }" />
											</td>										
											<td class="test-rowspan-left center">
												<a target="_blank" title="Tải về" href="StockMarketHistory?download=serverSigned&file=${log.stockId }">
													<i class="fa fa-download"></i>
												</a>
											</td>
											<td class="test-rowspan-left center">
												<a target="_blank" title="Tải về" href="StockMarketHistory?download=clientSigned&file=${log.stockId }">
													<i class="fa fa-download"></i>
												</a>
											</td>										
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="stock-pagination">
								${requestScope.pagination }
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../common/modal/modal.jsp"%>
		<script type="text/javascript" src="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/common/modal/modal.js"></script>
		<script type="text/javascript">
			
		</script>
	</body>
</html>