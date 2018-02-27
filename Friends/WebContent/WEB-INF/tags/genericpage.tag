<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="title" fragment="true" %>
<html>
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.png">
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" type="text/css"/>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/jumbotron-narrow.css" type="text/css"/>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/friend.css" type="text/css"/>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/friend.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/alert.js"></script>
  	<title><jsp:invoke fragment="title"/></title>
  </head>
  <body>
  	<div class="container">
	    <div id="friend-header">
	      <jsp:invoke fragment="header"/>
	      <div class="header clearfix">
	          <!-- Static navbar -->
		      <nav class="navbar navbar-default">
		        <div class="container-fluid">
		          <div class="navbar-header">
		            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		              <span class="sr-only">Toggle navigation</span>
		              <span class="icon-bar"></span>
		              <span class="icon-bar"></span>
		              <span class="icon-bar"></span>
		            </button>
		            <a class="navbar-brand" href="${pageContext.request.contextPath}/manage">Friend</a>
		          </div>
		          <div id="navbar" class="navbar-collapse collapse">
		            <ul class="nav navbar-nav">
		              <li class="<c:choose><c:when test="${sessionScope.tabActive eq 'friend' }">active</c:when><c:otherwise></c:otherwise></c:choose>"><a href="${pageContext.request.contextPath}/manage">Friend</a></li>
		              <li class="<c:choose><c:when test="${sessionScope.tabActive eq 'group' }">active</c:when><c:otherwise></c:otherwise></c:choose>"><a href="${pageContext.request.contextPath }/group">Group</a></li>
		              <c:if test="${sessionScope.isAdmin eq true }">
		              	<li class="<c:choose><c:when test="${sessionScope.tabActive eq 'user' }">active</c:when><c:otherwise></c:otherwise></c:choose>"><a href="${pageContext.request.contextPath }/user">User</a></li>
		              </c:if>
		            </ul>
				    <div class="col-sm-3 col-md-4">
				        <form method="get" class="navbar-form" role="search">
					        <div class="input-group">
					            <input type="text" class="form-control" placeholder="Search" name="q" value="${requestScope.q }">
					            <div class="input-group-btn">
					                <button class="btn btn-default" style="padding: 9px 12px;" type="submit"><i class="glyphicon glyphicon-search"></i></button>
					            </div>
					        </div>
				        </form>
				    </div>
		            <ul class="nav navbar-nav navbar-right">
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Welcome <b>${sessionScope.user.username }</b> <span class="caret"></span></a>
				          <ul class="dropdown-menu">
				            <li><a href="#">View profile</a></li>
				            <li role="separator" class="divider"></li>
				            <li><a href="${pageContext.request.contextPath }/logout">Logout</a></li>
				          </ul>
				        </li>
				    </ul>
		          </div><!--/.nav-collapse -->
		        </div><!--/.container-fluid -->
		      </nav>
	      </div>
	    </div>
	    <div id="friend-body">
	    	<div class="row">
	      	<jsp:doBody/>
	      	</div>
	    </div>
	    <div id="friend-footer">
	      <jsp:invoke fragment="footer"/>
	      <footer class="footer">
	        <p>&copy; 2017 AUG.</p>
	      </footer>
	    </div>
    </div>
    <script type="text/javascript">
		$(document).ready(function() {
			$(window).on("load", function(e) {
				var actions = location.pathname.split("/");
				var action = actions[actions.length - 1];

				$("form[role='search']").attr("action", action);
			});
		});
    </script>
  </body>
</html>