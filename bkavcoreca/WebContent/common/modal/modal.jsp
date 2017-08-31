<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<style>
@CHARSET "ISO-8859-1";

#modal-content {
	border-radius: 3px;
}

.message-modal {
	width: 425px !important;
}

.modal-body {
	/* 	background-color: #f5f5f5; */
	
}

.modal-footer {
	/* 	background-color: #f5f5f5; */
	
}

input[type="text"]{
	border-radius: 1px;
}
input[type="password"]{
	border-radius: 1px;
}
.btn{
	border-radius: 1px !important;
}


@media only screen and (max-device-width: 480px) and (orientation: portrait) {
	.message-modal {
		width: 80% !important;
	}
}
</style>	
<!-- 	Result popup -->
<div id="result_modal" class="modal fade">
	<div id="modal-dialog" class="modal-dialog message-modal">
		<div id="modal-content" class="modal-content">

			<div class="modal-header" id="result_modal_header">
				<button type="button" id="close_ico" class="close"
					data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="result_title"></h4>
			</div>

			<div id="result_content" class="modal-body">
				<p></p>
			</div>

			<div class="modal-footer">
				<button type="button" id="close" class="btn btn-default btn-reload"
					data-dismiss="modal">Close</button>
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
				<button type="button" id="close_ico" class="close"
					data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="confirm_title">Confirm</h4>
			</div>

			<div id="confirm_content" class="modal-body"></div>

			<div class="modal-footer">
				<button type="button" id="confirm-btn"
					class="btn btn-primary ok_btn">OK</button>
				<button type="button" id="close" class="btn btn-default"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>
		<!-- End modal-content -->
	</div>
	<!-- End modal-dialog -->
</div>
<!-- End modal -->

