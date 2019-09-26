<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo1114.factory.*,demo1114.vo.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	request.setCharacterEncoding("GBK") ;	%>
<%
	String keyWord = request.getParameter("kw") ;
	if(keyWord == null){
		keyWord = "" ;	// 如果没有查询关键字，则查询全部
	}
	List<Emp> all = DAOFactory.getIEmpDAOInstance().findAll(keyWord) ;
	Iterator<Emp> iter = all.iterator() ;
%>
<center>
<form action="ListEmp.jsp" method="post">
	请输入查询关键字：<input type="text" name="kw">
	<input type="submit" value="查询">
</form>
<table border="1" width="80%"> 
	<tr>
		<td>雇员编号</td>
		<td>雇员姓名</td>
		<td>雇员工作</td>
		<td>雇佣日期</td>
		<td>基本工资</td>
		<td>奖金</td>
	</tr>
<%
	while(iter.hasNext()){
		Emp emp = iter.next() ;
%>
	<tr>
		<td><%=emp.getEmpno()%></td>
		<td><%=emp.getEname()%></td>
		<td><%=emp.getJob()%></td>
		<td><%=emp.getHiredate()%></td>
		<td><%=emp.getSal()%></td>
		<td><%=emp.getComm()%></td>
	</tr>
<%
	}
%>
</table>
</center>
</body>
</html>