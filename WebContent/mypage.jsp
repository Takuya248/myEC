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
<title>Mypage画面</title>

<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>



	<header>

		<div id="logo">header</div>


	</header>


	<!--------------  メイン  -------------->

	<div id="main">
		<div id="mypageUserInfo">
			<table>
				<tr>
					<th>ユーザー名：</th>
					<td><s:property value='session.get("loginId")' /></td>
				</tr>
				<tr>
					<th>パスワード：</th>
					<td><s:property value='session.get("loginPass")' /></td>
				</tr>

			</table>
		</div>

	</div>


	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
	</footer>

</body>
</html>