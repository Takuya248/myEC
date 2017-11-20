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
<title>決済完了画面</title>

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


	<div class="userInfoTable">
		<table>
			<tr>
				<th>お名前</th>
				<td><s:property value="PaymentUserInfoDTO.UserName" /></td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td><s:property value="PaymentUserInfoDTO.UserMailAddress" /></td>
			</tr>
			<tr>
				<th>電話番号</th>
				<td><s:property value="PaymentUserInfoDTO.UserPhoneNumber" /></td>
			</tr>
			<tr>
				<th>住所</th>
				<td><s:property value="PaymentUserInfoDTO.state" /><s:property value="PaymentUserInfoDTO.city" />
				<s:property value="PaymentUserInfoDTO.street" /><s:property value="PaymentUserInfoDTO.building" /></td>
			</tr>
			<tr>
				<th>郵便番号</th>
				<td><s:property value="PaymentUserInfoDTO.zipCode" /></td>
			</tr>
		</table>
	</div>
		<div class="itemInfoTable">
				<s:iterator value="itemInfoList">
					<table>
						<tr>
							<th>商品名</th>
							<td><s:property value="itemName" /></td>
							<th>価格</th>
							<td><s:property value="itemPrice" /></td>
							<th>在庫数</th>
							<td><s:property value="cartItemStock" /></td>
						</tr>
					</table>
			</s:iterator>
		</div>

		<a href='<s:url action="PaymentCompleteAction" />'><button>購入確定</button></a>
</div>




	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
    </footer>


</body>
</html>