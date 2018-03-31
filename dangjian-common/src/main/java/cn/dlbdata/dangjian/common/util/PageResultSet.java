package cn.dlbdata.dangjian.common.util;

import java.util.List;

/**
 * 分页
 *
 * @param <T>
 */
public class PageResultSet<T> {

	public static int DEFAULT_PAGE_SIZE = 10;

    private int currentPage;
    
    private int allPageNumber;//总页数
    
    private int allRow;//总记录数
    
    private int pageStartRow ;
    
    private int pageSize=DEFAULT_PAGE_SIZE; 
    
    private List<T> list;
    
    
    public PageResultSet() {
		super();
	}

	public PageResultSet(int currentPage, int pagesize){
    	
    	this.currentPage = currentPage;
    	
    	this.pageSize = pagesize;
    	
    	this.pageStartRow = (currentPage-1)*pagesize;
    }

	public int getPageStartRow() {
		pageStartRow = (currentPage-1) * pageSize;
		return pageStartRow;
	}

	public void setPageStartRow(int pageStartRow) {
		this.pageStartRow = pageStartRow;
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

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getAllPageNumber() {

		return allPageNumber;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		int size = allRow / pageSize;
		int mod = allRow % pageSize;
		if (mod != 0)
			size++;
		allPageNumber = allRow == 0 ? 1 : size;

		this.allRow = allRow;
	}

	public boolean isLastPage() {
		return currentPage >= allPageNumber;
	}
}
