<%@page import="com.fjt.pojo.Book"%>
<%@page import="com.fjt.pojo.Users"%>
<%@ page language="java" import="java.util.*,com.fjt.pojo.Users" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

ArrayList al=(ArrayList)request.getAttribute("mycart");
Users user=(Users)session.getAttribute("loginUser");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>确认订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/my.css">
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="js/orderSure.js"></script>

  </head>
  
  <body topmargin="0"  background="images/myBack.jpg">
    <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0" class="com">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="1" cellspacing="0" cellpadding="0" class="com">
      <tr>
        <td height="42" align="center"><img src="images/cartnavi-3.gif" width="599" height="49" /></td>
      </tr>
      <tr>
        <td height="97"><table width="70%" border="1" align="center" cellpadding="0" cellspacing="0" class="comm">
          <tr>
            <td colspan="2" align="center">购买人的信息</td>
          </tr>
          <tr>
            <td align="right">用 户 名：</td>
            <td width="52%"><input type="text" name="textfield" value="<%=user.getName() %>" /></td>
          </tr>
          
         
          <tr>
            <td align="right"><span style="color: red;">*</span>联系电话：</td>
            <td><input type="text" name="textfield4" value="<%=user.getTel() %>" /></td>
          </tr>
          <tr>
            <td align="right"><span style="color: red;">*</span>电子邮件：</td>
            <td><input type="text" name="textfield5" value="<%=user.getEmail() %>" /></td>
          </tr>
          
        </table></td>
      </tr>
      <tr>
        <td><table width="70%" border="1" align="center" cellpadding="0" cellspacing="0" class="comm">
          <tr>
            <td colspan="4" align="center">我的购物车情况</td>
          </tr>
          <tr>
            <td align="center">编号</td>
            <td align="center">商品名称</td>
            <td>单价</td>
            <td>数量</td>
          </tr>
          <%
          
          	for(int i=0;i<al.size();i++){
          	Book bk=(Book)al.get(i);
          		%>
          		<tr>
	            <td align="center"><%=bk.getId() %></td>
	            <td align="center"><%=bk.getName() %></td>
	            <td>¥<%=bk.getPrice() %></td>
	            <td><%=bk.getAmount() %></td>
          		</tr>
          		<%
          	}
           %>
          <tr>
            <td colspan="4">您共选择了价值¥<%=request.getAttribute("totalPrice")%>的商品。</td>
          </tr>
          <tr>
            <td colspan="4" align="center"><input id="return" name="Submit22" type="button" value="返回购物车" />
            <input id="subOrder" name="Submit22" type="button" value="提交订单" /></td>
            
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="right"><a href="#"><img border="0" src="images/cartpre.gif" width="87" height="19" /></a>
        <a href="GoodsOrderCl"><img border="0" src="images/cartnext.gif" width="87" height="19" /></a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
    <jsp:include flush="true" page="foot.jsp"></jsp:include>
    </td>
  </tr>
</table>
  </body>
</html>
