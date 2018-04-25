package cn.biz.student.web.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.biz.student.domain.Student;
import cn.biz.student.service.IStudentManagerService;
import cn.biz.student.service.impl.StudentManagerServiceImpl;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IStudentManagerService sms = new StudentManagerServiceImpl();
		String name = request.getParameter("name");
		String birthdayString = request.getParameter("date");
		String mark = request.getParameter("mark");
		String scoreString = request.getParameter("score");
		int score = Integer.parseInt(scoreString);
		Student s = new Student(name, mark, birthdayString, score);
		sms.saveStudent(s);
		response.sendRedirect(request.getContextPath()+"/index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
