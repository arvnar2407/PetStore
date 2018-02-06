<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../CSS/Stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body class="background" text="#000000" >
<c:if test="${empty sessionScope.uid}">
<c:redirect url="Login.jsp"></c:redirect>
</c:if>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <TBODY>
  
 
    <tr>
      <td align="right" width="11">&nbsp;</td><!-- #BeginEditable "page title" -->
      <td class="lblTitle" width="643"><b>PURCHASE SUMMARY</b></td><!-- #EndEditable -->
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
     <p style="font-family: fantasy; color: maroon;  font-size: medium" >
     Thank you for shopping with us ${sessionScope.uid}
     <br> Your invoice is given below 
     <br>order Id is : ${sessionScope.orderId }
     </p>         
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
                     
                    </td>
                  </tr>
                </table>
              </td>
            <td width="10">&nbsp;</td>
          </tr>
          <tr>
            <td width="10">&nbsp;</td>
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
            <td colspan="2" width="100%">
              <table align="center" border="0" cellspacing="0" cellpadding="0" width="100%" style="HEIGHT: 129px; LEFT: 0px; TOP: 0px; WIDTH: 709px">
              <TBODY>
                <tr>
                <td colspan = 2>
                  <P align=center>
                  <table>
                  
                  <TD class=tblHeader width="10%">CTGY ID</TD>
                      <TD class=tblHeader width="10%">PROD ID</TD>
                      <TD class=tblHeader width="10%">ITEM ID</TD>
                      <TD class=tblHeader width="20%">ITEM NAME</TD>
                      <TD class=tblHeader width="30%">ITEM 
                        DESCRIPTION</TD>
                      <TD class=tblHeader width="10%">PRICE</TD>
                       <td class=tblHeader width="10%">QUANTITY</td>
                    
                   <c:forEach items="${sessionScope.pdata}" var="item">
                    <TR>
                      <TD class=tblDataText>${item.categoryId}</TD>
                      <TD class=tblDataText>${item.productId}</TD>
                      <TD class=tblDataText>${item.itemId}</TD>
                      <TD class=tblDataText>${item.itemName} </TD>
                      <TD class=tblDataText>&nbsp;${item.itemDescription}</TD>
                      <TD class=tblDataText> ${item.itemPrice}</TD>
  
                     </c:forEach>
                     <td>
                    <table >
                    <c:forEach items="${requestScope.quantity}" var="item">
                    <tr>
                    <td >${item}</td>
                    </tr>
                    </c:forEach>
                    </table>
                    </td>
                   
                  </table>
					
                </td>
                </tr>
       
            <td width="10">&nbsp;</td>
            <td width="10">&nbsp;</td>
            <td width="10">&nbsp;</td>
            <td width="10">&nbsp;</td>
          
          

    <tr valign="bottom">
      <td class="blueBackGround" colspan="6" width="925"></td>
    </tr></TBODY>
  </table>
  
<p>
total price is ${sessionScope.tprice}
</p>
<p>
<a href="logout.do"> logout</a>
</p>
</body>
</html>