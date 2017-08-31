<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
	.modal-loading {
	    display:    none;
	    position:   fixed;
	    z-index:    1000;
	    top:        100px;
	    left:       0;
	    height:     100%;
	    width:      100%;
	    background: rgba( 255, 255, 255, .4)
	                url(common/loading/img/box.gif) 
	                50% 5% 
	                no-repeat;
	}

	body.loading {
	    overflow: hidden;   
	}

	/* Anytime the body has the loading class, our
	   modal element will be visible */
	body.loading .modal-loading {
	    display: block;
	}

</style>
	
<script>
	var $body = $("body");

</script>

<div class="modal-loading"><!-- Place at bottom of page --></div>