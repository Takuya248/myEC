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

<link href="./css/main.css" rel="stylesheet" type="text/css">

</head>

<body>

	<header>
		<div id="logo"><a href='<s:url action="HomeAction" />'>logo</a></div>
	</header>

	<div id="main">

		<div id="form">

			<div id="first">
			<ul>
				<s:form action="LoginAction" class="login">
					<li>ログインID</li>
					<li><s:textfield name="loginId" /></li>
					<li>パスワード</li>
					<li><s:password name="loginPassword" /></li>
					<li><s:submit value="login" /></li>
				</s:form>
				</ul>
			</div>

			<div class="second">
				<a href='<s:url action="UserCreateAction" />'>新規登録</a>
			</div>

		</div>

	</div>

	<footer>
		footer
	</footer>

</body>
</html>