<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../CSS/Stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../scripts/search.js">


</script>
<title>Insert title here</title>
</head>
<body onload="search.do">
<p align="right">
<a href="logout.do"> logout</a>
</p>
<p> welcome ${sessionScope.uid} </p>

<c:if test="${empty sessionScope.uid}">
<c:redirect url="Login.jsp"></c:redirect>
</c:if>
<form  name="Search" action="product.do">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <TBODY>
    <tr>
      <td align="right" width="11">&nbsp;</td><!-- #BeginEditable "page title" -->
      <td class="lblTitle" width="643"><b>Search Item</b></td><!-- #EndEditable -->
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
              <td class=lblError width="891"><!-- <li>Error messages will be displayed here</li> -->
              <span id="err"></span>
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
            <td class=heading2 colspan="2">SEARCH CRITERIA</td>
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
              <table align="center" border="0" cellspacing="0" cellpadding="0" width="100%" style="HEIGHT: 129px; LEFT: 0px; TOP: 0px; WIDTH: 709px"
           >
              <TBODY>
               <tr>
                  <td align="right" width="40%">
                  <P
                  align=center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<STRONG> <FONT face="Bookman Old Style"> <FONT color=midnightblue>Category Name
                  :</FONT>
                  </FONT>
                   </STRONG></P>
                  </td>
                  <td align="left" class=mainLabel width="40%"><P align=center>
                  &nbsp;<SELECT id=select1 name=select1 style="HEIGHT: 22px; WIDTH: 145px" title="Category ID"  onchange="getDetails()">
                  <option value=-1 >select the category</option>
                  <c:forEach items="${sessionScope.categories}" var="item" >
                 
<OPTION value='${item.categoryId}'>${item.categoryName}</OPTION>
                    
</c:forEach>
         
                  </SELECT><FONT
                  face="Bookman Old Style"> </FONT></P>
                  </td>
                </tr>
                <tr>
                <td colspan = 2>
                  <P align=center>&nbsp;</P>

                </td>
                </tr>
                <TR>
                   <TD align="right">
                  <P align=center><FONT
                  face="Bookman Old Style">&nbsp;<STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <FONT color=midnightblue>Product Name
                  </FONT>
                     :</STRONG> </FONT></P>
                   </TD>
	               <td align="left" class=mainLabel>
                  <P align=center>
	               &nbsp;&nbsp;
	               <SELECT id=select2
                  name=select2 style="HEIGHT: 22px; WIDTH: 145px"
                  title="categoryID"> 
                  <option value="-1">select the product</option>
                  <c:forEach items="${sessionScope.prodList}" var="prod">
                  
                  <option value="${prod.categoryId} ${prod.productId}"> ${prod.productName}</option>
                  </c:forEach>
                  </SELECT></P></td>
            
                    
                  <td width="11">
                  <P align=center>&nbsp;</P></td>
                  <td class=mainLabel colspan="2" align="right" width="442">
                  <P align=center>&nbsp;</P></td>
               </TR>
                <tr>
                <td colspan = 2>
                  <P align=center> </P>

                </td>
                </tr>
                <tr>
                <td align="middle" colspan = 2>
                  <P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="submit" value="next" onclick="return checkTheSelect()">
                </td>
                </tr>
               <tr>
            <td width="10">&nbsp;</td>
            <td width="10">&nbsp;</td>
            <td width="10">&nbsp;</td>
            <td width="10">&nbsp;</td>
          </tr>


    <tr valign="bottom">
      <td class="blueBackGround" colspan="6" width="925"></td>
    </tr></TBODY>
  </table>

<p>&nbsp;</p></TD></TR></TBODY></TABLE>

<P align=center><STRONG><A href="catalog.do"
     >VIEW CATELOG</A></STRONG></P></TD></TR></TBODY></TABLE>
</body>
</html>