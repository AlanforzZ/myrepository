package cn.biz.student.web.filter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**   
 * @ClassName:  MyRequest   
 * @Description:TODO   解决编码问题
 * @author: Alan 
 * @date:   
 *     
 * @Copyright: 2017 www.alan.com Inc. All rights reserved. 
 * 注意：本内容仅限于我自己使用
 */  
public class MyRequest extends HttpServletRequestWrapper{

	public MyRequest(HttpServletRequest request) {
		super(request);
	}
	
	//判断是否已经被编码 默认false
	private boolean encoded = false;

	/**   
	 * <p>Title: getParameter</p>   
	 * <p>Description: 返回指定name的第一个参数</p>   
	 * @param name
	 * @return   
	 * @see javax.servlet.ServletRequestWrapper#getParameter(String)
	 */  
	public String getParameter(String name) {
		String [] all = getParameterValues(name);
		if(all==null) {
			return null;
		}
		return all[0];
	}
	/**   
	 * <p>Title: getParameterValues</p>   
	 * <p>Description:获得指定name的所有参数 </p>   
	 * @param name
	 * @return   
	 * @see javax.servlet.ServletRequestWrapper#getParameterValues(String)
	 */  
	public String[] getParameterValues(String name) {
		return getParameterMap().get(name);
	}
	

	/**   
	 * <p>Title: getParameterMap</p>   
	 * <p>Description:获得所有的name和其所有参数 </p>   
	 * @return   
	 * @see javax.servlet.ServletRequestWrapper#getParameterMap()   
	 */  
	@Override
	public Map<String, String[]> getParameterMap() {
			try {
		//		1.获得所有数据
				Map<String, String[]> map = super.getParameterMap();
		//		2.判断是否是get方法
				if(!encoded) {
					if("Get".equalsIgnoreCase(super.getMethod())){
		//				3.遍历map然后遍历数组
						for (Map.Entry<String, String[]> entry : map.entrySet()) {
							String[] allValue = entry.getValue();
							for (int i = 0; i < allValue.length; i++) {
								String encoding = super.getCharacterEncoding();
								if(encoding==null) {
									encoding = "UTF-8";
								}
									allValue[i] = new String(allValue[i].getBytes("ISO-8859-1"),encoding);
							}
						}
						encoded = true;
					}
				}
				return map;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
}
