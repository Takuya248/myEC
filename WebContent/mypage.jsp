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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>



	<header>

		<div id="logo"><a href='<s:url action="HomeAction" />'>logo</a></div>


		<div class="space">
			<!-- スペース -->
		</div>

		<div class="menuList">
			<ul>
				<s:if test='session.loginUser.loginFlg'>
					<li><a href='<s:url action="CartAction" />'>カート</a></li>
					<li><a href='<s:url action="LogoutAction" />'>ログアウト</a></li>
				</s:if>
				<s:else>
					<li><a href='<s:url action="LoginPageAction" />'>Login</a></li>
				</s:else>
			</ul>
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
                <li><a href='<s:url action="OrderHistoryListAction" />'>購入履歴</a></li>
			</ul>
		</div>

	</div>


	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
	</footer>


	<script type="text/javascript" src="./js/script.js"></script>

</body>
</html>