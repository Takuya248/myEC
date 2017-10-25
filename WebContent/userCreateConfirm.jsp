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
<title>登録内容画面</title>

<link href="css/main.css" rel="stylesheet" type="text/css">

</head>

<body>
	<!--------------  ヘッダ  -------------->

	<header>

		<div id="logo">header</div>

		<div class="space"><!-- 余白 --></div>


	</header>


	<!--------------  メイン  -------------->


	<div id="main">
		<div id="userInfo">
			<table>
				<tr>
					<th>ユーザー名：</th>
					<td><s:property value='session.get("newLoginId_session")' /></td>
				</tr>
				<tr>
					<th>パスワード：</th>
					<td><s:property value='session.get("newPassword")' /></td>
				</tr>
				<tr>
					<th>名前：</th>
					<td><s:property value='session.get("newUserName")' /></td>
				</tr>
				<tr>
					<th>電話番号：</th>
					<td><s:property value='session.get("newPhoneNumber")' /></td>
				</tr>
				<tr>
					<th>メールアドレス：</th>
					<td><s:property value='session.get("newMailAddress")' /></td>
				</tr>



			</table>
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
