<%@ page language="java" import="java.util.*,com.fjt.pojo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//得到request的商品
ArrayList al=(ArrayList)request.getAttribute("shoppInfo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="js/cartInfo.js"></script>

     
  </head>
  
  <body topmargin="0"  background="images/myBack.jpg">
  	<table width="80%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="41" align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="67" align="center">
    <table width="100%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center"><img src="images/cartnavi-1.gif" width="599" height="49" /></td>
  </tr>
  <tr>
    <td align="center">
    <form action="###">
	<table width="100%"  border="1" cellpadding="0" cellspacing="0" class="com">
      <tr>
        <td  width="20%" align="center">编号</td>
        <td width="27%" align="center">名称</td>
        <td width="26%" align="center">单价</td>
        <td colspan="3">数量</td>
      </tr>
	 	<tr><td colspan="6" bgcolor="#CCCCCC" height="5"></td></tr>
      
      <%
      
      
      	for(int i=0;i<al.size();i++){
      		
      		
      		Book book=(Book)al.get(i);
      		%>
      		<tr>
	        <td align="center"><%=i+1%>
	        <input type="hidden" id="bookID<%=i%>"  name="bookID" value="<%=book.getId()%>" />
	        <input type="hidden" id="sum" name="sum" value="<%=al.size()%>"/>
	        </td>
	        <td align="center"><a href="#"><%=book.getName() %></a></td>
	        <td align="center">￥<%=book.getPrice() %> </td>
	        <td width="10%"><input  id="acount<%=i%>" name="textfield" type="text" size="6" value="<%=book.getAmount() %>" /></td>
	        <td width="10%" align="center"><a href="/Myshopping/MyCartDelet?id=<%=book.getId() %>">删除</a></td>
	        <td width="7%" align="center"><a href="#">查看</a></td>
     		
     		</tr>
	  		<tr><td colspan="6" bgcolor="#CCCCCC" height="5"></td></tr>
      		<%
      	}
      
       %>
      
      <tr>
        <td>&nbsp;</td>
        <td align="center"><input type="button" id="deltAll" name="Submit" value="删除全部书籍" /></td>
        <td align="center"><input name="Submit2" id="updtaCount" type="button" value="修 改 数 量" /></td>
        <td colspan="3">&nbsp;</td>
      </tr>
    </table>
	</form>
	</td>
  </tr>
  <tr>
    <td><table width="100%" border="1" cellspacing="0" cellpadding="0" class="com">
      <tr>
        <td width="49%" class="comm">您共选择了价值<span class="STYLE1">${totalPrice}</span>的商品,点<a href="./"> 此处 </a>继续购物。</td>
        <td width="51%" align="right"><a href="/Myshopping/goMyOrderView" ><button>结算</button></a></td>
      </tr>
    </table></td>
  </tr>
</table>
    </td>
  </tr>
  <tr>
    <td height="56" align="center">
    <jsp:include flush="true" page="foot.jsp"></jsp:include>
    </td>
  </tr>
  

</table>
<%--幕布 --%>
<%--幕布位置一定要在删除视图前面，不然删除视图会隐藏在里面 --%>
<div class="mubu"> </div>
 
<!--删除所有视图-->
<div class="deleAllView">
<div class="delteAl">
<span>确定删除所有信息吗？</span><br/>	
<input type="button" value="确定" class="delAll_sure">
<input type="button" value="取消" class="delAll_canl">
</div>
</div>


  </body>
</html>
