<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="Shortcut Icon"
	href="${pageContext.request.contextPath}/res/imgs/shortcut.ico">
<title>Bkav CA Core</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/css/bootstrap.min.css">
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/res/plugins/font-awesome-4.3.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/dashboard/dashboard.css">


<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/plugins/jquery-2.1.1/jquery.js"></script>

<style>

	/*-------------Desktop--------------*/
    #metro_box_1 {
      margin-left: 12.5%; width: 37%; height: 145px;
    }

    #metro_box_2 {
         margin-left: 51%; width: 37%; height: 145px; display: block;
    }

    #metro_box_3 {
        margin-left: 12.5%; width: 37%; height: 145px; margin-top:18%; display: block;
    }

    #metro_box_4 {
        margin-left:  51%; width: 37%; height: 145px; margin-top:18%; display: block;
    }
    

    /* ----------- CSS Responsive ----------- */
    
	@media screen and (max-width: 1024px){

	}
	
	@media screen and (max-width: 768px){

	}
	
	@media screen and (max-width: 680px){
		
	}
	
	@media only screen and (max-device-width: 480px) and (orientation: portrait) {
		
		#wrapper:before, #wrapper:after {
            content: "";
            display: table;
            clear: both;
        }

        .tileFlipText {        
/*             position: absolute;
            margin-left: auto;
            margin-right: auto; */
            margin-left: 20% !important;
            margin-right: 20% !important;
        }
        

 	    #metro_box_1 {
	      width: 60%; 
	      height: 245px;
	    }
	
	    #metro_box_2 {
	         width: 60%; height: 245px; margin-top: 31%;
	    }
	
	    #metro_box_3 {
	        width: 60%; height: 245px;  margin-top: 63%;
	    }
	
	    #metro_box_4 {
	        width: 60%; height: 245px; margin-top: 95%;
	    } 	

	}
     

</style>
</head>
<body>

 	<%@include file="../common/navbar/navbarDashboard.jsp"%>
 	

 	<img src="dashboard/img/background-image.jpg" alt="background-image" style="height: 100%; width: 100%; position: fixed;">
 
      <div id="wrapper" style="padding-top: 15%;">
       <div id="centerWrapper">
           <div id="tileContainer" class="" style="width: auto; height: auto; display: block; zoom: 1;">

			    <a href="SockMarket" class="tile tileFlipText vertical group0  support3D" 
			     style="" id="metro_box_1"> 
			
			        <div class="flipContainer">
			          <div class="flipFront" style="background: rgb(17, 82, 143)">
			            <h3>
			             <img title="" alt="" style="margin-top:0px;margin-left:0px;" src="dashboard/img/pen.png" height="60" width="60">
			             Chứng Khoán</h3></div>
			          <div class="flipBack" style="background:
			             rgb(15, 121, 218);"><h5>
			             <div style="font-weight: 300;font-size: 36px;padding:0 0 8px 0;color:#FFF;font-family: &#39;Just Another Hand&#39;, cursive;">
			             <img title="" alt="" style="position: relative;vertical-align: middle;top:0px;margin-right:10px;" src="dashboard/img/pen2.png" height="50" width="50">
			             Chứng Khoán</div></h5></div>
			
			         </div>
			     </a>
						
			    <a href="BankHome" class="tile tileFlipText vertical group0  support3D"
			    style="" id="metro_box_2"> 
			
			        <div class="flipContainer">
			          <div class="flipFront" style="background:#FF8000;">
			            <h3>
			             <img title="" alt="" style="margin-top:0px;margin-left:0px;" src="dashboard/img/pen2.png" height="60" width="60">
			             Ngân Hàng      </h3></div>
			             <div class="flipBack" style="background:
			             #FF3C00;"><h5><div style="font-weight: 300;font-size: 36px;padding:0 0 8px 0;color:#FFF;font-family: &#39;Just Another Hand&#39;, cursive;">
			             <img title="" alt="" style="position: relative;vertical-align: middle;top:0px;margin-right:10px;" src="dashboard/img/pen.png" height="50" width="50">
			             Ngân Hàng</div></h5></div>
			
			         </div>
			     </a>
			
   			    <a href="FileSign" class="tile tileFlipText vertical group0  support3D" 
 			     style="" id="metro_box_3">
			        <div class="flipContainer">
			          <div class="flipFront" style="background:#61b89c;">
			            <h3>
			             <img title="" alt="" style="margin-top:0px;margin-left:0px;" src="dashboard/img/pen2.png" height="60" width="60">
			             Ký Tập Tin</h3></div>
			             <div class="flipBack" style="background:
			             #31886c;"><h5><div style="font-weight: 300;font-size: 36px;padding:0 0 8px 0;color:#FFF;font-family: &#39;Just Another Hand&#39;, cursive;">
			             <img title="" alt="" style="position: relative;vertical-align: middle;top:0px;margin-right:10px;" src="dashboard/img/pen.png" height="50" width="50">
			            Ký Tập Tin</div></h5></div>
			         </div>
			    </a>
	
			    <a href="RegisterCertificate" class="tile tileFlipText vertical group0  support3D" 
			    	 id="metro_box_4">
			        <div class="flipContainer">
			          <div class="flipFront" style="background: #c94089;">
			            <h3>
			             <img title="" alt="" style="margin-top:0px;margin-left:0px;" src="dashboard/img/pen.png" height="60" width="60">
			             Thông tin CKS</h3></div>
			             <div class="flipBack" style="background:
			             #c875a1;"><h5><div style="font-weight: 300;font-size: 36px;padding:0 0 8px 0;color:#FFF;font-family: &#39;Just Another Hand&#39;, cursive;">
			             <img title="" alt="" style="position: relative;vertical-align: middle;top:0px;margin-right:10px;" src="dashboard/img/pen2.png" height="50" width="50">
			            Thông tin CKS</div></h5></div>
			         </div> 
			     </a>
			</div> 
			
		</div>
	</div>
	
	<script type="text/javascript">
		$("#brand-label").text("Bkav Core CA")
	</script>
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
</body>
</html>