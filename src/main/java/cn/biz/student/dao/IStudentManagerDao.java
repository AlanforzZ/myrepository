package cn.biz.student.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import cn.biz.student.domain.PageBean;
import cn.biz.student.domain.Student;

public interface IStudentManagerDao {
	//分页查询学生
	public Set<String> findStudentByPageBean(PageBean pageBean);
	//查询学生总数
	public Long findStudentTotalCount();
	//根据id查询学生
	public Student findStudentById(String id) throws IllegalAccessException, InvocationTargetException;
	//保存或更新学生
	public void saveOrUpdate(String json, String string, Integer integer);
	//通过id删除学生
	public void deleteById(String id);
}
