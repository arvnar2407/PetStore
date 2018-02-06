<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.pet.petstore.domain.Item"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../CSS/Stylesheet.css">
<script type="text/javascript">
 function checkTheBox() {
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
<title>Insert title here</title>
</head>
<body>
<p align="right">
<a href="logout.do"> logout</a>
</p>
<c:if test="${empty sessionScope.uid}">
<c:redirect url="Login.jsp"></c:redirect>
</c:if>
<form  name="Search" action="confirm.do">

  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  
 
    <tr>
      <td align="right" width="11">&nbsp;</td><!-- #BeginEditable "page title" -->
      <td class="lblTitle" width="643"><b>Product Description</b></td><!-- #EndEditable -->
      <td width="267" align="right" valign="top"><img height=120 src="../IMAGES/gssmlanm.gif" width=100></img></td>
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
                    <td  align=right>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                      
                    </td>
                  </tr>
                </table>
              </td>
            <td width="10">&nbsp;</td>
          </tr>
          
          
                <tr>
                  <td class=mainLabel width="198">&nbsp;</td>
                  <td width="11">&nbsp;</td>
                  <td class=mainLabel width="198">&nbsp;</td>
                  <td width="11">&nbsp;</td>
                  <td class=mainLabel width="198">&nbsp;</td>
                </tr>
                <tr>
                  <td width="198">
						<b><font       
            style="FONT-FAMILY: Bookman Old Style" 
            color="#ff3300">

						
	

                  </td>
                </tr>
                <tr>
                  <td class=mainLabel width="198">&nbsp;</td>
                  <td width="11">&nbsp;</td>
                  <td class=mainLabel width="198">&nbsp;</td>
                  <td width="11">&nbsp;</td>
                  <td class=mainLabel colspan="3" align="right" width="442">&nbsp;</td>
                </tr>
              </table>
            </td>
            <td width="10">&nbsp;</td>
          </tr>
        <tr>
            <td width="10">&nbsp;</td>
            <td class=heading2 colspan="2">Search Results</td>
            <td width="10">&nbsp;</td>
          </tr>
          <tr height= "5">
            <td width="10"></td>
            <td class=bluebackground colspan=2></td>
            <td width="10"></td>
          </tr>
          <tr >
          <td > &nbsp;</td>
          </tr>
          <tr>
	          <td width="10">&nbsp;</td>
            <td colspan="2">
              <table width="100%" border="2" cellspacing="2" cellpadding="2"
                    class=outerTable align="center" id=TABLE1>
 							 <tr>
                  <td class="tblHeader" width="3%" height="10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
                  <td class="tblHeader" width="10%" height="10">CTGY ID</td>
                  <td class="tblHeader" width="10%" height="10">PROD ID</td>
                  <td class="tblHeader" width="10%" height="10">ITEM ID</td>
                  <td class="tblHeader" width="20%" height="10">ITEM NAME</td>
                  <td class="tblHeader" width="27%" height="10">ITEM DESCRIPTION</td>
                  <td class="tblHeader" width="10%" height="10">PRICE</td>
                 <td class="tblHeader" width="10%" height="10">QUANTITY</td>
                </tr>
                
                 <c:forEach items="${requestScope.result}" var="item" >
			    <tr>
                  <th class="tblDataText" ><INPUT id=checkbox1 
            name="checkboxGroup" value="${item.itemId},${item.productId},${item.categoryId}" type=checkbox></th>&nbsp;
                  <th class="tblDataText" name="id" >&nbsp; ${item.categoryId} </th>
                  <th class="tblDataText" name="pid" >&nbsp; ${item.productId}</th>
                  <th class="tblDataText" name="iid">&nbsp; ${item.itemId}</th>
                  <th class="tblDataText" name="iname">&nbsp; ${item.itemName} </th>
                  <th class="tblDataText" name="idesc">&nbsp; ${item.itemDescription}</th>
                  <th class="tblDataText" name="iprice">&nbsp; ${item.itemPrice}</th>
                  <th class="tblDataText" name="qty"><INPUT id=text1 name="qty" value="1" style="HEIGHT: 22px; WIDTH: 77px" onblur="return validate()"> &nbsp; </th>
                </tr>
      					</c:forEach>			  
			
              </table>
            </td>
            <td width="10">&nbsp;</td>
          </tr>
          <tr>
            <td width="10" height="21">&nbsp;</td>
            <td colspan="2" align="right" height="21">
            </td>
            <td width="10" height="21">&nbsp;</td>
          </tr>
          <tr>
            <td width="10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td colspan="2">&nbsp;
            <input type="submit" value="checkout" onclick="return checkTheBox()"> 
            <td width="10">&nbsp;</td>
          </tr>
          <tr>
            <td width="10">&nbsp;</td>
              <td colspan="2">
                <table border="0" cellspacing="0" cellpadding="0" width=899>
                  <tr>
                    <td width=176>
                      &nbsp;
                    </td>
                    <td align=right width=636>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                    <td align=right width="81">&nbsp;
                    </td>
                  </tr>
                </table>
              </td>
            <td width="10">&nbsp;</td>
          </tr>
        </table><!-- #EndEditable -->
    <tr>
      <td width="11">&nbsp; </td>
      <td valign="bottom" width="643">&nbsp;</td>
      <td width="267">&nbsp;</td>
    </tr>
    <tr valign="bottom">
      <td class="blueBackGround" colspan="3" width="925"></td>
    </tr>
</form>
<p>&nbsp;</p>
</body>
</html>