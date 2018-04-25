package cn.biz.student.web.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class EncodingFilter implements Filter {
	/**   
	 * <p>Title: doFilter</p>   
	 * <p>Description:编码过滤器 </p>   
	 * @param req
	 * @param resp
	 * @param chain
	 * @throws IOException
	 * @throws ServletException   
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */  
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response= (HttpServletResponse)resp;
		
		request.setCharacterEncoding("UTF-8");
		
		MyRequest myservlet = new MyRequest(request);
		
		chain.doFilter(myservlet, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
