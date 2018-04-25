package cn.biz.student.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class DateFormatUtils {

        public static Date StringToDate(String s){
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        	   Date date = null; 
        	   try { 
        	    date = format.parse(s); 
        	   } catch (ParseException e) { 
        	    e.printStackTrace(); 
        	   } 
        	   return date; 
        }
        public static String DateToString(Date date){
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(date);
			return format;
        }

}