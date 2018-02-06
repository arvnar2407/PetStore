<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../CSS/Stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalog</title>
</head>
<body>
<p align="right">
<a href="logout.do"> logout</a>
</p>
<c:if test="${empty sessionScope.uid}">
<c:redirect url="Login.jsp"></c:redirect>
</c:if>
<form method="post" name="Search" action="">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <TBODY>
 <tr>
      <td align="right" width="11">&nbsp;</td><!-- #BeginEditable "page title" -->
      <td class="lblTitle" width="100%"><FONT
      face="Bookman Old Style" ><STRONG>CATALOGUE</STRONG></FONT></td><!-- #EndEditable -->
      <td width="267" align="right" valign="top"><IMG height=120 src="../IMAGES/gssmlanm.gif" width=100></td>
    </tr>
    <tr align="left">
      <td class="blueBackGround" colspan="3" width="100%"></td>
    </tr>
    <tr align="left" valign="top">
      <td class="orangeBackGround" colspan="3" width="100%">
      <P>&nbsp;</P></td><!-- #BeginEditable "processName" --><!-- #EndEditable -->
    </tr>
    <tr align="left" valign="top">
      <td colspan="3" width="925">
		&nbsp;
      </td><!-- #BeginEditable "processName" --><!-- #EndEditable -->
    </tr>


    <tr>
      <td colspan="3" height="15" width="100%">
      <P><!-- #BeginEditable "Process" --></P>
      <P>
      <TABLE align=center border=2 cellPadding=2 cellSpacing=2 class=outerTable
      id=TABLE1 width="100%">

       <TR>
          <TD class=tblHeader height=10 width="15%">CTGY ID</TD>
          <TD class=tblHeader height=10 width="35%">CATEGORY NAME</TD>
          <TD class=tblHeader height=10 width="50%">CATEGORY DESCRIPTION</TD>
      </TR>
       <c:forEach items="${sessionScope.categories}" var="item" >
        <TR>
          <TD class=tblDataText><A
            href="productDescription.do?cid=${item.categoryId}">&nbsp;
            ${item.categoryId} </A>  </TD>
          <TD class=tblDataText>&nbsp; ${item.categoryName}</TD>
          <TD class=tblDataText>&nbsp; ${item.categoryDescription}</TD>
		</TR>
</c:forEach>
       
		</TABLE>
</td>
<p>&nbsp;
    <P></P>
    <P></P>
    <P></P>
    <P></P>
    <P></P>
    <P></P></tr></TBODY></table>
<P>&nbsp;</P>
</form>
</body>
</html>