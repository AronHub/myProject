<%@ page language="java" import="java.util.*,com.fjt.pojo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table width="100%" border="0" cellspacing="0"  cellpadding="0">
 <!--  <tr>
    <td><table width="100%" border="0" cellspacing="0"  cellpadding="0">
      <tr>
        <td height="34" align="center" valign="top"><img src="images/banner.bmp" /></td>
      </tr>
      <tr>
        <td height="91" align="center" valign="top"><script language="javascript" src="js/banner.js"></script></td>
      </tr>
    </table></td>
  </tr> -->
  
  
  <tr>
   <td height="68" align="center"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="3" align="center"><img src="images/hot.gif" width="170" height="63" /></td>
      </tr>
      <tr>
        <td width="17%" align="center" class="navi">排行</td>
        <td width="50%" align="center" class="navi">最近浏览商品名称</td>
        <td width="33%" align="center" class="navi">浏览次数</td>
      </tr>
 
  <%
  
  List<Book> list = (List<Book>) request.getSession()
	.getAttribute("lastBook");
  if(list!=null){
	  for(int i=0;i<list.size();i++){
		  if(i>=6){
			    break;
			}
		%>  
		
       <tr>
        <td align="center" class="com">1</td>
        <td align="center" class="com"><a href="Untitled-1.html"><%=list.get(i).getName()%></a></td>
        <td align="center" class="com">120</td>
      </tr>
   
   <%
		  }
		  
	  
	  
  }
  %>
   </table></td>

  </tr>
  
  
  
  <tr>
    <td height="10" bgcolor="pink" align="center"></td>
  </tr>
  <tr>
    <td height="68" align="center"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="3" align="center"><img src="images/hot.gif" width="170" height="63" /></td>
      </tr>
      <tr>
        <td width="17%" align="center" class="navi">排行</td>
        <td width="50%" align="center" class="navi">商品名称</td>
        <td width="33%" align="center" class="navi">点击次数</td>
      </tr>
      <tr>
        <td align="center" class="com">1</td>
        <td align="center" class="com"><a href="Untitled-1.html">笑傲江湖2</a></td>
        <td align="center" class="com">120</td>
      </tr>
      <tr>
        <td align="center" class="com">2</td>
        <td align="center" class="com"><a href="Untitled-1.html">笑傲江湖</a></td>
        <td align="center" class="com">120</td>
      </tr>
      <tr>
        <td align="center" class="com">3</td>
        <td align="center" class="com"><a href="Untitled-1.html">笑傲江湖</a></td>
        <td align="center" class="com">120</td>
      </tr>
      <tr>
        <td align="center" class="com">4</td>
        <td align="center" class="com"><a href="Untitled-1.html">笑傲江湖</a></td>
        <td align="center" class="com">120</td>
      </tr>
      <tr>
        <td align="center" class="com">5</td>
        <td align="center" class="com"><a href="Untitled-1.html">笑傲江湖</a></td>
        <td align="center" class="com">120</td>
      </tr>
      <tr>
        <td align="center" class="com">6</td>
        <td align="center" class="com"><a href="Untitled-1.html">笑傲江湖</a></td>
        <td align="center" class="com">120</td>
      </tr>
      <tr>
        <td align="center" class="com">7</td>
        <td align="center" class="com"><a href="Untitled-1.html">笑傲江湖</a></td>
        <td align="center" class="com">120</td>
      </tr>
    </table></td>
  </tr>
</table>
