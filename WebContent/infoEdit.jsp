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
<title>登録編集画面</title>

<link href="css/main.css" rel="stylesheet" type="text/css">

</head>

<body>
	<!--------------  ヘッダ  -------------->

	<header>

		<div id="logo"><a href='<s:url action="HomeAction" />'>logo</a></div>


		<div class="space"><!-- スペース --></div>

		<div id="login">
			<s:if test='session.loginUser.loginFlg'>
				<a href='<s:url action="MypageAction" />'>マイページ</a>
				<a href='<s:url action="LogoutAction" />'>ログアウト</a>
			</s:if>
			<s:else>
				<a href='<s:url action="LoginPageAction" />'>Login</a>
			</s:else>
		</div>

	</header>


	<!--------------  メイン  -------------->


	<div id="main">
	<s:form action="UserInfoUpdateCompleteAction">
		<table>
			<tr><td>登録中の<s:property value="fieldName" /></td><td><s:property value="oldValue" /></td></tr>
			<tr><td>変更後の<s:property value="fieldName" /></td><td><s:textfield name="newValue" /></td></tr>
			<s:if test="checkFlg"><tr><td></td><td><div id="idCheck">※使用されています</div></td></tr></s:if>
		</table>
		<s:hidden name="updateField" value="%{updateField}" />
		<s:submit value="決定" />
		</s:form>
	</div>


	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
    </footer>


</body>
</html>