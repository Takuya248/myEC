<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@
page import="com.internousdev.myEC.dto.ItemInfoDTO"
import="java.util.ArrayList"
import="java.util.Map.Entry"
 %>

<%

int price = 0;

%>



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
					<td>合計<s:property value="cartItemDTO.itemPrice" />円</td>
					<td>アイテム数<s:property value="cartItemDTO.itemStack" /></td>
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
						<td><s:form action="CartUpdateAction"><s:hidden name="listIndex" value="%{#idx.index}" /><s:textfield type="number" name="stackCountUpdate" value="%{cartItemStack}" min="0" max="20" /><s:submit value="更新" /></s:form></td>
						<td></td>
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