package cn.itcast.oa.util;

import java.util.List;

/**
 * 分页功能中的一页信息
 * @author RocHuang
 *
 */
public class PageBean {
	
	// 指定的值或者是参数
	private int currentPage; // 当前页
	private int pageSize; // 每页显示多少条

	// 查询数据库得到
	private int recordCount; // 总记录数
	private List recordList; // 本页的数据列表
	
	// 通过计算得到
	private int pageCount; // 总页数
	private int beginPageIndex; // 页码列表的开始索引
	private int endPageIndex; // 页码列表的结束索引

	/**
	 * 只接收必要的前4个属性
	 * @param currentPage
	 * @param pageSize
	 * @param recordCount
	 * @param recordList
	 */
	public PageBean(int currentPage, int pageSize, int recordCount, List recordList) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		
		// 计算总页数
//		pageCount = (recordCount + pageSize - 1) / pageSize;
		pageCount = recordCount % pageSize == 0 ? (recordCount / pageSize) : (recordCount / pageSize) + 1;
		
		// 计算页码列表的开始和结束索引
		// 总页数不多于10页，则全部显示
		if (pageCount <= 10) {
			beginPageIndex = 1;
			endPageIndex = pageCount;
		} 
		// 总页数多于10页，则显示当前页附近的共10个页码
		else {
			// 当前页附近的共10个页码（前4页 + 当前页 + 后5页）
			beginPageIndex = currentPage - 4;
			endPageIndex = currentPage + 5;
			// 当前面的页码不足4页时候，则显示最前10页，第1页到第10页
			if (beginPageIndex < 1) {
				beginPageIndex = 1;
				endPageIndex = 10;
			}
			// 当后面的页码不足5页时候，则显示最后10页，第（lastPage - 9）页到第lastPage页
			if (endPageIndex > pageCount) {
				beginPageIndex = pageCount - 10 + 1;
				endPageIndex = pageCount;
			}
		}
	}
	
	public List getRecordList() {
		return recordList;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
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
