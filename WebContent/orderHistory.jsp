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
<title>購入履歴画面</title>

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
		<table>
			<tr>
				<td>
					<table>
					<s:iterator value="orderItemInfoList">
						<tr>
							<th>注文番号</th><td><s:property value="orderId" /></td>
							<th>商品名</th><td><s:property value="itemName" /></td>
							<th>値段</th><td><s:property value="itemPrice" /></td>
							<th>注文数</th><td><s:property value="itemCount" /></td>
							<th>購入日</th><td><s:property value="insertDate" /></td>
							<th>決済方法</th><td><s:property value="selectPayment" /></td>
						</tr>
					</s:iterator>
					</table>
					<a href='<s:url action="OrderHistoryListAction" />'><button>戻る</button></a>
				</td>
			</tr>
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