<%@ page language="java" import="java.util.*,com.fjt.pojo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//得到要显示的Book
Book book=(Book)request.getAttribute("bookInfo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书详细信息界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	<script type="text/javascript">
	
		//响应用户点击返回购物大厅的请求
		function goToHall(){
			
			window.open("./","_self");
		}
	
		//响应用户购买商品的请求
		function addGoods(bookId){
			window.open("addshopping?bookId="+bookId,"_self");
		}
	
	</script>

  </head>
  
  <body topmargin="0"  background="images/myBack.jpg">
  <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0" class="comm">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="1" cellspacing="0" cellpadding="0" class="comm">
      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td width="25%" rowspan="8"><img src="images/<%=book.getPhoto() %>" width="136" height="169" /></td>
        <td width="75%" align="center"><%=book.getName()%></td>
      </tr>
      <tr>
        <td align="left">价格：¥<%=book.getPrice() %></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="left">ISBN：<%=book.getId() %></td>
      </tr>
      
      <tr>
        <td align="left">出版商：<%=book.getPublishHousr() %></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="78" align="left" valign="bottom"><%=book.getInfo() %></td>
      </tr>
      <tr>
        <td colspan="2"><input type="button" onclick="addGoods(<%=book.getId() %>);"  value="加入购物车" />
          <input type="submit" name="Submit2" onclick="goToHall();" value="返回购物大厅" /></td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
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
