package org.tom.server.basic.vo;

import java.util.List;

/**
 * Used in pagination 
 * @author yellowshuo
 *
 */
public class PageJsonBean {

	// page number
	private int pageNum;
	
	// page count
	private int pageCount;
	
	// total count
	private int total;
	
	// page list
	private List<?> list;
	
	public List<?> getList() {
		return list;
	}
	
	public void setList(List<?> list) {
		this.list = list;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
}
