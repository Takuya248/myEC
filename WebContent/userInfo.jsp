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
		<div id="UserInfo">
		<s:form action="UserInfoSelectAction">
			<table>
				<tr>
					<th>ユーザーID：</th>
					<td><s:property value='userInfoDTO.loginId' /></td>
                    <td><button type="submit" name="updateField" value="login_id">編集</button></td>
				</tr>
				<tr>
					<th>パスワード：</th>
					<td><s:property value='userInfoDTO.' /></td>
					<td><button type="submit" name="updateField" value="login_pass">編集</button></td>
				</tr>
				<tr>
					<th>名前：</th>
					<td><s:property value='userInfoDTO.userName' /></td>
					<td><button type="submit" name="updateField" value="user_name">編集</button></td>
				</tr>
				<tr>
					<th>メールアドレス：</th>
					<td><s:property value='userInfoDTO.userMailAddress' /></td>
					<td><button type="submit" name="updateField" value="mail_add">編集</button></td>
				</tr>
				<tr>
					<th>電話番号：</th>
					<td><s:property value='userAddressDTO.phoneNumber' /></td>
					<td><button type="submit" name="updateField" value="phone_number">編集</button></td>
				</tr>
				<tr>
					<th>住所：</th>
					<s:if test='userAddressDTO.addressRegiFlg'>
						<td><s:property value='userAddressDTO.state + " " + userAddressDTO.city + " " + userAddressDTO.street + " " + userAddressDTO.building' /><br><s:property value='userAddressDTO.zipCode' /></td>
					</s:if>
					<s:else>
						<td>設定なし</td>
					</s:else>
					<td><button type="submit" name="updateField" value="address">編集</button></td>
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