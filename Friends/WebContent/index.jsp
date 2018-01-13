<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:genericpage>
	<jsp:attribute name="title">Friends Project</jsp:attribute>
	<jsp:attribute name="header"/>
    <jsp:attribute name="footer"/>
    <jsp:body>
        <p>Hi I'm the heart of the message</p>
        <script type="text/javascript">
			$(document).ready(function() {
				alert("jQuery is ready");
			});
        </script>
    </jsp:body>
</t:genericpage>