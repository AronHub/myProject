<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="js/regeist.js"></script>
     
  </head>
  
  <body topmargin="0" background="images/myBack.jpg" >
    <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="33" align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="68" align="center">
    <table  width="50%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#339900" class="com">
  <tr>
    <td height="25" colspan="2" align="center" bgcolor="#FFFF66">用户注册</td>
  </tr>
  <tr>
    <td width="36%" height="29" align="right">用户名:</td>
    <td width="64%" align="center"><input type="text" name="userName" /></td>
  </tr>
  <tr>
    <td height="28" align="right">密&nbsp;&nbsp;码:</td>
    <td align="center"><input type="text" name="passwd" /></td>
  </tr>
    <tr>
    <td width="36%" height="29" align="right">邮箱:</td>
    <td width="64%" align="center"><input type="text" name="email" /></td>
  </tr>
    <tr>
    <td width="36%" height="29" align="right">电话:</td>
    <td width="64%" align="center"><input type="text" name="tel" /></td>
  </tr>
  <tr>
    <td height="34" colspan="2" align="center">
    <input id="userRegist" type="submit" name="Submit2" value="注 册" />
    </td>
  </tr>
</table>
    </td>
  </tr>
  <tr>
    <td height="46" align="center">
    <jsp:include flush="true" page="foot.jsp"></jsp:include>
    </td>
  </tr>
</table>
  </body>
</html>
