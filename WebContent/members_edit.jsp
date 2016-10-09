<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.mldn.vo.*"%>
<%@ page import="cn.mldn.factory.*"%>
<%@ page import="cn.mldn.service.*"%>
<%@ page import="cn.mldn.service.impl.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
<link rel="stylesheet" type="text/css" href="css/mldn.css">
<script type="text/javascript" src="js/members_edit.js"></script>
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/laydate/laydate.js"></script>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8") ; 
		IMembersService s = ServiceFactory.getInstance(MembersServiceImpl.class) ; 
		Integer mid = Integer.parseInt(request.getParameter("mid")) ; 
		Members vo = s.editPre(mid) ;  
	%>
	<table bgcolor="#f2f2f2" width="100%">
		<form action="members_edit_do.jsp" method="post" id="myForm" enctype="multipart/form-data">
			<tr id="eleTr">
				<td colspan="3">雇员修改</td> 
				<td style="width:40%" rowspan="7"><img src="upload/<%=vo.getPhoto()%>" style="width:50%"></td>
			</tr> 
			<tr id="eleTr">
				<td>雇员姓名</td>
				<td><input type="text" id="name" name="name" class="init" value="<%=vo.getName()%>"></td>
				<td>雇员姓名不允许为空</td>
			</tr>
			<tr id="eleTr">
				<td>年龄</td>
				<td><input type="text" id="age" name="age" class="init" value="<%=vo.getAge()%>"></td>
				<td>请输入您的年龄</td>
			</tr>
			<tr id="eleTr">
				<td>生日</td>
				<td><input type="text" id="birthday" name="birthday" class="init" value="<%=vo.getBirthday()%>"></td>
				<td>请选择您的生日</td>
			</tr>
			<tr id="eleTr">
				<td>工资</td>
				<td><input type="text" id="salary" name="salary" class="init" value="<%=vo.getSalary()%>"></td>
				<td>请输入您的月收入</td>
			</tr>
			<tr id="eleTr">
				<td>个人简介</td>
				<td><input type="text" id="note" name="note" class="init" value="<%=vo.getNote()%>"></td>
				<td>自我介绍</td>
			</tr>
			<tr id="eleTr">
				<td>照片</td>
				<td><input type="file" id="photo" name="photo"></td> 
				<td>请选择您的照片</td>
			</tr> 
			<tr id="eleTr">
				<td colspan="3">
				<input type="hidden" id="oldpic" name="oldpic" value="<%=vo.getPhoto()%>">
					<input type="hidden" id="mid" name="mid" value="<%=vo.getMid()%>">
					<input type="submit" value="修改">
					<input type="reset" value="重置">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>