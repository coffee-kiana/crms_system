package com.wang.domain;

import java.util.List;

public class PageBean {
    
	//指定的或是页面参数
	private int currentPage;
	private int pageSize;
	
	//查询数据库
	private int recordCount;
	private List recordList;
	
	//计算
	private int pageCount;//总页数
	private int beginPageIndex;//页码表的开始索引
	private int endPageIndex;//页码表的结束索引
	
	//构建方法，计算出要计算的值
	public PageBean(int currentPage, int pageSize, int recordCount,
			List recordList) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		//计算pageCount;
		pageCount=(recordCount + pageSize -1)/pageSize;//取整
		//计算beginPageIndex.endPageIndex;
		//..总页数不多于5页时，则全部显示
		if(pageCount <=5){
			beginPageIndex=1;
			endPageIndex=pageCount;
		}
		//若总页数多余5页，则显示当前页附近的共5个页码
		else{
			beginPageIndex=currentPage-2;
			endPageIndex=currentPage+2;
			//如果当前的页码不足与2个时，则显示前5个页码
			if(beginPageIndex < 1){
				beginPageIndex=1;
				endPageIndex=5;
			}
			//当后面的页码不足与5个时，则显示后5个页码
			if(endPageIndex > pageCount){
				endPageIndex=pageCount;
				beginPageIndex=pageCount-5 +1;
				
			}
		}
	
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public List getRecordList() {
		return recordList;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getBeginPageIndex() {
		return beginPageIndex;
	}
	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	
	
	
}
