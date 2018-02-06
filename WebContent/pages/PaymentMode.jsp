<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function validate()
{
var format=/^[0-9]+$/;
var qty=document.getElementsByName("qty")[0];
var vqty=qty.value;
if(vqty=="" || !vqty.match(format))
{
document.getElementById("err").innerText="You must give quantity as number";
return false;
}
else
{
return true;
}
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p align="right">
<a href="logout.do"> logout</a>
</p>
<c:if test="${empty sessionScope.uid}">
<c:redirect url="Login.jsp"></c:redirect>
</c:if>
<form method="post" name="Search" action="display.do">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <TBODY>
  
 
    <tr>
      <td align="right" width="11">&nbsp;</td><!-- #BeginEditable "page title" -->
      <td class="lblTitle" width="643"><b>Payment Details</b></td><!-- #EndEditable -->
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
        <TBODY>
          <tr>
              <td width="10">&nbsp;</td>
              <td class=lblError width="891">
              <span id="err"></span>
              <!-- <li>Error messages will be displayed here</li> -->
              </td>
              <td width="10">&nbsp;</td>
          </tr>
          <tr>
           <td width="10"> &nbsp;</td>
          </tr>
          <tr>
            <td width="10">&nbsp;	</td>

              <td colspan="2">
                <table border="0" cellspacing="0" cellpadding="0" width="100%">
                  <tr>
                    <td  align=right>
                      
                  <DIV>
                  <DIV align=left><STRONG><FONT color=midnightblue 
                  size=4>PURCHASE SUMMARY : </FONT></STRONG></DIV>
                  <DIV align=left>&nbsp;</DIV>
                  <DIV align=left>
                  <TABLE align=center border=2 cellPadding=2 cellSpacing=2 
                  class=outerTable id=TABLE1 width="100%">
                    
                    <TR>
                      <TD class=tblHeader width="10%">CTGY ID</TD>
                      <TD class=tblHeader width="10%">PROD ID</TD>
                      <TD class=tblHeader width="10%">ITEM ID</TD>
                      <TD class=tblHeader width="20%">ITEM NAME</TD>
                      <TD class=tblHeader width="30%">ITEM 
                        DESCRIPTION</TD>
                      <TD class=tblHeader width="10%">PRICE</TD>
                      <TD class=tblHeader width="10%">QUANTITY</TD></TR>
                      <c:forEach items="${sessionScope.pdata}" var="item">
                    <TR>
                      <TD class=tblDataText>${item.categoryId}</TD>
                      <TD class=tblDataText>${item.productId}</TD>
                      <TD class=tblDataText>${item.itemId}</TD>
                      <TD class=tblDataText>${item.itemName} </TD>
                      <TD class=tblDataText>&nbsp;${item.itemDescription}</TD>
                      <TD class=tblDataText> ${item.itemPrice}</TD>
                      <TD class=tblDataText  ><INPUT id=text1 name="qty"
                        style="HEIGHT: 22px; WIDTH: 77px" value=1 onblur="return validate()"> &nbsp; 
                    </TD></TR>
                    </c:forEach>
                    </TABLE></DIV>&nbsp;</DIV>
                    </td>
                  </tr>
                </table>
              </td>
            <td width="10">&nbsp;</td>
          </tr>
          <TR height= "5">
            <TD width="10"></TD>
            <TD class=blueBackGround colSpan=2></TD>
            <TD width="10"></TD>
          </TR>
          <TR >
            <TD width="6" > &nbsp;</TD>
          </TR>
          <tr>
            <td align="middle" colspan="3" width="100%">
              <table align="center" border="0" cellspacing="0" cellpadding="0" width="100%"> 
              <TBODY>
                <TR>
                  <TD align="right" width = 50>
                  <P align=center>
				  <FONT face="Bookman Old Style">&nbsp;<STRONG><FONT 
                  color=blue>PAYMENT&nbsp;MODE </FONT><FONT 
                  color=#191970>:&nbsp; </FONT></STRONG> </FONT></P>
                  <P align=center></P>
                   </TD>
	               <td align="left" class=mainLabel >
                  <P align=center>
	               &nbsp;<SELECT id=select1 
                  name=select1 style="HEIGHT: 22px; WIDTH: 145px" 
                  title="Category ID"> <OPTION selected 
                    value=CREDIT_CARD>CREDIT CARD</OPTION><OPTION 
                    value=CASH_ON_DELIVERY>CASH ON DELIVERY</OPTION></SELECT></P>
                  <P align=center></P></td>
                  <td width="11">
                  <P align=center>&nbsp;</P></td>
                  <td class=mainLabel colspan="2" align="right" width="442">
                  <P align=center>&nbsp;</P></td>
               </TR>
                <tr>
                <td colspan = 2>
                  <P align=center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="submit" value="checkout" onclick="return validate()">
					
                </td>
                </tr>
                <tr>
                <td align="middle" colspan = 2>
                  <P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                  </P>
                </td>
                </tr>
               <tr>
            
            <td width="10">&nbsp;</td>
            <td width="10">
                  <P>&nbsp;</P></td>
            <td width="10">&nbsp;</td>
            <td width="10">&nbsp;</td>
          </tr>
          

    <tr valign="bottom">
      <td class="blueBackGround" colspan="6" width="925"></td>
    </tr></TBODY>
  </table>

</body>
</html>