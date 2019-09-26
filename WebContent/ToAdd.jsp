<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo1114.factory.*,demo1114.vo.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	request.setCharacterEncoding("GBK");	%>
<%
	Emp emp = new Emp() ;
	emp.setEmpno(Integer.parseInt(request.getParameter("empno"))) ;
	emp.setEname(request.getParameter("ename")) ;
	emp.setJob(request.getParameter("job")) ;
	emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"))) ;
	emp.setSal(Float.parseFloat(request.getParameter("sal"))) ;
	emp.setComm(Float.parseFloat(request.getParameter("comm")));
try{
	if(DAOFactory.getIEmpDAOInstance().doCreate(emp)){
%>
		<h3>雇员信息添加成功！</h3>
<%
	} else {
%>
		<h3>雇员信息添加失败！</h3>
<%
	}
%>
<%
}catch(Exception e){
	e.printStackTrace() ;
}
%>
</body>
</html>