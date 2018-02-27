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
          	<select name="itemsOnPage">
          		<option value="1" <c:choose><c:when test="${requestScope.itemsOnPage == 1 }">selected</c:when><c:otherwise></c:otherwise></c:choose>>10</option>
          		<option value="2" <c:choose><c:when test="${requestScope.itemsOnPage == 2 }">selected</c:when><c:otherwise></c:otherwise></c:choose>>20</option>
          		<option value="50" <c:choose><c:when test="${requestScope.itemsOnPage == 50 }">selected</c:when><c:otherwise></c:otherwise></c:choose>>50</option>
          		<option value="100" <c:choose><c:when test="${requestScope.itemsOnPage == 100 }">selected</c:when><c:otherwise></c:otherwise></c:choose>>100</option>
          	</select> items is display on page
          	<button class="btn btn-default btn-sm btn-primary" style="float: right;" data-toggle="modal" data-target="#modal-create-edit">Create new</button>
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
			${requestScope.pagination }
        </div>
        <!-- Modal -->
		<div class="modal fade" id="modal-create-edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Create new user</h4>
		      </div>
		      <div class="modal-body">
				  <div class="form-group">
				    <label for="txt-username">Username:</label>
				    <input type="text" class="form-control" id="txt-username">
				  </div>
				  <div class="form-group">
				    <label for="pwd">Password:</label>
				    <input type="password" class="form-control" id="pwd">
				  </div>
				  <div class="form-group">
				    <label for="confirm-pwd">Confirm password:</label>
				    <input type="password" class="form-control" id="confirm-pwd">
				  </div>
				  <div class="form-group">
				    <label for="txt-nicename">Nicename:</label>
				    <input type="text" class="form-control" id="txt-nicename">
				  </div>
				  <div class="form-group">
				    <label for="txt-email">Email:</label>
				    <input type="text" class="form-control" id="txt-email">
				  </div>
				  <div class="form-group">
				    <label for="txt-address">Address:</label>
				    <input type="text" class="form-control" id="txt-address">
				  </div>
				  <div class="form-group">
				    <label for="slt-permission">Permission:</label>
				    <select id="slt-permission" class="form-control">
				    	<option value="allow_all">Admin</option>
				    	<option value="limit">User</option>
				    </select>
				  </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button>
		      </div>
		    </div>
		  </div>
		</div>
        <script type="text/javascript">
			$(document).ready(function() {
				$("select[name='itemsOnPage']").on("change", function(e) {
					var items = $(this).val();
					var href = location.href;

					href = updateQueryStringParameter(href, "itemsOnPage", items);
					window.location.href = href;
				});
			});
        </script>
    </jsp:body>
</t:genericpage>