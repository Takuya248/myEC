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
<title>itemList画面</title>

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
<div id="itemList">


		<s:iterator value="itemInfoList" status="itemInfoListSt">

			<s:if test="#itemInfoListSt.odd">
				<div id="itemInfoValueOdd">
					<table>
						<tr>
							<th>商品名</th>
							<td><s:property value="itemName" /></td>
							<th>価格</th>
							<td><s:property value="itemPrice" /></td>
							<th>在庫数</th>
							<td><s:property value="itemStock" /></td>
							<td><s:form action="CartAction"><s:hidden name="buyItemId" value="%{itemId}" /><s:submit value="カートに入れる" /></s:form></td>
						</tr>
					</table>
				</div>
			</s:if>

			<s:else>
				<div id="itemInfoValue">
					<table>
						<tr>
							<th>商品名</th>
							<td><s:property value="itemName" /></td>
							<th>価格</th>
							<td><s:property value="itemPrice" /></td>
							<th>在庫数</th>
							<td><s:property value="itemStock" /></td>
							<td><s:form action="CartAction"><s:hidden name="buyItemId" value="%{itemId}" /><s:submit value="カートに入れる" /></s:form></td>
						</tr>
					</table>
				</div>
			</s:else>

		</s:iterator>

</div>

	</div>


	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
    </footer>


</body>
</html>