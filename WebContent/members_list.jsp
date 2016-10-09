<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.mldn.vo.*"%>
<%@ page import="cn.mldn.factory.*"%>
<%@ page import="cn.mldn.service.*"%>
<%@ page import="cn.mldn.service.impl.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/members_list.js"></script>
<script type="text/javascript" src="js/util.js"></script>
</head>
<body>
			<%
			request.setCharacterEncoding("utf-8");
			int currentPage = 1 ; 
			int lineSize = 10 ; 
			int allRecorders = 0 ;
			String columnData = "雇员编号:mid|雇员姓名:name" ; 
			String column = null ; 
			String keyWord = null ; 
		%>
		<%
			try{
				currentPage = Integer.parseInt(request.getParameter("cp")) ; 
			}catch(Exception e){}
			try{
				lineSize = Integer.parseInt(request.getParameter("ls")) ; 
			}catch(Exception e){}
			column = request.getParameter("col") ; 
			keyWord = request.getParameter("kw") ;
			if(keyWord==null){
				keyWord = "" ; 
			}
		%>
		<%
			IMembersService s = ServiceFactory.getInstance(MembersServiceImpl.class) ;
			Map<String,Object> map = s.listSplip(column, keyWord, currentPage, lineSize) ; 
			allRecorders = (Integer) map.get("membersCount"); 
			List<Members> all =(List<Members>) map.get("allMembers") ; 
			Iterator<Members> iter = all.iterator() ; 
			Members vo = new Members() ; 
		%>
		   	<jsp:include page="/pages/plugins/split_page_search_plugin.jsp">
				<jsp:param name="url" value="members_list.jsp"/>
				<jsp:param name="allRecorders" value="<%=allRecorders%>"/>
				<jsp:param name="columnData" value="<%=columnData%>"/>
				<jsp:param name="column" value="<%=column%>"/>
				<jsp:param name="keyWord" value="<%=keyWord%>"/>
			</jsp:include>
		   
	<table width="100%" bgcolor="#f2f2f2"> 
		<tr id="eleTr">
			<td colspan="9"><font color="red">雇员列表</font></td> 
		</tr> 
		<tr id="eleTr"> 
			<td width="5"><input type="checkbox" id="selall" name="selall"></td>
			<td width="5%">雇员编号</td>
			<td width="8%">姓名</td>  
			<td width="3%">年龄</td> 
			<td width="10%">生日</td>
			<td width="8%">工资</td> 
			<td width="10%">个人说明</td> 
			<td width="40%">雇员照片</td> 
			<td width="15%">操作</td>
		</tr> 
		<%
			while(iter.hasNext()){
				vo = iter.next() ;
		%>
			<tr id="eleTr"> 
				<td><input type="checkbox" id="mid" name="mid" value="<%=vo.getMid()%>"></td>
				<td><%=vo.getMid()%></td>
				<td><%=vo.getName()%></td>
				<td><%=vo.getAge()%></td> 
				<td><%=vo.getBirthday()%></td> 
				<td><%=vo.getSalary()%></td>
				<td><%=vo.getNote()%></td>
				<td><img src="upload/<%=vo.getPhoto()%>" style="width:10%"></td>
				<td><a href="members_edit.jsp?mid=<%=vo.getMid()%>">修改</a></td>
			</tr>
		<%
			}
		%>
	</table>
			<input type="button" id="deleteBut" value="删除所选项">
				<jsp:include page="/pages/plugins/split_page_bar_plugin.jsp">
				<jsp:param name="url" value="members_list.jsp"/>
				<jsp:param name="currentPage" value="<%=currentPage%>"/>
				<jsp:param name="lineSize" value="<%=lineSize%>"/>
				<jsp:param name="keyWord" value="<%=keyWord%>"/>
				<jsp:param name="column" value="<%=column%>"/>
				<jsp:param name="allRecorders" value="<%=allRecorders%>"/>
			</jsp:include>
</body>
</html>