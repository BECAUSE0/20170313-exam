<%@page import="com.hand.entity.filmEntity"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>select</title>
</head>
<body>
<table>
<tr>
<th width="150"><div align="center">编号</div></th>
<th width="150"><div align="center">名称</div></th>
<th width="150"><div align="center">描述</div></th>
<th width="150"><div align="center">语言</div></th>
</tr>

<% 
List list = (List)request.getAttribute("list");
for(int i=0;i<list.size();i++){
filmEntity f = list.get(i);
%>

<tr>
<td><div align="center"><%=f.getFilm_id()%></div></td>
<td><div align="center"><%=f.getTitle() %></div></td>
<td><div align="center"><%=f.getDesc() %></div></td>
<td><div align="center"><%=f.getLang() %></div></td>
<td>
	<div align="center"><a onClick="javascript:if(!confirm('你确定要删除该信息吗?')) return false;" 
		href="DelServlet?fId=<%=f.getFilm_id()%>">删 除</a>    </div></td>
</tr>

<%
}
%>

</table>
</body>
</html>