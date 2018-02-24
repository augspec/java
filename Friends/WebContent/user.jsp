<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:genericpage>
	<jsp:attribute name="title">User management</jsp:attribute>
	<jsp:attribute name="header"/>
    <jsp:attribute name="footer"/>
    <jsp:body>
        <div class="col-lg-12">
          <div style="margin-bottom: 20px;">
          	<select>
          		<option value="10">10</option>
          		<option value="20">20</option>
          		<option value="50">50</option>
          		<option value="100">100</option>
          	</select> items is display on page
          </div>
          <div class="panel panel-default">
			  <!-- Default panel contents -->
			  <div class="panel-heading">List of users</div>
			  <!-- Table -->
			  <table class="table">
			    <thead>
			    	<tr>
			    		<th>#</th>
			    		<th>Username</th>
			    		<th>Nicename</th>
			    		<th>Email</th>
			    		<th>Address</th>
			    		<th>Permission</th>
			    	</tr>
			    </thead>
			    <tbody>
			    	<c:forEach items="${requestScope.userList }" var="user" varStatus="status">
			    		<tr>
			    			<td>${status.count }</td>
			    			<td>${user.username }</td>
			    			<td>${user.nicename }</td>
			    			<td>${user.email }</td>
			    			<td>${user.address }</td>
			    			<td>${user.permission }</td>
			    		</tr>
			    	</c:forEach>
			    </tbody>
			  </table>
			</div>
			
			<nav aria-label="...">
			  <ul class="pager">
			    <li><a href="#">Previous</a></li>
			    <li><a href="#">Next</a></li>
			  </ul>
			</nav>
        </div>
        <script type="text/javascript">
			$(document).ready(function() {
				
			});
        </script>
    </jsp:body>
</t:genericpage>