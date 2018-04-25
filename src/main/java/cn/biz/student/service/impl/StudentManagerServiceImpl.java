package cn.biz.student.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Set;

import com.alibaba.fastjson.JSON;

import cn.biz.student.dao.IStudentManagerDao;
import cn.biz.student.dao.impl.StudentManagerDaoImpl;
import cn.biz.student.domain.PageBean;
import cn.biz.student.domain.Student;
import cn.biz.student.service.IStudentManagerService;

public class StudentManagerServiceImpl implements IStudentManagerService {
	private IStudentManagerDao smDao = new StudentManagerDaoImpl();
	@Override
	public PageBean findStudentByPageBean(PageBean pageBean) {
		Long totalCount = smDao.findStudentTotalCount();
		pageBean.setTotalCount(totalCount);
		Set<String> ids = smDao.findStudentByPageBean(pageBean);
		Iterator<String> it = ids.iterator();
		while(it.hasNext()) {
			String id = it.next();
			try {
				Student s = smDao.findStudentById(id);
				pageBean.getList().add(s);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pageBean;
	}
	@Override
	public void saveStudent(Student s) {
		String json = JSON.toJSONString(s);
		smDao.saveOrUpdate(json,s.getId(),s.getScore());
	}
	@Override
	public Student findStudentById(String id) {
		Student s = null;
		try {
			s = smDao.findStudentById(id);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	@Override
	public void deleteStudentById(String id) {
		smDao.deleteById(id);
	}

}
