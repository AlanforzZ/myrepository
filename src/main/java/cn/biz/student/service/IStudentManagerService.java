package cn.biz.student.service;

import cn.biz.student.domain.PageBean;
import cn.biz.student.domain.Student;

public interface IStudentManagerService {
	//封装PageBean
	public PageBean findStudentByPageBean(PageBean pageBean);
	//保存学生
	public void saveStudent(Student s);
	//根据id查找学生
	public Student findStudentById(String id);
	//根据id删除学生
	public void deleteStudentById(String id);
}
