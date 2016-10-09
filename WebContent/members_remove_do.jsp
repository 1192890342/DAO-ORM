<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.jspsmart.upload.SmartUpload"%>
<%@ page import="java.util.*"%>
<%@ page import="com.jspsmart.upload.SmartFile"%>
<%@ page import="cn.mldn.vo.*"%>
<%@ page import="cn.mldn.factory.*"%>
<%@ page import="cn.mldn.service.*"%>
<%@ page import="cn.mldn.service.impl.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mldn.css">  
<script type="text/javascript" src="js/members_remove_do.js"></script>
<script type="text/javascript" src="js/util.js"></script>
</head>
<body>
	<%
		IMembersService s = ServiceFactory.getInstance(MembersServiceImpl.class) ;
		String ids = request.getParameter("ids") ; 
		String result[] = ids.split("\\|") ; 
		Set<Integer> set = new HashSet<Integer>() ;
		for(int x = 0 ; x<result.length ; x++){
			set.add(Integer.parseInt(result[x])) ; 
		}
	%>
	<%
		String msg = "数据删除失败" ;  
			if(s.remove(set)){
				msg = "数据删除成功!!" ; 
			}
	%>
	<div> 
		<div><%=msg%></div>
		<div><span id="mytime">3</span>秒后开始跳转！</div>
	</div>
</body>
</html>