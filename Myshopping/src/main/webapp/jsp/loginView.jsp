<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
     
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
    	$(".regeist").click(function(){
    		window.open("/Myshopping/register","_self");
        })
    });
        
    </script>
  </head>
  
  <body topmargin="0" background="images/myBack.jpg">
    <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td>
    <form action="checkUser" method="post">
    <table width="100%" border="1" cellspacing="0" cellpadding="0" class="comm">
      <tr>
        <td align="center">
        <img src="images/cartnavi-2.gif">
        </td>
      </tr>
      <tr>
        <td align="center"><table  width="40%" border="1" cellpadding="0" cellspacing="0" bordercolor="#339900" class="comm">
          <tr>
            <td colspan="2" align="center">
            <img   src="images/dl.gif">
            </td>
          </tr>
          <tr>
            <td width="49%" align="right">用户名:</td>
            <td width="51%" align="left"><input name="username" type="text" class="comm" /></td>
          </tr>
          <tr>
            <td align="right">密码:</td>
            <td align="left"><input name="passwd" type="password" class="comm" /></td>
          </tr>
          
          <!-- 下面是验证码 -->
          <tr>
            <td>
                <div class="col-sm-4 control-label" align="right">
					<label id="password-lbl" for="password" class="required">验证码 ：</label>
				</div>
		    </td>
				
			<td>
					<!-- 验证码文本框 -->
					<input type="text" name="checkCode" id="checkCode" value=""
											class="validate-password required" style="float: left; height: 50px; "
											title="验证码区分大小写" size="14"  maxlength="4" 
											 /> 
					<!-- 显示验证码 -->
					<img src="/Myshopping/CheckCodes" name="checkCode" onClick="myReload()" width="116"
							height="43" class="img_checkcode" id="img_checkCode" />
			</td>
			
          </tr>
          <!-- 上面是验证码 -->
          
          <tr>
            <td align="right"><input type="submit" name="Submit" value="用户登录" /></td>
            <td align="left"><input class="regeist" type="button" name="Submit2" value="用户注册" />
            <input type="reset" name="Submit3" value="重置" />
            </td>
            
          </tr>
        </table> 
        
        </td>
      </tr>
      <tr>
        <td width="50%" align="right"><img src="images/cartnext.gif" width="87" height="19" /></td>
      </tr>
    </table>
    </form>
    </td>
  </tr>
  <tr>
    <td align="center">
    <jsp:include flush="true" page="foot.jsp"></jsp:include>
    </td>
  </tr>
</table>

    <script language="javascript">
		//刷新验证码
		function myReload() {
			document.getElementById("img_checkCode").src = document.getElementById("img_checkCode").src + "?nocache=" + new Date().getTime();
		}
	</script>
  </body>
</html>
