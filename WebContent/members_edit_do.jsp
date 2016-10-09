<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.jspsmart.upload.SmartFile"%>
<%@ page import="cn.mldn.vo.*"%>
<%@ page import="cn.mldn.factory.*"%>
<%@ page import="cn.mldn.service.*"%>
<%@ page import="cn.mldn.service.impl.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.jspsmart.upload.SmartUpload"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mldn.css">
<script type="text/javascript" src="js/members_edit_do.js"></script>
<script type="text/javascript" src="js/util.js"></script>
</head> 
<body> 
		<%
		SmartUpload smart = new SmartUpload() ; 
			smart.initialize(this.getServletConfig(),request,response); 
			smart.upload();
			request.setCharacterEncoding("UTF-8") ; 
			SmartFile file = smart.getFiles().getFile(0) ;
			String fileName = null ;
			if (file.getSize() > 0){
				 fileName = UUID.randomUUID() + "." + file.getFileExt() ;
				 String filePath = this.getServletContext().getRealPath("/upload/") + fileName ;
				 file.saveAs(filePath);
			}
			IMembersService s = ServiceFactory.getInstance(MembersServiceImpl.class) ; 
			Members vo = new Members() ;
			vo.setMid(Integer.parseInt(smart.getRequest().getParameter("mid"))) ; 
			vo.setName(smart.getRequest().getParameter("name")) ; 
			vo.setAge(Integer.parseInt(smart.getRequest().getParameter("age"))) ;
			vo.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(smart.getRequest().getParameter("birthday"))) ; 
			vo.setSalary(Double.parseDouble(smart.getRequest().getParameter("salary"))) ;
			vo.setNote(smart.getRequest().getParameter("note")) ;
			vo.setPhoto(fileName);
			String msg = "数据修改失败" ;  
			if(s.edit(vo)){
				msg = "数据修改成功!!" ; 
			}
		%>
	<div> 
		<div><%=msg%></div>
		<div><span id="mytime">3</span>秒后开始跳转！</div>
	</div>
</body>
</html>