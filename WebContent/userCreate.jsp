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
<title>登録画面</title>

<link href="css/main.css" rel="stylesheet" type="text/css">
</head>

<body>

	<header>
		<div id="logo"><a href='<s:url action="HomeAction" />'>logo</a></div>
	</header>

	<div id="main">




		<div id="form">

			<s:form action="UserInfoEntryAction">
				<table>
					<tr>
						<td>ログインID</td>
						<td><input type="text" name="newLoginId" /></td>
					</tr>
					<s:if test="checkFlg">
					<tr>
						<td></td>
						<td><div id="idCheck">※使用されています</div></td>
					</tr>
					</s:if>
					<tr>
						<td>パスワード</td>
						<td><s:password name="newPassword" /></td>
					</tr>
					<tr>
						<td>名前</td>
						<td><s:textfield name="newUserName" /></td>
					</tr>
					<tr>
						<td>メールアドレス</td>
						<td><s:textfield name="newMailAddress" /></td>
					</tr>
				</table>
				<s:submit value="入力内容確認" />

			</s:form>
		</div>


	</div>

	<footer> footer </footer>



</body>
</html>