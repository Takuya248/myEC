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
<title>UserInfo画面</title>

<link href="css/main.css" rel="stylesheet" type="text/css">

</head>


<body>

<!--------------  ヘッダ  -------------->

	<header>

		<div id="logo">header</div>


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
		<div id="UserInfo">
		<s:form action="UserInfoSelectAction">
			<table>
				<tr>
					<th>ユーザーID：</th>
					<td><s:property value='session.get("loginId")' /></td>
                    <td><button type="submit" name="updateField" value="login_id">編集</button></td>
				</tr>
				<tr>
					<th>パスワード：</th>
					<td><s:property value='session.get("loginPassword")' /></td>
					<td><button type="submit" name="updateField" value="login_pass">編集</button></td>
				</tr>
				<tr>
					<th>名前：</th>
					<td><s:property value='session.get("userName")' /></td>
					<td><button type="submit" name="updateField" value="user_name">編集</button></td>
				</tr>
				<tr>
					<th>メールアドレス：</th>
					<td><s:property value='session.get("mailAddress")' /></td>
					<td><button type="submit" name="updateField" value="mail_add">編集</button></td>
				</tr>
				<tr>
					<th>電話番号：</th>
					<td><s:property value='session.get("phoneNumber")' /></td>
					<td><button type="submit" name="updateField" value="phone_number">編集</button></td>
				</tr>
				<tr>
					<th>登録日：</th>
					<td><s:property value='session.get("regiDate")' /></td>
				</tr>

			</table>
			</s:form>
		</div>
	</div>


	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
    </footer>



</body>
</html>