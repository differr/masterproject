<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
<jsp:include page="/jsp/include/include_css.jsp" flush="true"/>
</head>
<body>

<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="right" title="Tooltip on right">Right</button>

<jsp:include page="/jsp/include/include_js.jsp" flush="true"/>
<script type="text/javascript">

$(document).ready(function() {
	console.log('test hello world');
});

</script>
</body>
</html>