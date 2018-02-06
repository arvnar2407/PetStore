function validateuser()
{
	var res=true;
	var letterNumber = /^\d+$/; 
	usernameRef=document.getElementsByName("uname")[0];

	var userName=usernameRef.value;
	if(userName=="" || !userName.match(letterNumber))
		{
		res= false;
		document.getElementById("err").innerText="please provide username and only integers as value";
		}
		return res;
		}
		
		
function validatepass()
		{
		passwordRef=document.getElementsByName("pass")[0];
		var pass= passwordRef.value;
		if(pass== "")
			{
			res= false;
			document.getElementById("err").innerText="please provide password";
			}
			return res;
		}
	
	