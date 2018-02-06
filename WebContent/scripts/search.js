function getDetails()
{
var x=document.getElementsByName("select1")[0].value;
window.location.href ='search.do?val='+x;
}


function checkTheSelect()
{

res=true;
if ( document.Search.select2.value==-1 ) { 
document.getElementById("err").innerText="You must select atleast one item";
return false;

 } 
  return res; 
}