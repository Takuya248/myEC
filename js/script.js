function num_only1(str){
var wnum = str.value;
// 数値以外の入力消去
document.getElementById("card").value=wnum.replace(/[^\d-.]/g,'');
return(str);
}

function num_only2(str){
	var wnum = str.value;
	// 数値以外の入力消去
	document.getElementById("cardLimitYear").value=wnum.replace(/[^\d-.]/g,'');
	return(str);
	}

function num_only3(str){
	var wnum = str.value;
	// 数値以外の入力消去
	document.getElementById("cardLimitMonth").value=wnum.replace(/[^\d-.]/g,'');
	return(str);
	}

$(function(){
	$("#form01").validate();
	})