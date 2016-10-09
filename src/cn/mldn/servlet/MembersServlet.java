package cn.mldn.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.Tomcat;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import cn.mldn.factory.ServiceFactory;
import cn.mldn.service.IMembersService;
import cn.mldn.service.impl.MembersServiceImpl;
import cn.mldn.vo.Members;
@SuppressWarnings("serial")
@WebServlet("/MembersServlet")
public class MembersServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse responst) throws ServletException, IOException {
	}
	public void doPost(HttpServletRequest request, HttpServletResponse responst) throws ServletException, IOException {
		this.doGet(request, responst);
	}
}
