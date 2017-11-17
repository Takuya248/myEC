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
<title>内容確認画面</title>

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
		<div id="confirm">
			<div id="userInfo">
				<table>
					<tr>
						<th>注文番号</th>
						<td><s:property value='cartId' /></td>
					</tr>
					<tr>
						<th>名前</th>
						<td><s:property value='UserName' /></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><s:property value='UserMailAddress' /></td>
					</tr>
					<tr>
						<th>電話番号</th>
						<td><s:property value='UserPhoneNumber' /></td>
					</tr>
					<tr>
						<th>都道府県</th>
						<td><s:property value='state' /></td>
					</tr>
					<tr>
						<th>市区町村</th>
						<td><s:property value='city' /></td>
					</tr>
					<tr>
						<th>番地</th>
						<td><s:property value='street' /></td>
					</tr>
					<tr>
						<th>建物</th>
						<td><s:property value='building' /></td>
					</tr>
					<tr>
						<th>郵便</th>
						<td><s:property value='zipCode' /></td>
					</tr>
					<tr>
						<th>決済方法</th>
						<s:if test='selectPayment == "card"'>
						<td>カード</td>
						</s:if>
						<s:elseif test='selectPayment == "cash"'>
						<td>代引き</td>
						</s:elseif>
						<s:else>
						<td>コンビニ支払い</td>
						</s:else>
					</tr>
				</table>
			</div>


			<div class="confirm">
				<a href='<s:url action="HomeAction" />'><button type="submit" value="return">ホームに戻る</button></a>
			</div>
		</div>
	</div>

	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
    </footer>


	<!--------------  jsファイル  -------------->
	<script type="text/javascript" src="script.js"></script>
</body>
</html>
