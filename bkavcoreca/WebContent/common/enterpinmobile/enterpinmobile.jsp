<!-- 	Result popup -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

#error {
	color: red;
	font-size: 12px;
}

.spinner_03-loader {
	display: none;
}

.error {
	color: red;
}
#select_cert-refresh{
	margin-left: 20px;
}
</style>

<!-- 	Confirm popup -->
<div id="confirm_modal_pin" class="modal fade">
	<div id="modal-dialog" class="modal-dialog message-modal-pin">
		<div id="modal-content" class="modal-content">

			<div class="modal-header" id="confirm_modal_header">
				<h4 class="modal-title" id="confirm_title" style="text-align: center;">MÃ PIN</h4>
			</div>

			<div id="confirm_content" class="modal-body">
				<input style="width: 99%" id="pin-etoken" class="form-control" type="password">
			</div>

			<div class="modal-footer" style="text-align: center;">
				<button type="button" id="btn-confirm-pin" data-dismiss="modal"
					class="btn btn-primary">Xác nhận</button>
				<button type="button" id="btn-cancel-pin" class="btn btn-default"
					data-dismiss="modal">Bỏ qua</button>
			</div>
		</div>
		<!-- End modal-content -->
	</div>
	<!-- End modal-dialog -->
</div>
<!-- End modal -->

<script>
	
</script>