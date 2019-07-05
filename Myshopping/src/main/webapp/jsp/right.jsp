<%@ page language="java" import="java.util.*,com.fjt.pojo.*" 
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	
%>
<%
	//获取数据
	ArrayList al = (ArrayList)request.getAttribute("bookList");
    
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="com">
	<tr>
		<td colspan="3" align="left">
			<img src="images/booksTop.gif" width="436" height="63" />
		</td>
	</tr>
	<%
			int k=0;
			for (int i = 0; i < 2; i++) {
	%>
	<tr>
		<%
					for (int j = 0; j < 3; j++) {
					Book book=new Book();
					if(k<al.size()){
						book = (Book) al.get(k);
					}else{
						
						book.setId(0l);
						book.setName("没有该书");
						book.setInfo("没有了");
						book.setPhoto("none.jpg");
						book.setPrice(0.0f);
					}
		%>
		<td width="33%" height="168" align="center">
			<table width="100%" height="168" border="0" cellpadding="0"
				cellspacing="0" class="com">
				<tr>
					<td width="112" height="112" rowspan="3">
						<img src="images/<%=book.getPhoto()%>" width="112" height="112" />
					</td>
					<td width="130" height="48">

					</td>
				</tr>
				<tr>
					<td height="33" valign="top">
					<a href="ShowGoodsServlet?type=showDetail&goodsId=<%=book.getId() %>"><%=book.getName()%></a>	
					</td>
				</tr>
				<tr>
					<td height="22" valign="top">
						价格:
						<%=book.getPrice()%>
						
					</td>
				</tr>
				<tr>
					<td colspan="2" valign="top">
						简单介绍：
						<%=book.getInfo()%>
					</td>
				</tr>
			</table>
		</td>
		<%
		k++;
		}
		%>

	</tr>


	<%
	if (i == 0) {
	%>
	<tr>
		<td height="10" bgcolor="pink" colspan="3" align="center"></td>
	</tr>
	<%
	}
	}
	%>

</table>
