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


		<div class="space"><!-- スペース --></div>

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

	<div id="main">




		<div id="form">

			<s:form action="AddressEditConfirmAction">
				<table>
					<tr>
						<td>電話番号</td>
						<td><s:textfield name="phoneNumber" /></td>
					</tr>
					<tr>
						<td>都道府県</td>
						<td><s:textfield name="state" /></td>
					</tr>
					<tr>
						<td>市区町村</td>
						<td><s:textfield name="city" /></td>
					</tr>
					<tr>
						<td>番地</td>
						<td><s:textfield name="street" /></td>
					</tr>
					<tr>
						<td>建物</td>
						<td><s:textfield name="building" /></td>
					</tr>
					<tr>
						<td>郵便番号</td>
						<td><s:textfield name="zipCode" min="7" max="7" /></td>
					</tr>


				</table>
				<s:submit value="入力内容確認" />

			</s:form>
		</div>


	</div>

	<footer> footer </footer>



</body>
</html>