package cn.biz.student.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.biz.student.domain.Student;
import cn.biz.student.service.IStudentManagerService;
import cn.biz.student.service.impl.StudentManagerServiceImpl;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/editUI")
public class EditStudentUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentManagerService sms = new StudentManagerServiceImpl();
		String id = request.getParameter("id");
		Student s = sms.findStudentById(id);
		request.setAttribute("student", s);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
