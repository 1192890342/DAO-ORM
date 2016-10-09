<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mldn.css">
<script type="text/javascript" src="js/members_add.js"></script>
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/laydate/laydate.js"></script> 
</head>
<body>
	<table bgcolor="#f2f2f2" width="100%">
		<form action="members_add_do.jsp" method="post" id="myForm" enctype="multipart/form-data">
			<tr id="eleTr">
				<td colspan="3">雇员增加</td>
			</tr>
			<tr id="eleTr"> 
				<td width="10%">雇员编号</td>
				<td width="20%"><input type="text" id="mid" name="mid" class="init"></td>
				<td>雇员编号只允许4位</td> 
			</tr>
			<tr id="eleTr">
				<td>雇员姓名</td>
				<td><input type="text" id="name" name="name" class="init"></td>
				<td>雇员姓名不允许为空</td>
			</tr>
			<tr id="eleTr">
				<td>年龄</td>
				<td><input type="text" id="age" name="age" class="init"></td>
				<td>请输入您的年龄</td>
			</tr>
			<tr id="eleTr">
				<td>生日</td>
				<td><input type="text" id="birthday" name="birthday" class="init"></td>
				<td>请选择您的生日</td>
			</tr>
			<tr id="eleTr">
				<td>工资</td>
				<td><input type="text" id="salary" name="salary" class="init"></td>
				<td>请输入您的月收入</td>
			</tr>
			<tr id="eleTr">
				<td>个人简介</td>
				<td><input type="text" id="note" name="note" class="init"></td>
				<td>自我介绍</td>
			</tr>
			<tr id="eleTr">
				<td>照片</td>
				<td><input type="file" id="photo" name="photo"></td> 
				<td>请选择您的照片</td>
			</tr> 
			<tr id="eleTr">
				<td colspan="3">
					<input type="submit" value="增加">
					<input type="reset" value="重置">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>