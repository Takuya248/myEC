<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<title>Mypage画面</title>

<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>



	<header>

		<div id="logo"><a href='<s:url action="HomeAction" />'>logo</a></div>


		<div class="space">
			<!-- スペース -->
		</div>

		<div id="login">
			<s:if test='session.get("loginFlg") == true'>
				<a href='<s:url action="MypageAction" />'>マイページ</a>
				<a href='<s:url action="CartAction" />'>カート</a>
			</s:if>
			<s:else>
				<a href='<s:url action="LoginPageAction" />'>Login</a>
			</s:else>
		</div>
	</header>

	<!--------------  メイン  -------------->

	<div id="main">
		<div id="mypageUserInfo">
			<table>
				<tr>
					<th>ユーザー名：</th>
					<td><s:property value='session.loginUser.loginId' />さんのマイページ</td>
				</tr>




			</table>
		</div>

		<div id="mypageMenu">
			<ul>
                <li><a href='<s:url action="UserInfoAction" />'>ユーザー登録情報</a></li>
                <li>購入履歴</li>
			</ul>
		</div>

	</div>


	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
	</footer>

</body>
</html>