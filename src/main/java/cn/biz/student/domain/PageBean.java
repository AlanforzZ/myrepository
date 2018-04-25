package cn.biz.student.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan
 *	封装分页对象
 */
public class PageBean {
	private Long totalCount;
	private Integer totalPage;
	private Integer pageSize = 10; //每页显示条数
	private Integer pageNumber; //当前页数
	private Integer indexNumber;//起始查找到数
	
	private List<Student> list = new ArrayList<Student>();

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
		this.totalPage = (int) Math.ceil((this.totalCount)*1.0/(this.pageSize));
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
		this.indexNumber = (this.pageNumber-1)*pageSize;
	}

	public Integer getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(Integer indexNumber) {
		this.indexNumber = indexNumber;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}
	
}
