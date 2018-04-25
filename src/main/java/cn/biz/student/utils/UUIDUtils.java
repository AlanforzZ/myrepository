package cn.biz.student.utils;

import java.util.UUID;


public class UUIDUtils {
	
	/**   
	 * @Title: getUUID   
	 * @Description: 生成一个32位UUID   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}
	
	/**   
	 * @Title: getUUID64   
	 * @Description: 生成一个64位的UUID(这里用一句话描述这个方法的作用)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public static String getUUID64() {
		return getUUID()+getUUID();
	}
}
