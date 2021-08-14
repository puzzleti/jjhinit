<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<s:head />
</head>
<body>
	<h3>Register by completing this form.</h3>

	<s:form action="register">
		<s:textfield name="personBean.surname" label="First name" />
		<s:textfield name="personBean.familyname" label="Last name" />
		<s:textfield name="personBean.email" label="Email" />
		<s:textfield name="personBean.age" label="Age" />
		<s:submit />
	</s:form>
</body>
</html>