<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String time =(String)request.getSession().getAttribute("time");
if(time!=null){
	time=URLDecoder.decode(time,"utf-8");
}
 
// HttpSession sessions=(HttpSession)request.getSession().getAttribute("loginUser");
%>
<!-- 头部界面 -->

<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="100%" height="8" colspan="3" bgcolor="#FFCCCC"></td>
      </tr>
      <tr>
        <td width="24%" height="78"><img src="images/logo.gif" width="128" height="49" /></td>
        <td width="39%" align="center" ><img src="images/test.gif" width="300" height="80" /></td>
        <td  width="10%"  align="center" ><span>用户：${loginUser.name}</span><br/>
        <span><%=time %></span>
        </td>
        
        <td width="10%" align="center" class="com"><p><img src="images/account.gif" width="19" height="14" /><a href="/Myshopping/login">【我的账号】</a></p>
          <p><img src="images/cart.gif" width="20" height="15" /><a href="/Myshopping/showMyShop">【我的购物】</a></p>
          <p><img src="images/account.gif" width="20" height="15" /><a href="/Myshopping/safeExit">【安全退出】</a></p></td>
            
          <td>访问人数：${nums}</td>
       </tr>
      <tr>
        <td width="100%"  height="8" colspan="3" bgcolor="#FFCCCC"></td>
        </tr>
      <tr>
        <td colspan="3"><table width="100%" border="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
            <td width="15%" class="navi"><a href="/Myshopping/">首页</a></td>
            <td>&nbsp;</td>
            <td width="15%" class="navi">香港电影</td>
            <td>&nbsp;</td>
            <td width="15%" class="navi">大陆电影</td>
            <td>&nbsp;</td>
            <td width="15%" class="navi">关于我们</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        </tr>
    </table>
