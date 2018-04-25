package cn.biz.student.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.biz.student.service.IStudentManagerService;
import cn.biz.student.service.impl.StudentManagerServiceImpl;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentManagerService sms = new StudentManagerServiceImpl();
		String id = request.getParameter("id");
		sms.deleteStudentById(id);
		response.sendRedirect(request.getContextPath()+"/index");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
