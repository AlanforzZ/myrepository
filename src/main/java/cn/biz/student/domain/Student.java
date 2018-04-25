package cn.biz.student.domain;

import java.util.Date;

import cn.biz.student.utils.DateFormatUtils;
import cn.biz.student.utils.UUIDUtils;

/**
 * @author Alan
 * 学生的实体类
 */
public class Student {
	private String id;
	private String name;
	private String mark;
	private Date birthday;
	private Integer score;
	/**
	 * @param id 编号	
	 * @param name 姓名
	 * @param mark 备注
	 * @param birthday 生日
	 * @param score 平均分
	 */
	public Student(String name, String mark, String birthday, Integer score) {
		this.name = name;
		this.mark = mark;
		this.birthday = DateFormatUtils.StringToDate(birthday);
		this.score = score;
		this.id = UUIDUtils.getUUID();
	}
	public Student() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getBirthday1() {
		return DateFormatUtils.DateToString(this.birthday);
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mark=" + mark + ", birthday=" + birthday + ", score=" + score
				+ "]";
	}
}
