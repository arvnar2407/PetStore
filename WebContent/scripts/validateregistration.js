function validatepass() {
	passwordRef = document.getElementsByName("pass")[0];
	var pass = passwordRef.value;
	if (pass == "") {
		res = false;
		document.getElementById("err").innerText = "please provide password";
	}
	return res;
}

function validatefname() {
	fnamesRef = document.getElementsByName("fname")[0];
	var fvalue = fnamesRef.value;
	if (fvalue == "") {
		res = false;
		document.getElementById("err").innerText = "please provide first name";
	}
	return res;
}

function validatelname() {
	lnamesRef = document.getElementsByName("lname")[0];
	var lvalue = lnamesRef.value;
	if (lvalue == "") {
		res = false;
		document.getElementById("err").innerText = "please provide last name";
	}
	return res;
}

function vaidatedate() {
	var format = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
	dateRef = document.getElementsByName("dob")[0];
	var dvalue = dateRef.value;
	if (dvalue == "" || !dvalue.match(format)) {
		res = false;
		document.getElementById("err").innerText = "please provide date in 'dd-mm-yyyy' format";
	}
	return res;
}

function validateaddress() {
	addressRef = document.getElementsByName("address")[0];
	var avalue = addressRef.value;
	if (avalue == "") {
		res = false;
		document.getElementById("err").innerText = "please enter address";
	}
	return res;
}

function validatecontact() {
	var format = /^[0-9]+$/;
	contactRef = document.getElementsByName("contact")[0];
	var cvalue = contactRef.value;
	if (cvalue == "" || cvalue.length < 10 || !cvalue.match(format)) {
		res = false;
		document.getElementById("err").innerText = "please enter contact number and it should be 10 digits";
	}
	return res;
}

function validatecredit() {
	var format = /^[0-9]+$/;
	creditRef = document.getElementsByName("credit")[0];
	var crvalue = creditRef.value;
	if (crvalue == "" || crvalue.length < 10 || !crvalue.match(format)) {
		res = false;
		document.getElementById("err").innerText = "please enter credit card number and it should be 10 digits";
	}
	return res;
}

function validatetype() {
	typeRef = document.getElementsByName("cardtype")[0];
	var tvalue = typeRef.value;
	if (tvalue == "") {
		res = false;
		document.getElementById("err").innerText = "please enter credit card  type";
	}
	return res;
}

function validatecdate() {
	var format = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
	dateRef = document.getElementsByName("carddate")[0];
	var dvalue = dateRef.value;
	if (dvalue == "" || !dvalue.match(format)) {
		res = false;
		document.getElementById("err").innerText = "please provide credit card expiry date in 'dd-mm-yyyy' format";
	}
	return res;
}

function validate() {

	passwordRef = document.getElementsByName("pass")[0];
	var pass = passwordRef.value;
	fnamesRef = document.getElementsByName("fname")[0];
	var fvalue = fnamesRef.value;
	lnamesRef = document.getElementsByName("lname")[0];
	var lvalue = lnamesRef.value;
	var format = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
	dateRef = document.getElementsByName("dob")[0];
	var dvalue = dateRef.value;
	addressRef = document.getElementsByName("address")[0];
	var avalue = addressRef.value;
	contactRef = document.getElementsByName("contact")[0];
	var cvalue = contactRef.value;
	creditRef = document.getElementsByName("credit")[0];
	var crvalue = creditRef.value;
	typeRef = document.getElementsByName("cardtype")[0];
	var tvalue = typeRef.value;
	var format = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
	dateRef = document.getElementsByName("carddate")[0];

	if (pass == "") {

		document.getElementById("err").innerText = "please provide all values";
		return false;
	}

	else if (fvalue == "") {

		document.getElementById("err").innerText = "please provide all values";
		return false;
	}

	else if (lvalue == "") {

		document.getElementById("err").innerText = "please provide all values";
		return false;
	}

	else if (dvalue == "" || !dvalue.match(format)) {

		document.getElementById("err").innerText = "please provide all values";
		return false;
	}

	else if (avalue == "") {
		res = false;
		document.getElementById("err").innerText = "please provide all values";
		return false;
	}

	else if (cvalue == "" || cvalue.length < 10) {
		res = false;
		document.getElementById("err").innerText = "please provide all values";
		return false;
	}

	else if (crvalue == "" || crvalue.length < 10) {
		res = false;
		document.getElementById("err").innerText = "please provide all values";
		return false;
	}

	else if (tvalue == "") {
		res = false;
		document.getElementById("err").innerText = "please provide all values";
		return false;
	}

	else if (dvalue == "" || !dvalue.match(format)) {
		res = false;
		document.getElementById("err").innerText = "please provide all values";
		return false;
	}

}
