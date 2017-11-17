function num_only(str){
var wnum = str.value;
// 数値以外の入力消去
document.getElementById("card").value=wnum.replace(/[^\d]/g,'');
return(str);
}

