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

<link href="css/main.css" rel="stylesheet" type="text/css">

</head>

<body>
	<!--------------  ヘッダ  -------------->

	<header>

		<div id="logo">header</div>


		<div class="space">
			<!-- スペース -->
		</div>

		<div class="menuList">
			<ul>
				<s:if test='session.loginUser.loginFlg'>
					<li><a href='<s:url action="MypageAction" />'>マイページ</a></li>
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

		<table id="orderList">
			<thead>
				<tr>
					<th>購入履歴</th>
				</tr>
			</thead>
			<s:iterator value="orderHistoryList">

				<tbody>
					<tr>
						<td>
						<s:form action="OrderHistoryAction">
							注文番号:<s:property value="orderId" /><br>
							注文日:<s:property value="insertDate" />
							<s:hidden name="selectOrderId" value="%{orderId}" />
							<s:submit value="詳細" />
						</s:form>
						</td>
					</tr>
				</tbody>
			</s:iterator>
		</table>

	</div>


	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
    </footer>


	<!--------------  jsファイル  -------------->
	<script type="text/javascript" src="script.js"></script>
</body>
</html>