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
<title>Cart画面</title>

<link href="css/main.css" rel="stylesheet" type="text/css">

</head>
<body>
<!--------------  ヘッダ  -------------->

	<header>

		<div id="logo">header</div>


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

カートの中身

		<s:iterator value="cartItemInfoList">


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
	<s:form action="ItemListPageAction"><s:submit value="商品一覧" /></s:form>
</div>

	</div>


	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
    </footer>


</body>
</html>