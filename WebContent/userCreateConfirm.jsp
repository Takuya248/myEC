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

		<div id="logo"><a href='<s:url action="HomeAction" />'>logo</a></div>

		<div class="space"><!-- 余白 --></div>


	</header>


	<!--------------  メイン  -------------->


	<div id="main">
		<div id="confirm">

				<div id="userInfo">
				<s:form action="UserInfoInsertAction">
					<table>
						<tr>
							<th>ユーザー名：</th>
							<td><input type="hidden" name="loginId" value=<s:property value='userCreateDTO.loginId' /> /><s:property value='userCreateDTO.loginId' /></td>
						</tr>
						<tr>
							<th>パスワード：</th>
							<td><s:hidden name="loginPassword" value=<s:property value='userCreateDTO.password' /> /><s:property value='userCreateDTO.password' /></td>
						</tr>
						<tr>
							<th>名前：</th>
							<td><s:hidden name="userName" value=<s:property value='userCreateDTO.userName' /> /><s:property value='userCreateDTO.userName' /></td>
						</tr>
						<tr>
							<th>メールアドレス：</th>
							<td><s:hidden name="mailAddress" value=<s:property value='userCreateDTO.mailAddress' /> /><s:property value='userCreateDTO.mailAddress' /></td>
						</tr>
					</table>
					<button type="submit" name="submit" value="confirm">登録</button>
					<button type="submit" name="submit" value="return">再入力</button>
				</s:form>
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
