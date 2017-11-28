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
<title>Payment画面</title>

<link href="css/main.css" rel="stylesheet" type="text/css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./jquery.validate.min.js"></script>

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


		<div class="accordionbox">
			<s:form action="PaymentConfirmAction">
			<div>
				<input type="radio" name="howToPay" id="cardAccordion" checked>
				<label for="cardAccordion">クレジットカード
					<div>
						<table id="cardInfo">
							<tr><th>名義</th><td><input type="text" name="cardName" pattern="^[A-Za-z]+$"></td></tr>
							<tr><th>カード番号</th><td><input name="card" id="card" class="txt" type="text" minlength="12" maxlength="12" pattern="\d*" onblur="num_only1(this)" /></td></tr>
							<tr>
								<th>有効期限</th>
								<td>
									<select name=”year”>
										<option value=”2014”>2014</option>
										<option value=”2015”>2015</option>
										<option value=”2016”>2016</option>
										<option value=”2017”>2017</option>
										<option value=”2018”>2018</option>
										<option value=”2019”>2019</option>
										<option value=”2020”>2020</option>
									</select>

									<select name=”month”>
										<option value=”jan”>1月</option>
										<option value=”feb”>2月</option>
										<option value=”mar”>3月</option>
										<option value=”apr”>4月</option>
										<option value=”may”>5月</option>
										<option value=”jun”>6月</option>
										<option value=”jul”>7月</option>
										<option value=”aug”>8月</option>
										<option value=”sep”>9月</option>
										<option value=”oct”>10月</option>
										<option value=”nov”>11月</option>
										<option value=”dec”>12月</option>
									</select>
								</td>
							</tr>
						</table>
					</div>
				</label>
			</div>

			<div>
				<input type="radio" name="howToPay" id="cashAccordion">
				<label for="cashAccordion">代引き</label>
			</div>
			<s:submit value="決定" />
			</s:form>

		</div>


	</div>

	<!--------------  フッタ  -------------->


	<footer>
		<p>footer</p>
    </footer>

<!--------------  jsファイル  -------------->
	<script type="text/javascript" src="./script.js"></script>

	<script src="localization/messages_ja.js"></script>

</body>
</html>