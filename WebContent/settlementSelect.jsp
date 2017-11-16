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
<title>Payment画面</title>

<link href="css/main.css" rel="stylesheet" type="text/css">

</head>
<body>

<!--------------  ヘッダ  -------------->

	<header>

		<div id="logo"><a href='<s:url action="HomeAction" />'>logo</a></div>


		<div class="space">
			<!-- スペース -->
		</div>

		<div id="login">
			<s:if test='session.get("loginFlg") == true'>
				<a href='<s:url action="MypageAction" />'>マイページ</a>
			</s:if>
			<s:else>
				<a href='<s:url action="LoginPageAction" />'>Login</a>
			</s:else>
		</div>
	</header>
　

	<!--------------  メイン  -------------->


	<div id="main">

		<s:form action="PaymentConfirmAction">

			<input type="radio" name="howToPay" value="card">クレジットカード<input name="text" type="text" value="" onkeydown="return key_down(event.keyCode)" style="ime-mode: disabled;">

		</s:form>

	</div>




	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
    </footer>

<!--------------  jsファイル  -------------->
	<script type="text/javascript" src="script.js"></script>

</body>
</html>