<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>saved persons</title>
</head>
<body>
	<h3>Thank you for registering</h3>
	<p>
		Your registration information:
		<s:property value="personBean" />
	</p>
	<p>
		<a href="<s:url action='index' />">Return to home page</a>.
	</p>
</body>
</html>