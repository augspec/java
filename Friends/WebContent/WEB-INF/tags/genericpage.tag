<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="title" fragment="true" %>
<html>
  <head>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" type="text/css"/>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/friend.css" type="text/css"/>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/boostrap/js/bootstrap.min.js"></script>
  	<title><jsp:invoke fragment="title"/></title>
  </head>
  <body>
    <div id="friend-header">
      <jsp:invoke fragment="header"/>
      <h1>Friends Project</h1>
    </div>
    <div id="friend-body">
      <jsp:doBody/>
    </div>
    <div id="friend-footer">
      <jsp:invoke fragment="footer"/>
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </div>
  </body>
</html>