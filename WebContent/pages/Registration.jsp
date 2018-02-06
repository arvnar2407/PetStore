<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Registration</title>
<link rel="stylesheet" type="text/css" href="../CSS/Stylesheet.css">
<script type="text/javascript"   src="../scripts/validateregistration.js"> </script>
</head>
<body>
<form  name="Search" action="registration.do">

  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <TBODY>


    <tr>
      <td align="right" width="11">&nbsp;</td><!-- #BeginEditable "page title" -->
      <td class="lblTitle" width="643"><b>Registration Form</b></td><!-- #EndEditable -->
      <td width="267" align="right" valign="top"><IMG height=120 src="../IMAGES/gssmlanm.gif" width=100></td>
    </tr>
    <tr align="left">
      <td class="blueBackGround" colspan="3" width="925"></td>
    </tr>
    <tr align="left" valign="top">
      <td class="orangeBackGround" colspan="3" width="925"></td><!-- #BeginEditable "processName" --><!-- #EndEditable -->
    </tr>
    <tr>
      <td colspan="3" height="15" width="925"><!-- #BeginEditable "Process" -->
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
              <td width="10">&nbsp;</td>
              <td class=lblError width="891">
              <span id="err"></span>
              <span>${requestScope.error }</span>
              <!-- <li>Error messages will be displayed here</li> -->
              </td>
              <td width="10">&nbsp;</td>
          </tr>
          <tr>
    <tr>
      <td colspan="3" height="15" width="925"></td>
        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="HEIGHT: 481px; WIDTH: 667px">
        <TBODY>
          <tr>
              <td width="10">&nbsp;</td>
              <td class=lblError width="891"> 
              </td>
              <td width="10">&nbsp;</td>
          </tr>
          <tr>
           <td width="10"> &nbsp;</td>
          </tr>
          <tr>
            <td width="10">	</td>

              <td colspan="2">
                <table border="0" cellspacing="0" cellpadding="0" width="100%">
                  <tr>
                    <td  align=right>&nbsp;
                    </td>
                  </tr>
                </table>
              </td>
            <td width="10">&nbsp;</td>
          <tr>
      <P><FONT color=deepskyblue face="Monotype Corsiva" size=6><STRONG><FONT
      color=lightcoral> </FONT></STRONG></FONT>
          <P align=center><FONT color=sienna face="Monotype Corsiva"
          size=5></FONT>&nbsp;
          <P></P>
          <P align=center><FONT color=sienna face="Monotype Corsiva" size=5>" &nbsp;Please
          Enter the following information to become an&nbsp;A/C Holder
          "</FONT></P>
   		<P align=left><FONT color=lightgoldenrodyellow face="Monotype Corsiva" size=4><FONT
      color=mediumslateblue><FONT color=darkblue
          face="Bookman Old Style"><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Password&nbsp;
          :</STRONG></FONT>

	          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;</FONT>
       <INPUT id=txtPwd name="pass" onblur="return validatepass()">&nbsp;&nbsp;</FONT></P>
          <P align=left><FONT color=lightgoldenrodyellow face="Monotype Corsiva" size=4><FONT
      color=mediumslateblue><FONT color=darkblue
          face="Bookman Old Style"><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;First
          Name&nbsp;
          :</STRONG></FONT>

       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </FONT>
       <INPUT id=txtFNAME name="fname" onblur="return validatefname()">&nbsp;&nbsp;</FONT></P>
          <P align=left><FONT color=lightgoldenrodyellow face="Monotype Corsiva" size=4><FONT
          color=#000080><FONT face="Bookman Old Style"><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          Last Name&nbsp;&nbsp;
          :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG>&nbsp;
          </FONT></FONT>  <INPUT id=txtLNAME
      name="lname" onblur="return validatelname()"></FONT></P>
          <P align=left><FONT size=4><FONT color=navy
          face="Bookman Old Style"><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          Date of Birth
          :&nbsp;</STRONG></FONT></FONT>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="dob" maxlength="10" size="15"  onblur="return vaidatedate()"   style="HEIGHT: 22px; WIDTH: 159px"  ></P>
          <P align=left><FONT color=mediumslateblue face="Monotype Corsiva"
      size=4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;<FONT color=navy face="Bookman Old Style"><STRONG>Contact
          Address
          :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></FONT>&nbsp;
        </FONT><FONT size=4
         ><TEXTAREA id=txtADD name="address" onblur="return validateaddress()"></TEXTAREA></FONT></P>
          <P align=left><FONT color=#7b68ee face="Monotype Corsiva"
      size=4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<FONT
          color=navy face="Bookman Old Style"><STRONG>Contact No
          :</STRONG></FONT>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <INPUT maxLength=10 name="contact" onblur="return validatecontact()"  size=15 style="HEIGHT: 22px; WIDTH: 159px">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT></P>
          <P align=left><FONT color=#7b68ee face="Monotype Corsiva"
      size=4><STRONG><FONT color=navy
          face="Bookman Old Style">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;Credit Card No :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          </FONT></STRONG>
         <INPUT maxLength=10 name="credit" onblur="return validatecredit()" size=15
      style="HEIGHT: 22px; WIDTH: 159px"></FONT><FONT color=lightgoldenrodyellow face="Monotype Corsiva" size=5><FONT
      color=mediumslateblue
      size=4></FONT></FONT></P>
      
      <P align=left><FONT color=lightgoldenrodyellow face="Monotype Corsiva" size=4><FONT
          color=#000080><FONT face="Bookman Old Style"><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          Card Type&nbsp;&nbsp;
          :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG>&nbsp;
          </FONT></FONT>  <INPUT id=txtLNAME
      name="cardtype" onblur="return validatetype()"></FONT></P>
      
      
       <P align=left><FONT color=lightgoldenrodyellow face="Monotype Corsiva" size=4><FONT
          color=#000080><FONT face="Bookman Old Style"><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          Card Expiry Date&nbsp;&nbsp;
          :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG>&nbsp;
          </FONT></FONT>  <INPUT id=txtLNAME
      name="carddate" onblur="return validatecdate()"></FONT></P>
      
          <P align=left><FONT color=lightgoldenrodyellow face="Monotype Corsiva"
          size=5><FONT color=mediumslateblue size=4></FONT></FONT>&nbsp;</P>
          <P align=center><FONT color=lightgoldenrodyellow
          face="Monotype Corsiva" size=5><FONT color=mediumslateblue
          size=4>
      <input type="submit" value="register" name=submit1 onclick="return validate()"> 
      <input type="reset" value="reset" name=reset1>
      <input type="button" name=BTN_CLOSE value=close
          onclick="form.action='#';window.close();return true;">
           &nbsp;&nbsp;&nbsp;&nbsp;</FONT></P>
          <P align=center></P>
          </tr>
   	</TBODY>
  </table>
</tr>
</table>
</td>
</tr>
</TBODY>
</table>
</form>
</body>
</html>