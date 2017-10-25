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

	<header> header </header>

	<div id="main">




		<div id="form">
			<ul>
				<s:form action="UserInfoEntryAction">
					<li>ログインID</li>
					<li><s:textfield name="newLoginId" /></li>
					<li>パスワード</li>
					<li><s:password name="newPassword" /></li>
					<li>名前</li>
					<li><s:textfield name="newUserName" /></li>
					<li>メールアドレス</li>
					<li><s:textfield name="newMailAddress" /></li>
					<li>電話番号</li>
					<li><s:textfield name="newPhoneNumber" /></li>
					<li><s:submit value="入力内容確認" /></li>
				</s:form>
			</ul>
		</div>


	</div>

	<footer> footer </footer>



</body>
</html>