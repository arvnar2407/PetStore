function checkTheBox() {
alert("in js");
var flag = 0;
var checkbox= document.getElementsByName("checkboxGroup");
for (var i = 0; i<checkbox.length ; i++) {
if( document.Search["checkboxGroup"][i].checked){
flag ++;
}
}
if (flag  < 1) {
 document.getElementById("err").innerText="You must select atleast one item";
return false;
}
return true;
}


