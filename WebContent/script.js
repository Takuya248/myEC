function num_only(str){
var wnum = str.value;
// 数値以外の入力消去
document.getElementById("innum").value=wnum.replace(/[^\d-.]/g,'');
return(str);
}

function num_check2(str){
	var ok = true;
	var wresult = "";
	var wcheck = true;
	var wnum = str.value;
	wresult = /[^\d-.]/.test(wnum);
	if (wresult){
		ok=false;
		setTimeout(function(){str.focus();}, 0);
		alert("半角数字以外入力不可です。");
//***マイナス、小数入力不可の場合、以降不要***
	} else {
// -（マイナス）の入力有無チェック
		wresult = /-+/.test(wnum);
		if (wresult){
// -（マイナス）のフォーマットチェック
			wcheck=minus_check(wnum);
		}
		if (wcheck){
// .（小数点）の入力有無チェック
			wresult = /[.]+/.test(wnum);
			if (wresult){
// .（小数点）のフォーマットチェック
				wcheck=point_check(wnum);
			}
		}
		if (!wcheck){
			setTimeout(function(){str.focus();}, 0);
		}
	}
	return(ok);
}
// ━━━━━━━━━━━━━━━━
// -（マイナス）の数、位置チェック
// ━━━━━━━━━━━━━━━━
function minus_check(str){
	var ok = true;
	var wresult = "";
	wresult = str.match(/-/g).length;
	if (wresult>1){
		ok=false;
		alert("-（マイナス）が複数入力されています。");
	} else {
		wresult = /^-/.test(str);
		if (!wresult){
			ok=false;
			alert("-（マイナス）の位置が不正です。");
		}
	}
	return(ok);
}
// ━━━━━━━━━━━━━━━━
// .（小数点）の数、位置チェック
// ━━━━━━━━━━━━━━━━
function point_check(str){
	var ok = true;
	var wresult = "";
	wresult = str.match(/[.]/g).length;
	if (wresult>1){
		ok=false;
		alert(".（小数点）が複数入力されています。");
	} else {
		wresult = /[.]$/.test(str);
		if (wresult){
			ok=false;
			alert(".（小数点）の位置が不正です。");
		}
	}
	return(ok);
}
