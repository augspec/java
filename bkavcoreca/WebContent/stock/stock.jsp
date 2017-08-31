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
<title>Bkav Code Signing</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stock/res/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stock/res/modal.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stock/res/home.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stock/res/bkav-signer-plugin.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/res/plugins/jquery-2.1.1/jquery.js"></script>
<style>
@media only screen and (max-device-width: 480px) {


	.content {
		width: 140% !important;
	}	
	
	.message-modal {
		width: 95% !important;
	}
	
}
</style>

</head>
<body>
	<%@include file="../common/navbar/navbarStock.jsp"%>
	
	<div class="container content">
		<div class="market_panel row">
			<div class="col-md-12">

				<div id="market_panel_header" class="paper-header">
					<span>Thông tin thị trường</span>
				</div>
				<div class="market_panel_content">
					<div class="row brief_panel">
						<div class="col-md-6">
							<span>VNI:</span><span class="brief_info">579.45(<i class="fa fa-caret-up status green"></i>3.16 0.55%)
							</span><span> KL: 90,049,368&nbsp;&nbsp; GT: 1485.91 tỷ </span>
						</div>
						<div class="col-md-6 brief_panel-right">
							<span> HNX:</span><span class="brief_info">79.28(<i class="fa fa-caret-up status green"></i>0.67 0.85%)
							</span><span>KL: 48,394,912&nbsp;&nbsp; GT: 502.53 tỷ </span>
						</div>
					</div>
					<div class="row brief_panel">
						<div class="col-md-6">
							<span>VN30:</span><span class="brief_info">594.8(<i class="fa fa-caret-up status green"></i>5.37 0.81%)
							</span><span> KL: 30,984,840&nbsp;&nbsp; GT: 706.86 tỷ </span>
						</div>
						<div class="col-md-6 brief_panel-right">
							<span> HNX30:</span><span class="brief_info">139.93(<i class="fa fa-caret-up status green"></i>1.4 1.01%)
							</span><span>KL: 16,757,700&nbsp;&nbsp; GT: 162.51 tỷ</span>
						</div>
					</div>
					<div class="desktop-market">
						
<table id="stock-market" class="table table-bordered table-sale-stock">
	<thead>
		<tr>
			<th rowspan="2">Mã CK</th>
			<th rowspan="2" class="referen">Trần</th>
			<th rowspan="2" class="referen">Sàn</th>
			<th rowspan="2" class="referen">TC</th>
			<th colspan="6">Dư mua</th>
			<th rowspan="2" class="referen">Giá<br>khớp
			</th>
			<th rowspan="2" class="referen">KL<br>khớp
			</th>
			<th rowspan="2" class="referen">+/-</th>
			<th colspan="6">Dư bán</th>
			<th rowspan="2" class="referen">Tổng<br>KL
			</th>
			<th rowspan="2" class="referen">Trung<br>bình
			</th>
			<th rowspan="2" class="referen">Mở<br>cửa
			</th>
			<th rowspan="2" class="referen">Cao<br>nhất
			</th>
			<th rowspan="2" class="referen">Thấp<br>nhất
			</th>
			<th rowspan="2" class="referen">NN<br>mua
			</th>
			<th rowspan="2" class="referen">NN<br>bán
			</th>
		</tr>
		<tr>
			<th>Giá 3</th>
			<th>KL 3</th>
			<th>Giá 2</th>
			<th>KL 2</th>
			<th>Giá 1</th>
			<th>KL 1</th>
			<th>Giá 1</th>
			<th>KL 1</th>
			<th>Giá 2</th>
			<th>KL 2</th>
			<th>Giá 3</th>
			<th>KL 3</th>
		</tr>
	</thead>
	<tbody id="list-user-body">
		<tr>
			<td class="stock-type"><label class="tock-name">ACM</label> <i class="fa fa-caret-up status green"></i></td>
			<td class="max_price referen">8</td>
			<td class="min_price referen">5.3</td>
			<td class="tc_price referen">6.6</td>
			<td class="sell_price_3" style="color: rgb(73, 172, 50);">5.9</td>
			<td class="sell_weigth_3" style="color: rgb(73, 172, 50);">3654</td>
			<td class="sell_price_2" style="color: rgb(73, 172, 50);">6.2</td>
			<td class="sell_weigth_2" style="color: rgb(73, 172, 50);">9792</td>
			<td class="sell_price_1" style="color: red;">7.5</td>
			<td class="sell_weigth_1" style="color: red;">4096</td>
			<td class="match_price referen" style="color: rgb(11, 255, 9);">7.0</td>
			<td class="match_weight referen" style="color: rgb(11, 255, 9);">8100</td>
			<td class="match_value referen" style="color: rgb(11, 255, 9);">-0.2</td>
			<td class="buy_price_1" style="color: rgb(73, 172, 50);">6.1</td>
			<td class="buy_weigth_1" style="color: rgb(73, 172, 50);">8100</td>
			<td class="buy_price_2" style="color: red;">6.8</td>
			<td class="buy_weigth_2" style="color: red;">843</td>
			<td class="buy_price_3" style="color: rgb(73, 172, 50);">6.1</td>
			<td class="buy_weigth_3" style="color: rgb(73, 172, 50);">1710</td>
			<td class="referen">754980</td>
			<td class="referen"></td>
			<td class="total_price_1 referen" style="color: red;">5.7</td>
			<td class="total_price_2 referen" style="color: rgb(11, 255, 9);">6.8</td>
			<td class="total_price_3 referen" style="color: rgb(27, 175, 226);">5.3</td>
			<td class="referen"></td>
			<td class="referen"></td>
		</tr>
		<tr>
			<td class="stock-type"><label class="tock-name">HHS</label> <i class="fa fa-caret-down status red"></i></td>
			<td class="max_price referen">5</td>
			<td class="min_price referen">4.2</td>
			<td class="tc_price referen">4.6</td>
			<td class="sell_price_3" style="color: red;">4.9</td>
			<td class="sell_weigth_3" style="color: red;">6178</td>
			<td class="sell_price_2" style="color: red;">4.7</td>
			<td class="sell_weigth_2" style="color: red;">8548</td>
			<td class="sell_price_1" style="color: rgb(247, 145, 210);">5.0</td>
			<td class="sell_weigth_1" style="color: rgb(247, 145, 210);">1136</td>
			<td class="match_price referen" style="color: rgb(255, 255, 0);">4.6</td>
			<td class="match_weight referen" style="color: rgb(255, 255, 0);">8100</td>
			<td class="match_value referen" style="color: rgb(255, 255, 0);"></td>
			<td class="buy_price_1" style="color: red;">4.8</td>
			<td class="buy_weigth_1" style="color: red;">1116</td>
			<td class="buy_price_2" style="color: red;">4.8</td>
			<td class="buy_weigth_2" style="color: red;">2976</td>
			<td class="buy_price_3" style="color: red;">4.7</td>
			<td class="buy_weigth_3" style="color: red;">7274</td>
			<td class="referen">754980</td>
			<td class="referen"></td>
			<td class="total_price_1 referen" style="color: rgb(11, 255, 9);">4.7</td>
			<td class="total_price_2 referen" style="color: rgb(11, 255, 9);">4.8</td>
			<td class="total_price_3 referen" style="color: rgb(255, 255, 0);">4.6</td>
			<td class="referen"></td>
			<td class="referen"></td>
		</tr><tr>
			<td class="stock-type"><label class="tock-name">AFC</label> <i class="fa fa-caret-up status green"></i></td>
			<td class="max_price referen">5</td>
			<td class="min_price referen">4.2</td>
			<td class="tc_price referen">4.6</td>
			<td class="sell_price_3" style="color: red;">4.8</td>
			<td class="sell_weigth_3" style="color: red;">2999</td>
			<td class="sell_price_2" style="color: red;">4.9</td>
			<td class="sell_weigth_2" style="color: red;">4976</td>
			<td class="sell_price_1" style="color: rgb(73, 172, 50);">4.4</td>
			<td class="sell_weigth_1" style="color: rgb(73, 172, 50);">2858</td>
			<td class="match_price referen" style="color: red;">4.4</td>
			<td class="match_weight referen" style="color: red;">8100</td>
			<td class="match_value referen" style="color: red;">-0.2</td>
			<td class="buy_price_1" style="color: rgb(247, 145, 210);">5.0</td>
			<td class="buy_weigth_1" style="color: rgb(247, 145, 210);">9173</td>
			<td class="buy_price_2" style="color: rgb(73, 172, 50);">4.5</td>
			<td class="buy_weigth_2" style="color: rgb(73, 172, 50);">7433</td>
			<td class="buy_price_3" style="color: rgb(247, 145, 210);">5.0</td>
			<td class="buy_weigth_3" style="color: rgb(247, 145, 210);">5574</td>
			<td class="referen">754980</td>
			<td class="referen"></td>
			<td class="total_price_1 referen" style="color: rgb(11, 255, 9);">4.7</td>
			<td class="total_price_2 referen" style="color: rgb(11, 255, 9);">4.8</td>
			<td class="total_price_3 referen" style="color: rgb(255, 255, 0);">4.6</td>
			<td class="referen"></td>
			<td class="referen"></td>
		</tr>
	</tbody>
</table>
					</div>
					<div class="mobile-market">
						<table id="stock-market" class="table table-bordered">
	<thead>
		<tr>
			<th rowspan="2">Mã CK</th>
			<th rowspan="2" class="referen">Trần</th>
			<th rowspan="2" class="referen">Sàn</th>
			<th rowspan="2" class="referen">TC</th>
			<th colspan="2">Dư mua</th>
			<th rowspan="2" class="referen">Giá<br>khớp
			</th>
			<th rowspan="2" class="referen">KL<br>khớp
			</th>
			<th rowspan="2" class="referen">+/-</th>
			<th colspan="2">Dư bán</th>
		</tr>
		<tr>
			<th>Giá 1</th>
			<th>KL 1</th>
			<th>Giá 1</th>
			<th>KL 1</th>
		</tr>
	</thead>
	<tbody id="list-user-body">
		<tr>
			<td class="stock-type"><label class="tock-name">AMC</label> <i class="fa fa-caret-up status green"></i></td>
			<td class="max_price referen">8</td>
			<td class="min_price referen">5.3</td>
			<td class="tc_price referen">6.6</td>
			<td class="sell_price_1" style="color: red;">7.7</td>
			<td class="sell_weigth_1" style="color: red;">119</td>
			<td class="match_price referen" style="color: rgb(11, 255, 9);">7.0</td>
			<td class="match_weight referen" style="color: rgb(11, 255, 9);">8100</td>
			<td class="match_value referen" style="color: rgb(11, 255, 9);">-0.2</td>
			<td class="buy_price_1" style="color: rgb(73, 172, 50);">6.0</td>
			<td class="buy_weigth_1" style="color: rgb(73, 172, 50);">2877</td>
		</tr>
		<tr>
			<td class="stock-type"><label class="tock-name">HHS</label> <i class="fa fa-caret-up status green"></i></td>
			<td class="max_price referen">5</td>
			<td class="min_price referen">4.2</td>
			<td class="tc_price referen">4.6</td>
			<td class="sell_price_1" style="color: rgb(247, 145, 210);">5.0</td>
			<td class="sell_weigth_1" style="color: rgb(247, 145, 210);">9508</td>
			<td class="match_price referen" style="color: red;">4.4</td>
			<td class="match_weight referen" style="color: red;">8100</td>
			<td class="match_value referen" style="color: red;">-0.2</td>
			<td class="buy_price_1" style="color: red;">4.9</td>
			<td class="buy_weigth_1" style="color: red;">7392</td>
		</tr>
		<tr>
			<td class="stock-type"><label class="tock-name">AFC</label> <i class="fa fa-caret-up status green"></i></td>
			<td class="max_price referen">5</td>
			<td class="min_price referen">4.2</td>
			<td class="tc_price referen">4.6</td>
			<td class="sell_price_1" style="color: rgb(27, 175, 226);">4.2</td>
			<td class="sell_weigth_1" style="color: rgb(27, 175, 226);">7620</td>
			<td class="match_price referen" style="color: red;">4.4</td>
			<td class="match_weight referen" style="color: red;">8100</td>
			<td class="match_value referen" style="color: red;">-0.2</td>
			<td class="buy_price_1" style="color: rgb(247, 145, 210);">5.0</td>
			<td class="buy_weigth_1" style="color: rgb(247, 145, 210);">9875</td>
		</tr>
	</tbody>   
</table>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="custome custom_right col-md-3">
				<div class="panel">
					<div class="paper-header">
						<span>Thông tin tài khoản</span>
					</div>
					<table class="table panel_content ">
						<tbody><tr>
							<td class="td-left">Số dư tiền mặt:</td>
							<td class="td-right">2,500,000VNĐ</td>
						</tr>
						<tr>
							<td class="td-left">Tiền ứng trước</td>
							<td class="td-right">15,000,000VNĐ</td>
						</tr>
						<tr>
							<td class="td-left">Số dư có thể giao dịch</td>
							<td class="td-right">10,000,000VNĐ</td>
						</tr>
						<tr>
							<td class="td-left">KL có thể mua</td>
							<td class="td-right">350,000</td>
						</tr>
						<tr>
							<td class="td-left">Tiền treo gốc</td>
							<td class="td-right">5,000,000VNĐ</td>
						</tr>
					</tbody></table>
				</div>
			</div>
			<div class="custome custom_right col-md-9" id="place_oder" style="display: none">
				<div class="panel">
					<div class="paper-header">
						<span>Ghi lệnh</span>
					</div>
					<div id="add_tran_form" class="panel_content row form-group">
						<div class="col-md-2">
							<label>Mua/bán:</label> <select id="tran_type" class="form-control">
								<option value="BAN" selected="selected">Bán</option>
								<option value="MUA">Mua</option>
							</select>
						</div>
						<div class="col-md-2">
							<label>Chứng khoán:</label> <input id="form_stock_name" class="form-control" type="text" name="action_type" disabled="disabled">
						</div>
						<div class="col-md-2">
							<label>Số lượng:</label> <input id="form_stock_count" class="form-control" type="text" name="action_type" value="10">
						</div>
						<div class="col-md-2">
							<label>Loại lệnh:</label> <select id="_type" class="form-control">
								<option value="LO" selected="selected">LO</option>
								<option value="ATO">ATO</option>
								<option value="ATC">ATC</option>
								<option value="MP">MP</option> 
							</select>
						</div>
						<div class="col-md-2">
							<label>Giá (VNĐ):</label> <input id="form_stock_price" class="form-control" type="text" name="action_type" value="0">
						</div>
						<div class="col-md-2">
							<label>Sàn GD:</label> <select id="market" class="form-control" disabled="disabled">
								<option value="HOSE" selected="selected">HOSE</option>
							</select>
						</div>
					</div>
					<div class="row form-group tc_price_group">
						<label style="color: #F791D2;">Giá trần: </label><label id="form_max_price" class="form_tc_price" style="color: #F791D2;">0</label><label class="vnd" style="color: #F791D2;">VNĐ</label> <label>Giá
							TC: </label><label id="form_tc_price" class="form_tc_price">0</label><label class="vnd">VNĐ</label> <label style="color: #1BAFE2;">Giá
							sàn: </label><label id="form_min_price" class="form_tc_price" style="color: #1BAFE2;">0</label><label class="vnd" style="color: #1BAFE2;">VNĐ</label>
						<div>
							<button id="add_tran" class="btn btn-default">Ghi lệnh</button>
						</div>
					</div>
				</div>
				<div class="panel">
					<div class="paper-header">
						<span>Danh sách lệnh chờ gửi</span>
					</div>
					<div class="panel_content">
						<table id="record" class="table table-striped">
							<thead>
								<tr>
									<th class="">#</th>
									<th class="">Mua/bán</th>
									<th class="">Mã chứng khoán</th>
									<th class="">KL</th>
									<th class="">Giá</th>
									<th class="">Trạng thái</th>
									<th class="">Xóa</th>
								</tr>
							</thead>
							<tbody id="list-trans">
							
							
							</tbody>
						</table>
					</div>
					<div class="form-group tc_price_group">
						<button id="send_tran" class="btn btn-success">Gửi lệnh</button>
						<input type="hidden" id="cert-serial-number" value="${serialNumber}">
					</div>
				</div>

			</div>
		</div>
		<div id="test"></div>
	</div>
	<ul class="custom-menu" style="">
		<li data-action="first"><i class="fa fa-money context-menu-icon red"></i>Bán <b class="menu-stock-name"></b></li>
		<li data-action="second"><i class="fa fa-shopping-cart context-menu-icon green"></i>Mua <b class="menu-stock-name"></b></li>
	</ul>
	<object id="plugin0" type="application/x-bkavcaplugin"> </object>
	<div id="ExtensionPlaceHolder" clientidmode="Static"><input type="image" id="holderDataInputToExtension" style="visibility:hidden" clientidmode="Static" name=""><input type="image" id="hrSignedData" style="visibility:hidden" clientidmode="Static" name=""><button type="button" id="actionToExtensionProcess" style="visibility:hidden" clientidmode="Static" name=""></button></div>
	
	<div id="dataToInsertStock"></div>
	
<!-- 	Result popup -->
<div id="result_modal" class="modal fade">
	<div id="modal-dialog" class="modal-dialog message-modal">
		<div id="modal-content" class="modal-content">

			<div class="modal-header" id="result_modal_header">
				<button type="button" id="close_ico" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="result_title"></h4>
			</div>

			<div id="result_content" class="modal-body">
				<p></p>
			</div>

			<div class="modal-footer">
				<button type="button" id="close" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- End modal-content -->
	</div>
	<!-- End modal-dialog -->
</div>
<!-- End modal -->

<!-- 	Confirm popup -->
<div id="confirm_modal" class="modal fade">
	<div id="modal-dialog" class="modal-dialog message-modal">
		<div id="modal-content" class="modal-content">

			<div class="modal-header" id="confirm_modal_header">
				<button type="button" id="close_ico" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="confirm_title">Confirm</h4>
			</div>

			<div id="confirm_content" class="modal-body"></div>

			<div class="modal-footer">
				<button type="button" id="confirm-btn" class="btn btn-primary ok_btn">OK</button>
				<button type="button" id="close" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
		<!-- End modal-content -->
	</div>
	<!-- End modal-dialog -->
</div>
<!-- End modal -->

<div id="input_modal" class="modal fade">
	<div id="modal-dialog" class="modal-dialog message-modal">
		<div id="" class="modal-content">

			<div class="modal-header" id="input_modal_header">
				<button type="button" id="" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="">User PIN required</h4>
			</div>

			<div id="input_modal_content" class="modal-body"></div>

			<div class="modal-footer">
				<button type="button" id="" class="btn btn-primary ok_btn">OK</button>
				<button type="button" id="" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
		<!-- End modal-content -->
	</div>
	<!-- End modal-dialog -->
</div>
<!-- End modal -->

	<!-- 	Result popup -->

	<%@include file="../common/loading/loading.jsp"%>

<style>
.hightlight {
	background-color: #ff8000;
}

#list-cert tr:HOVER {
	cursor: pointer;
	background-color: #ebebeb;
}

.hightlight:HOVER {
	background-color: #ff8000;
}
#error{
	color: red;
    font-size: 12px;
}
.spinner_03-loader {
	display: none;
}
</style>
<div id="cert_chooser" class="modal fade">
	<div id="modal-dialog" class="modal-dialog">
		<div id="modal-content" class="modal-content">

			<div class="modal-header" id="result_modal_header">
				<button type="button" id="close_ico" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="">Chọn chữ ký số để ký</h4>
			</div>

			<div id="result_content" class="modal-body">
				<table id="list-cert-tbl" class="table">
					<thead>
						<tr>
							<th class="">#</th>
							<th class="">Chủ sở hữu</th>
							<th class="">Cấp bởi</th>
							<th class="">Số Serial</th>
							<th class="">Hạn dùng</th>
						</tr>
					</thead>
					<tbody id="list-cert">

					</tbody>
				</table>
			</div>

			<div class="modal-footer">
				<span id="error"></span>
				<style>
.spinner_03-loader {
	position: relative;
	left: calc(50% - 13px);
	width: 26px;
	height: 26px;
	border-radius: 50%;
		-o-border-radius: 50%;
		-ms-border-radius: 50%;
		-webkit-border-radius: 50%;
		-moz-border-radius: 50%;
	perspective: 320px;
    float: left;
    top: 5px;
    left: 0px;
}

.spinner_03-inner {
	position: absolute;
	width: 100%;
	height: 100%;
	box-sizing: border-box;
		-o-box-sizing: border-box;
		-ms-box-sizing: border-box;
		-webkit-box-sizing: border-box;
		-moz-box-sizing: border-box;
	border-radius: 50%;
		-o-border-radius: 50%;
		-ms-border-radius: 50%;
		-webkit-border-radius: 50%;
		-moz-border-radius: 50%;	
}

.spinner_03-inner.spinner_03-one {
	left: 0%;
	top: 0%;
	animation: spinner_03-rotate-one 1.15s linear infinite;
		-o-animation: spinner_03-rotate-one 1.15s linear infinite;
		-ms-animation: spinner_03-rotate-one 1.15s linear infinite;
		-webkit-animation: spinner_03-rotate-one 1.15s linear infinite;
		-moz-animation: spinner_03-rotate-one 1.15s linear infinite;
	border-bottom: 1px solid rgb(69,182,176);
}

.spinner_03-inner.spinner_03-two {
	right: 0%;
	top: 0%;
	animation: spinner_03-rotate-two 1.15s linear infinite;
		-o-animation: spinner_03-rotate-two 1.15s linear infinite;
		-ms-animation: spinner_03-rotate-two 1.15s linear infinite;
		-webkit-animation: spinner_03-rotate-two 1.15s linear infinite;
		-moz-animation: spinner_03-rotate-two 1.15s linear infinite;
	border-right: 1px solid rgb(69,182,176);
}

.spinner_03-inner.spinner_03-three {
	right: 0%;
	bottom: 0%;
	animation: spinner_03-rotate-three 1.15s linear infinite;
		-o-animation: spinner_03-rotate-three 1.15s linear infinite;
		-ms-animation: spinner_03-rotate-three 1.15s linear infinite;
		-webkit-animation: spinner_03-rotate-three 1.15s linear infinite;
		-moz-animation: spinner_03-rotate-three 1.15s linear infinite;
	border-top: 1px solid rgb(69,182,176);
}







@keyframes spinner_03-rotate-one {
	0% {
		transform: rotateX(35deg) rotateY(-45deg) rotateZ(0deg);
	}
	100% {
		transform: rotateX(35deg) rotateY(-45deg) rotateZ(360deg);
	}
}

@-o-keyframes spinner_03-rotate-one {
	0% {
		-o-transform: rotateX(35deg) rotateY(-45deg) rotateZ(0deg);
	}
	100% {
		-o-transform: rotateX(35deg) rotateY(-45deg) rotateZ(360deg);
	}
}

@-ms-keyframes spinner_03-rotate-one {
	0% {
		-ms-transform: rotateX(35deg) rotateY(-45deg) rotateZ(0deg);
	}
	100% {
		-ms-transform: rotateX(35deg) rotateY(-45deg) rotateZ(360deg);
	}
}

@-webkit-keyframes spinner_03-rotate-one {
	0% {
		-webkit-transform: rotateX(35deg) rotateY(-45deg) rotateZ(0deg);
	}
	100% {
		-webkit-transform: rotateX(35deg) rotateY(-45deg) rotateZ(360deg);
	}
}

@-moz-keyframes spinner_03-rotate-one {
	0% {
		-moz-transform: rotateX(35deg) rotateY(-45deg) rotateZ(0deg);
	}
	100% {
		-moz-transform: rotateX(35deg) rotateY(-45deg) rotateZ(360deg);
	}
}

@keyframes spinner_03-rotate-two {
	0% {
		transform: rotateX(50deg) rotateY(10deg) rotateZ(0deg);
	}
	100% {
		transform: rotateX(50deg) rotateY(10deg) rotateZ(360deg);
	}
}

@-o-keyframes spinner_03-rotate-two {
	0% {
		-o-transform: rotateX(50deg) rotateY(10deg) rotateZ(0deg);
	}
	100% {
		-o-transform: rotateX(50deg) rotateY(10deg) rotateZ(360deg);
	}
}

@-ms-keyframes spinner_03-rotate-two {
	0% {
		-ms-transform: rotateX(50deg) rotateY(10deg) rotateZ(0deg);
	}
	100% {
		-ms-transform: rotateX(50deg) rotateY(10deg) rotateZ(360deg);
	}
}

@-webkit-keyframes spinner_03-rotate-two {
	0% {
		-webkit-transform: rotateX(50deg) rotateY(10deg) rotateZ(0deg);
	}
	100% {
		-webkit-transform: rotateX(50deg) rotateY(10deg) rotateZ(360deg);
	}
}

@-moz-keyframes spinner_03-rotate-two {
	0% {
		-moz-transform: rotateX(50deg) rotateY(10deg) rotateZ(0deg);
	}
	100% {
		-moz-transform: rotateX(50deg) rotateY(10deg) rotateZ(360deg);
	}
}

@keyframes spinner_03-rotate-three {
	0% {
		transform: rotateX(35deg) rotateY(55deg) rotateZ(0deg);
	}
	100% {
		transform: rotateX(35deg) rotateY(55deg) rotateZ(360deg);
	}
}

@-o-keyframes spinner_03-rotate-three {
	0% {
		-o-transform: rotateX(35deg) rotateY(55deg) rotateZ(0deg);
	}
	100% {
		-o-transform: rotateX(35deg) rotateY(55deg) rotateZ(360deg);
	}
}

@-ms-keyframes spinner_03-rotate-three {
	0% {
		-ms-transform: rotateX(35deg) rotateY(55deg) rotateZ(0deg);
	}
	100% {
		-ms-transform: rotateX(35deg) rotateY(55deg) rotateZ(360deg);
	}
}

@-webkit-keyframes spinner_03-rotate-three {
	0% {
		-webkit-transform: rotateX(35deg) rotateY(55deg) rotateZ(0deg);
	}
	100% {
		-webkit-transform: rotateX(35deg) rotateY(55deg) rotateZ(360deg);
	}
}

@-moz-keyframes spinner_03-rotate-three {
	0% {
		-moz-transform: rotateX(35deg) rotateY(55deg) rotateZ(0deg);
	}
	100% {
		-moz-transform: rotateX(35deg) rotateY(55deg) rotateZ(360deg);
	}
}
.spinner_03-legend{
    margin-left: 30px;
    display: inline;
    line-height: 26px;
    font-size: 11px;
    color: rgb(69,182,176);
}
</style>

<div class="spinner_03-loader">
	<div class="spinner_03-inner spinner_03-one"></div>
	<div class="spinner_03-inner spinner_03-two"></div>
	<div class="spinner_03-inner spinner_03-three"></div>
	<span class="spinner_03-legend">Processing...</span>
</div>
				<button type="button" id="select" class="btn btn-default">Chọn</button>
			</div>
		</div>
		<!-- End modal-content -->
	</div>
	<!-- End modal-dialog -->
</div>
<!-- End modal -->

	<%@include file="../common/enterpinmobile/enterpinmobile.jsp"%>
	<%@include file="../common/choosecerforsign/choosecerforsign.jsp"%>
<script>

</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/stock/res/jspdf.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/stock/res/jspdf.plugin.standard_fonts_metrics.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/stock/res/jspdf.plugin.split_text_to_size.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/stock/res/jspdf.plugin.from_html.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/stock/res/jquery.base64.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/stock/res/Base64.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/stock/res/FileSaver.js"></script>

	<script src="${pageContext.request.contextPath}/stock/res/jspdf.min.js"></script>
	<script src="${pageContext.request.contextPath}/stock/res/jspdf.plugin.autotable.js"></script>
	<script src="${pageContext.request.contextPath}/stock/res/bkav-extension-signer-v2.0.js"></script>
	<script src="${pageContext.request.contextPath}/stock/res/Utils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/stock/res/home.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/stock/res/modal.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/stock/res/stockmarket.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/bkav-signer-extension-2.0/bkav-signer-plugin.js"></script>	
	<script type="text/javascript">
		var test = new ObjPdfSigner();
	</script>
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	
	var licenseKey = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+PExpY2Vuc2UgaWQ9IkwwMDEiPjxUZW5QaGFuTWVtPkJrYXZDQSBTaWduZXIgUGx1Z2luPC9UZW5QaGFuTWVtPjxOZ3VvaUNhcD5Ca2F2IENvcnBvcmF0aW9uPC9OZ3VvaUNhcD48RG9uVmlEdW9jQ2FwPkJrYXYgQ0E8L0RvblZpRHVvY0NhcD48SGFuU3VEdW5nPjxOZ2F5Q2FwPjI4LTAyLTIwMTc8L05nYXlDYXA+PE5nYXlIZXRIYW4+MzEtMTItMjAxNzwvTmdheUhldEhhbj48L0hhblN1RHVuZz48UXV5ZW5TdUR1bmc+PFVuZ0R1bmc+KjwvVW5nRHVuZz48TW9kdWxlWE1MPjE8L01vZHVsZVhNTD48TW9kdWxlUERGPjE8L01vZHVsZVBERj48TW9kdWxlT09YTUw+MTwvTW9kdWxlT09YTUw+PE1vZHVsZUNNUz4xPC9Nb2R1bGVDTVM+PE1vZHVsZUNlcnRpZmljYXRlVXRpbHM+MTwvTW9kdWxlQ2VydGlmaWNhdGVVdGlscz48L1F1eWVuU3VEdW5nPjxTaWduYXR1cmUgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPjxTaWduZWRJbmZvPjxDYW5vbmljYWxpemF0aW9uTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvVFIvMjAwMS9SRUMteG1sLWMxNG4tMjAwMTAzMTUjV2l0aENvbW1lbnRzIi8+PFNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNyc2Etc2hhMSIvPjxSZWZlcmVuY2UgVVJJPSIiPjxUcmFuc2Zvcm1zPjxUcmFuc2Zvcm0gQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjZW52ZWxvcGVkLXNpZ25hdHVyZSIvPjwvVHJhbnNmb3Jtcz48RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI3NoYTEiLz48RGlnZXN0VmFsdWU+MTVoL013N0EzYnNGNVlLTWkrSGxFcE5VNXpzPTwvRGlnZXN0VmFsdWU+PC9SZWZlcmVuY2U+PC9TaWduZWRJbmZvPjxTaWduYXR1cmVWYWx1ZT5WbXhhNDN5R2FzNTh4YW50WjFhR0RsbmtvQitsM2RVUWk1SzErbkd0Q2hnWDJIVUppOE1SbEJCaHNjZU5KeGxJTXRoYmFDTUJaWm0xDQpNM1p3OC9BSmh3citEVGRoV1hjV1ZQQU9hMHNRNEdIdmRFTHdpbzkrQXJtclJ2cVRTZjlNSnROSUlXbVhGd1BZZkdNY1YybzdpQ0htDQpoeW1LeVdhZE0xOExsNDZFaklwS21ldm9QYTVNNW01ZEFLY3JWeDZ2M3JlMm1YcjRiazY0ZlZBZFkzbDVrZXpWYzdzRnc4MHhTMG5TDQp2ZUozblcwTWtuSk5VeUU2QUtJZ0N5MStoTmVCL2Y0UlZjK2lCYTVuOThEN2dmTFIzSnFRVVhlREQ4QzQ0TldkbUFySzQwYjI2Ym42DQpLK1hZdXA5c2pQZ0EvT01lYko4RGw0RUI0T1Bqd0dRbmIxRCtBQT09PC9TaWduYXR1cmVWYWx1ZT48S2V5SW5mbz48WDUwOURhdGE+PFg1MDlTdWJqZWN0TmFtZT5DPVZOLFNUPUjDoCBO4buZaSxMPUPhuqd1IEdp4bqleSxPPUPDtG5nIHR5IEPhu5UgcGjhuqduIEJrYXYsT1U9QmFuIEFOTSxDTj1Ca2F2Q0EgTGljZW5zZSxVSUQ9TVNUOjAxMDEzNjA2OTctQmthdkNBTGljZW5zZTwvWDUwOVN1YmplY3ROYW1lPjxYNTA5Q2VydGlmaWNhdGU+TUlJRXpEQ0NBN1NnQXdJQkFnSVFWQU5EUEJrL0NacG0zcE5kSUJZdWhUQU5CZ2txaGtpRzl3MEJBUVVGQURCSk1Rc3dDUVlEVlFRRw0KRXdKV1RqRU9NQXdHQTFVRUJ4TUZTR0Z1YjJreEdUQVhCZ05WQkFvVEVFSnJZWFlnUTI5eWNHOXlZWFJwYjI0eER6QU5CZ05WQkFNVA0KQmtKcllYWkRRVEFlRncweE5qQTFNekF3TkRBeE1EUmFGdzB4T0RBM01qa3dOREF4TURSYU1JRzFNU3d3S2dZS0NaSW1pWlB5TEdRQg0KQVF3Y1RWTlVPakF4TURFek5qQTJPVGN0UW10aGRrTkJUR2xqWlc1elpURVhNQlVHQTFVRUF3d09RbXRoZGtOQklFeHBZMlZ1YzJVeA0KRURBT0JnTlZCQXNNQjBKaGJpQkJUazB4SWpBZ0JnTlZCQW9NR1VQRHRHNW5JSFI1SUVQaHU1VWdjR2podXFkdUlFSnJZWFl4RlRBVA0KQmdOVkJBY01ERVBodXFkMUlFZHA0YnFsZVRFU01CQUdBMVVFQ0F3SlNNT2dJRTdodTVscE1Rc3dDUVlEVlFRR0V3SldUakNDQVNJdw0KRFFZSktvWklodmNOQVFFQkJRQURnZ0VQQURDQ0FRb0NnZ0VCQUlEblEwQUd5Z2doM0x6SElxcHFBOExSTi9jcE1Ea1dRSWxQNmI4cg0KS0MvQW5HcTRieGF3TkZuRld6NDZ3aTdTVm9MYnI2NUNLZWY4Q0owSUtCbEtEVVlmY1R1VVk2MTRENDRrcTI0b1pNVW9NZnkwQ3ZtZQ0Kd2lPOEw1d0p4eU1zSU0zTjVQMUFVcEVPTkdEN1A3ZG5iUzRBQ3B6RHZkcDFlMGZSOXVTbjV4STc1bThMVGcwRG00VW9DWUtCWk5TVw0KajlINE5vOFduNEYxV0N5UW9xWGNCK1RSZlVWUi83VXBmNGFvczk3Q1VWdmRHd1dsVXV5QnhHK3FNWGk3YWZVd21ZVk1valRYbFFVYQ0KeEFMVEFKam5WLy9hdGtzaEMvejczYmRodlh6NHAwNWMwQ29wVDZQTGF0bERsd0VFMXA1NFZPZlBod2hNVVgzOWRQcmM4enErczBzQw0KQXdFQUFhT0NBVUV3Z2dFOU1ERUdDQ3NHQVFVRkJ3RUJCQ1V3SXpBaEJnZ3JCZ0VGQlFjd0FZWVZhSFIwY0RvdkwyOWpjM0F1WW10aA0KZG1OaExuWnVNQjBHQTFVZERnUVdCQlFqRlkwT3ZoV2prWWNEN25uMnpBdzZBbXZ1NFRBTUJnTlZIUk1CQWY4RUFqQUFNQjhHQTFVZA0KSXdRWU1CYUFGQjZ3RDBpWDM5RERaNmRHaER0WU80Z05VNVNHTUg4R0ExVWRId1I0TUhZd2RLQWpvQ0dHSDJoMGRIQTZMeTlqY213dQ0KWW10aGRtTmhMblp1TDBKcllYWkRRUzVqY215aVRhUkxNRWt4RHpBTkJnTlZCQU1NQmtKcllYWkRRVEVaTUJjR0ExVUVDZ3dRUW10aA0KZGlCRGIzSndiM0poZEdsdmJqRU9NQXdHQTFVRUJ3d0ZTR0Z1YjJreEN6QUpCZ05WQkFZVEFsWk9NQTRHQTFVZER3RUIvd1FFQXdJRg0Kb0RBcEJnTlZIU1VFSWpBZ0JnZ3JCZ0VGQlFjREFRWUlLd1lCQlFVSEF3SUdDaXNHQVFRQmdqY0tBd3d3RFFZSktvWklodmNOQVFFRg0KQlFBRGdnRUJBQy9GSDM1dE8wZHlBVXZwcEJCaWRFOXNUY2EvMkZMK3lCUDFkUFVncHRKVGMwZmJsamU2cS9HanF4SThYckU1K3piZg0KaVBJUTkrd3VIV29VcFBac3RkMUloTlJjQmZXb2JvK1d4RDNLYVhiVWUvSkZDUWpTaGpVTnMzMWNrQVBpMTJSSEs3Uldzazhsdm5HWA0KN0FjUitNeG5uZEVHZjhtZDJYcll3U3d3cGJqYnV0R1J4d3YyZUVMLzZWTUZYbUJjOGZQSytEaW4yNGFTVldPTTlXTlNtWmtYMWJCeg0Ka0lWTDdlYlpKd1p4VDBJSlZiYXg3ZGdFNVdoTW9sa3pZVjR5dStsbFN0aEFrbnBDTkM4TVVxc29kRHNIbWlGWHNTOWwyUGZEYWdYNA0KSDJ6SkJISUhKdG5HKzRBUFh6Rys2WSthMmdoKzMrRWJaTDRscEc2NWtBQnJVbXM9PC9YNTA5Q2VydGlmaWNhdGU+PFg1MDlDZXJ0aWZpY2F0ZT5NSUlFTnpDQ0F4K2dBd0lCQWdJS1lRcnhWQUFBQUFBQUR6QU5CZ2txaGtpRzl3MEJBUVVGQURCK01Rc3dDUVlEVlFRR0V3SldUakV6DQpNREVHQTFVRUNoTXFUV2x1YVhOMGNua2diMllnU1c1bWIzSnRZWFJwYjI0Z1lXNWtJRU52YlcxMWJtbGpZWFJwYjI1ek1Sc3dHUVlEDQpWUVFMRXhKT1lYUnBiMjVoYkNCRFFTQkRaVzUwWlhJeEhUQWJCZ05WQkFNVEZFMUpReUJPWVhScGIyNWhiQ0JTYjI5MElFTkJNQjRYDQpEVEUxTURVeE5UQXpNalUwT0ZvWERUSXdNRFV4TlRBek16VTBPRm93U1RFTE1Ba0dBMVVFQmhNQ1ZrNHhEakFNQmdOVkJBY1RCVWhoDQpibTlwTVJrd0Z3WURWUVFLRXhCQ2EyRjJJRU52Y25CdmNtRjBhVzl1TVE4d0RRWURWUVFERXdaQ2EyRjJRMEV3Z2dFaU1BMEdDU3FHDQpTSWIzRFFFQkFRVUFBNElCRHdBd2dnRUtBb0lCQVFERGpZeTJCem81cjMzdmx3WVRwN3F4V3g0ZHBmcGl6YWY2ZVE2eHpFRFBlUlFODQpqbW1XNi9SRmczZDF0djhrY1NXV3g2S2h1bUlMenpaZHZmRVJYTWtRcFRHdWVxcTM1ekc3ZDlHVWxrbUlWRHljUTRWd3ZveHE5TVRXDQpObnJRc1luL0FScWl4MXVFMFpPc1lueWMzY2NTaTByS1prZ09yeUJHWFVka211ekhPMVhNazhJR04yQUxoZzBJcjBsWStEZENtNHRlDQplYXNiMHNZZGNiVUR3SEpQdGcxa0VKZTFUMm1YU3dZQ05IQnY3TGc3aW5DK0FSZnhvQzBBbGFIYVpVUHpISEJtV3R5SlIyV0h3dVlwDQpETUU0Um04Tkp1MG9mRzdCK05uWmdxMXMyYUdLWG00Y3g0RTk1eFBKbnZLM2U2d25qeGFBNS8zWENaYS9HV1FsQlJJMUFnTUJBQUdqDQpnZXN3Z2Vnd0VnWURWUjBUQVFIL0JBZ3dCZ0VCL3dJQkFEQUxCZ05WSFE4RUJBTUNBWVl3SFFZRFZSME9CQllFRkI2d0QwaVgzOUREDQpaNmRHaER0WU80Z05VNVNHTUI4R0ExVWRJd1FZTUJhQUZNMWljZVJodmY0OTdMSkFZTk9CZGQwNnJHdkdNRHdHQTFVZEh3UTFNRE13DQpNYUF2b0MyR0syaDBkSEE2THk5d2RXSnNhV011Y205dmRHTmhMbWR2ZGk1MmJpOWpjbXd2YldsamJuSmpZUzVqY213d1J3WUlLd1lCDQpCUVVIQVFFRU96QTVNRGNHQ0NzR0FRVUZCekFDaGl0b2RIUndPaTh2Y0hWaWJHbGpMbkp2YjNSallTNW5iM1l1ZG00dlkzSjBMMjFwDQpZMjV5WTJFdVkzSjBNQTBHQ1NxR1NJYjNEUUVCQlFVQUE0SUJBUUJVZVVtdXIra2I4cFpVb3ZpcFNickhUVE4xWGl6UUlYYWtsNG9YDQpaVkZPcHphVE5uU1FXTk5BbzZNY1VORjJOTDFxNHhHZUZjcWJud2MxZFlHamFqcngwU2ZhS28yRmtiaDY1NldieEdUMW1xRS91d2orDQp4cyt6OWRnY3JMK3pTU1QraEdrYXVjdGFBSktMWlRZQWJTSC80VjFlZGRDN2UwYlBJVm81aW5OWVJpdlB5MU1JdXc0TkZHaDlzOG1sDQpuc1A2YmlXMGh0OGVybk14NVlIblFmd2RNK0srYXJ6ZGlKREx6ck5QUmZvN2dTeTUwYzNrSmpmVUZZeGJTZGdUVVhDRERXN240eFk1DQpvdFBOOEJOQ0EyVERiYkhzbWJKWHYzUmE1QjJyZTczNGIwRlBtenoxQmFuWU9hbTJOQW83K3lINzVjSmhZaWVKUjZOc3dzaGRrU3pDPC9YNTA5Q2VydGlmaWNhdGU+PFg1MDlDZXJ0aWZpY2F0ZT5NSUlEMXpDQ0FyK2dBd0lCQWdJUUcrUnppaDgrd0k5SG42YlBOY1dZSWpBTkJna3Foa2lHOXcwQkFRVUZBREIrTVFzd0NRWURWUVFHDQpFd0pXVGpFek1ERUdBMVVFQ2hNcVRXbHVhWE4wY25rZ2IyWWdTVzVtYjNKdFlYUnBiMjRnWVc1a0lFTnZiVzExYm1sallYUnBiMjV6DQpNUnN3R1FZRFZRUUxFeEpPWVhScGIyNWhiQ0JEUVNCRFpXNTBaWEl4SFRBYkJnTlZCQU1URkUxSlF5Qk9ZWFJwYjI1aGJDQlNiMjkwDQpJRU5CTUI0WERUQTRNRFV4TmpBeE1USTBPVm9YRFRRd01EVXhOakF4TWpBek1sb3dmakVMTUFrR0ExVUVCaE1DVms0eE16QXhCZ05WDQpCQW9US2sxcGJtbHpkSEo1SUc5bUlFbHVabTl5YldGMGFXOXVJR0Z1WkNCRGIyMXRkVzVwWTJGMGFXOXVjekViTUJrR0ExVUVDeE1TDQpUbUYwYVc5dVlXd2dRMEVnUTJWdWRHVnlNUjB3R3dZRFZRUURFeFJOU1VNZ1RtRjBhVzl1WVd3Z1VtOXZkQ0JEUVRDQ0FTSXdEUVlKDQpLb1pJaHZjTkFRRUJCUUFEZ2dFUEFEQ0NBUW9DZ2dFQkFLRS9XVkVPL2pEL1lkdVdlQlNMMjBNOE5yNWhyOXkxUDJBZTB3MEJRYTM0DQp5WXBDanNqdE1vWkh4ZjYxOStyV1JEY1FFc05JQ0ZGUXV1Vlg2YzQxeVk0Y2N3bUZNMHpodXppc2pxMjNFd1F1Wm9GWExjejdHdjB1DQpuSXY5Q1VEd1lCZWJjVVZ0ZmVQYkt0SzdtdDNyekY3a0FOL1ZiRENGbTcxWGZ5M1VKTk9BKytBb1ViNncxbUVIek9XZ1IrZVJiUytIDQpXT2kwcmNHeFJyUGNXaDA0Q2RuN3RTZVlubDc4OGZSSS8raWhPLzlRTTlrbXE3S1pZcDNNZThoU1RaNWNRb3R2ZEg3OGxCUGVDdEx3DQp0V3I0bGt4UW5PWWhqc0hsbHdGT3paK3dRQmw4RzFsdlhEZ1ptamZhMFlFNUZqTHZnYTJ3SVdzUmw4TEJDTDF2STF3RUQ5TUNBd0VBDQpBYU5STUU4d0N3WURWUjBQQkFRREFnR0dNQThHQTFVZEV3RUIvd1FGTUFNQkFmOHdIUVlEVlIwT0JCWUVGTTFpY2VSaHZmNDk3TEpBDQpZTk9CZGQwNnJHdkdNQkFHQ1NzR0FRUUJnamNWQVFRREFnRUFNQTBHQ1NxR1NJYjNEUUVCQlFVQUE0SUJBUUJNbmMxK0l5Q0FIQ2pQDQo4UEhKM3hIS3NtbFRvL0pmRExObG5DOVU0UnhRS3VCVkY4UVh2cWlUVVVhcWh1MGtaQzlQRTQ2d3RCU2NmRU8rTFU1alVtemIxbkFYDQpXVWRib2xxeng1WjZ0ZzMxTFEzWlpEcXYwRlE2MFJOb3R2bzREZ1hyNFB3dzkweWJYK0x1WjN2NFl1cDByM0pVVE5UNlhvdnM2N2duDQpnU3lZanZmS29GR1djOFlYaWZuMFU1Yy9WOFBiVlNoSmMwOUtOeXBuaE1VVHZzYko3Z2xIWXIrb3N1cDg1VjhrMnp1NGREV3c0WVdQDQppcGRJanVkNFo0bkw1YVFDN0Z0WG9ibkhscmZCNmVWZGpwbW1weVdhSGJETzFqdHJNL0srU2VFdDFvZUJ1WGF1cC96TnM4WjJNcTlODQpVRkpzTFEyeXZkZFE1ZE4xWTU5ZHpRcVo8L1g1MDlDZXJ0aWZpY2F0ZT48L1g1MDlEYXRhPjwvS2V5SW5mbz48L1NpZ25hdHVyZT48L0xpY2Vuc2U+";
	var certSerial = "";
	var base64ToSign = "";
	var dateTransaction = "";
	
		$(document).ready(function(){
			document.addEventListener(EXTENSION_EVENT_NAME.SIGN_XML_BASE64, function (data) {

				$body.removeClass("loading");
				
			    var result = document.getElementById('hrSignedData').value; // lấy kết quả.				
				console.log(result);
				switch (result) {
				case "Mw==":
					error("Giao dịch không thành công. Không tìm thấy cert trong windows store");
					break;
				case "NA==":
					error("Giao dịch không thành công. Dữ liệu xml không đúng chuẩn hoặc không tìm thấy file cần ký");
					break;
				case "NQ==":
					error("Giao dịch không thành công. Lỗi trong quá trình ký.");
					break;
				case "Ng==":
					error("Giao dịch không thành công. Lỗi trong quá trình lưu dữ liệu đã ký.");
					break;
				case "MTM=":
					error("Giao dịch không thành công. Người dùng hủy bỏ nhập mã PIN.");
					break;
				case "Nw==":
					error("Giao dịch không thành công. Người dùng chưa cắm USB Token");
					break;
				case "MA==":
					error("Giao dịch không thành công. Lỗi Plugin");
					break;				
				default:
					var jsonData = {
						transactionTime: dateTransaction,
						clientDataSigned: result
					};

					$.extend(jsonData, $("#dataToInsertStock").data());
					console.log(jsonData);

					// Send ajax to create stock to DB
					$.ajax({
						type: "POST",
						url: "AddStock",
						data: jsonData,
						dataType: "json",
						cache: false,
						success: function(dataResponse) {
							var json = dataResponse;
							if (typeof(json) != "object")
								json = JSON.parse(dataResponse);
							
							if (json.status) {
								var tr = $("#list-trans tr:first");
								removeTransaction(tr);
								message("Giao dịch thành công!");
							} else
								message("Giao dịch không thành công, lỗi: " + json.message);
						},
						error: function(xhr, status, errors) {
							message("Giao dịch không thành công, lỗi: " + errors);
						}
					});
					break;
				}
			});
		});

		function submmitTransaction(serialNumber) {
			
			base64ToSign = Base64.encode(createXMLTransaction());
			if (serialNumber === undefined || serialNumber === "" ) {
				error("Bạn chưa đăng ký chữ ký số!");
				return 0;
			}
			
			if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent) 
				    || /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,4))) {
				$("#confirm_modal_pin").modal('show');
				/* signXMLMobile(serialNumber, base64ToSign); */
			} else {
				$body.addClass("loading");
				signXML(serialNumber, base64ToSign);
			}		
		}

		$(".btn-close-popup").click(function(){
			error("Giao dịch không thành công. Người dùng hủy bỏ giao dịch");
		});	

		$("#select_cert-refresh").click(function(){
			$('#cert_register').modal('hide');
			var serialNumber = $("#select_cert_list").val();
			submmitTransaction(serialNumber);
		});

		$("#send_tran").click(function() {

			var tranType = $("#c_tran_type").text();

			if (tranType === "" || tranType === undefined) {
				error("Bạn chưa thực hiện ghi lệnh!");
				return 0;
			}

			$("#label-header-cert-register").text("Chọn chữ ký số để giao dịch");
			$("#select_cert-refresh").text("Giao dịch");
			$('#cert_register').modal('show');
				
		});

		//mobile
		
		$("#btn-confirm-pin").click(function() {
			var pinEtoken = $("#pin-etoken").val();
			if (pinEtoken != "") {
				signXMLMobile(pinEtoken, certSerial, base64ToSign);			
			  } else {
				  
				  error("Giao dịch không thành công. Sai mã PIN.");
			  }

			pinEtoken = "";
		});
		
		$("#btn-cancel-pin").click(function() {
			
			error("Giao dịch không thành công. Người dùng hủy bỏ nhập mã PIN.");
		});	

		function SignXMlCallbackMobile(data) {

			message("Giao dịch thành công!");
			/* console.log(data); */
			/* message(Base64.decode(data)); */			
		}

		function signXMLMobile(pinEtoken, serial, base64ToSign) {
		
			  if (pinEtoken != null) {
				  var objCert = new ObjCertificate();
				  objCert.CertificateSerialNumber = serial;
				  objCert.PIN = pinEtoken;
				  BkavBChromeCA.SignXML(base64ToSign, objCert, SignXMlCallbackMobile);		
			  } else {
				  error("Giao dịch không thành công. Sai mã PIN.");
			  }						  			
		}

		
		// hàm ký xml 
		function signXML(serial, base64ToSign) {		    
		    var b64 = base64ToSign;
		    var tagSigning = "";
		    var nodeTosign = "";
		    var tagSaveResult = "";
		    var serial = serial;
		    var dllName = "bkavcaetoken,bkavcsp,BkavCA,BkavCAv2S";
		    try {
		        // object XML
		        var objXml = new ObjXmlSigner();
		        objXml.Base64String = b64;
		        objXml.CertificateSerialNumber = serial;
		   		// ky voi dau vao Base64
		        objXml.SigningType = XML_SIGNING_TYPE.SIGN_XML_BASE64; 
		        BkavExtensionSigner.SetLicenseKey(licenseKey);
		        
		        // kiêm tra trình duyệt: nếu iCheck = 1 thì trình duyệt đang sử dụng là Chrome 
		        var iCheck = checkBrowser();       // kiểm tra trình duyệt
		        if (iCheck == 1) {
					// các hàm tương ứng với trình duyệt Chrome
				
		        	BkavExtensionSigner.SetPINCache(false, false, 0);
		        	BkavExtensionSigner.SetAESKey("TEST"); 
		        	BkavExtensionSigner.SetUsePKCS11(SET_USE_PKCS11.YES);
		        	BkavExtensionSigner.SetDLLName(dllName);			
					BkavExtensionSigner.SignXML(objXml); // doi voi Extension can bat su kien tuong ung de nhan lai ket qua
		        }
		        else {
				// các hàm tương ứng với trình duyệt FireFox, IE
		            var result = BkavPluginSigner.SignXML(objXml);
		        }
		    } catch (e) {
		        error(e);
		    }
		}




		function createXMLTransaction() {			
			var tranType = $("#c_tran_type").text();
			var stockName = $("#c_stock_name").text();
			var weigth = $("#c_weigth").text();
			var price = $("#c_price").text();
			dateTransaction = formatDate("dd/MM/yyyy HH:mm:ss", new Date());

			var xml = '<?xml version="1.0" encoding="UTF-8"?>'; 
			xml = xml + "<stockTransaction>";
			xml = xml + "<tranType>" + tranType + "</tranType>";
			xml = xml + "<weigth>" + weigth + "</weigth>";
			xml = xml + "<stockName>" + stockName + "</stockName>";
			xml = xml + "<price>" + price + "</price>";
			xml = xml + "<dateTransaction>" + dateTransaction + "</dateTransaction>";		
			xml = xml + "</stockTransaction>";					
			return xml;
		}

		function formatDate(pattern, date) {
			if (typeof(date) !== "object") {
				alert("Data required a Date.");
				return false;
			}
			switch(pattern) {
			case "dd/MM/yyyy HH:mm:ss":
				return _prependZero(date.getDate()) + "/" + _prependZero((date.getMonth() + 1)) + "/" + date.getFullYear() + " " + _prependZero(date.getHours()) + ":" + _prependZero(date.getMinutes()) + ":" + _prependZero(date.getSeconds());
				break;
			}
		}

		function _prependZero(num) {
			return num >= 10 ? num : "0" + num;
		}
	</script>
	
</body>
</html>