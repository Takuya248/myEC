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

		<div id="logo">header</div>


		<div class="space"><!-- スペース --></div>

	</header>


	<!--------------  メイン  -------------->


	<div id="main">
	<s:form action="UserInfoInsertAction">
		<table>
			<tr><td>登録中の<s:property value="fieldName" /></td><td><s:property value='session.get("oldValue")' /></td></tr>
			<tr><td>変更後の<s:property value="fieldName" /></td><td><s:form action="UserInfoInsertAction"><s:textfield name="value" /></s:form></td></tr>
		</table>
		</s:form>
	</div>


	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
    </footer>


</body>
</html>