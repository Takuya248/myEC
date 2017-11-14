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
<div id="cartItemList">

			<table>
				<tr>
					<th>カートの中身</th>
					<td>合計<s:property value="session.cartItemDTO.itemPrice" />円</td>
					<td>アイテム数<s:property value="session.cartItemDTO.itemStack" /></td>
				</tr>
			</table>

			<s:iterator value="session.cartItemInfoList" status="idx">


				<table>
					<tr>
						<th>商品名</th>
						<td><s:property value="itemName" /></td>
						<th>価格</th>
						<td><s:property value="itemPrice" /></td>
						<th>在庫数</th>
						<td><s:property value="itemStock" /></td>
						<th>注文数</th>
						<td><s:property value="cartItemStack" /></td>

					</tr>
				</table>



			</s:iterator>
			<s:form action="PaymentCompleteAction"><s:submit value="購入" /></s:form>
</div>

	</div>


	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
    </footer>



</body>
</html>