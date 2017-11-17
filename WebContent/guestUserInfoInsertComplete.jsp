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
<title>住所登録画面</title>

<link href="css/main.css" rel="stylesheet" type="text/css">
</head>

<body>

	<header>
		<div id="logo"><a href='<s:url action="HomeAction" />'>logo</a></div>
	</header>

	<div id="main">
			<div id="guestUserInfo">
				<table>

					<tr>
						<th>名前</th>
						<td><s:property value="userName" /></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><s:property value="mailAddress" /></td>
					</tr>
					<tr>
						<th>電話番号</th>
						<td><s:property value="phoneNumber" /></td>
					</tr>
					<tr>
						<th>都道府県</th>
						<td><s:property value="state" /></td>
					</tr>
					<tr>
						<th>市区町村</th>
						<td><s:property value="city" /></td>
					</tr>
					<tr>
						<th>番地</th>
						<td><s:property value="street" /></td>
					</tr>
					<tr>
						<th>建物</th>
						<td><s:property value="building" /></td>
					</tr>
					<tr>
						<th>郵便番号</th>
						<td><s:property value="zipCode" /></td>
					</tr>
				</table>
			</div>


			<div class="confirm">
			<a href='<s:url action="GuestUserInfoCompleteAction" />'><button type="submit" value="confirm">登録</button></a>
				<a href='<s:url action="HowToBuyAction" />'><button type="submit" value="return">戻る</button></a>
			</div>
	</div>


	<footer> footer </footer>



</body>
</html>