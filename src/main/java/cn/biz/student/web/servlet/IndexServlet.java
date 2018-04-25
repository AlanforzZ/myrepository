package cn.biz.student.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.biz.student.domain.PageBean;
import cn.biz.student.service.IStudentManagerService;
import cn.biz.student.service.impl.StudentManagerServiceImpl;

/**
 * @author Alan
 * 主页面servlet
 */
@WebServlet(name = "index",urlPatterns = "/index",loadOnStartup = 0)
public class IndexServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageBean pageBean = new PageBean();
		IStudentManagerService smService = new StudentManagerServiceImpl();
		String pageNumber = request.getParameter("pageNumber");
		if(pageNumber==null) {
			pageNumber = "1";
		}
		pageBean.setPageNumber(Integer.parseInt(pageNumber));
		smService.findStudentByPageBean(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
