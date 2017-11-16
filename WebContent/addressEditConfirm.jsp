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

		<div class="space"><!-- 余白 --></div>


	</header>


	<!--------------  メイン  -------------->


	<div id="main">
		<div id="confirm">
			<div id="userInfo">
				<table>
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
						<th>郵便番号</th>
						<td><s:property value='zipCode' /></td>
					</tr>
				</table>
			</div>


			<div class="confirm">
			<s:form action="AddressInsertAction"><s:submit value="登録" /></s:form>
				<a href='<s:url action="AddressAction" />'><button type="submit" value="return">再入力</button></a>
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
