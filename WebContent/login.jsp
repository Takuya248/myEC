<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>login画面</title>

<link href="css/main.css" rel="stylesheet" type="text/css">
</head>

<body>

	<header>
		header
	</header>

	<div id="main">
		<div id="loginform">

			<s:form action="LoginAction">
						<s:textfield name="loginId" label="id" />
						<s:password name="loginPassword" label="pass"/>
						<s:submit value="login" />
			</s:form>

		</div>
	</div>

	<footer>
		footer
	</footer>

</body>
</html>