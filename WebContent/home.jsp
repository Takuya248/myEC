<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
<title>Home画面</title>

<link href="main.css" rel="stylesheet" type="text/css">

</head>

<body>
	<!--------------  ヘッダ  -------------->

	<div id="header">

		<div id="logo">header</div>

		<div id="login">
			<s:if test="#session.id != null">
				<p><a href='<s:url action="MypageAction" />' >マイページ</a></p>
			</s:if>
			<s:else>
				<a href='<s:url action="HomeAction" />'>Login</a>
			</s:else>

		</div>
	</div>


	<!--------------  メイン  -------------->


	<div id="main">メインコンテンツ</div>


	<!--------------  フッタ  -------------->


	<div id="footer">
		<p>footer</p>
	</div>


	<!--------------  jsファイル  -------------->
	<script type="text/javascript" src="script.js"></script>
</body>
</html>