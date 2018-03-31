package cn.dlbdata.dangjian.common.util;

public class HttpResult {
	private boolean status;
	
	private String message;
	
	private int responseCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public static HttpResult failure(){
		HttpResult result = new HttpResult();
		result.setStatus(false);
		result.setResponseCode(0);
		result.setMessage("");

		return result;
	}
	
	public static HttpResult failure(String msg){
		HttpResult result = new HttpResult();
		result.setStatus(false);
		result.setMessage(msg);
		result.setResponseCode(0);

		return result;
	}
	
	public static HttpResult failure(int code, String msg){
		HttpResult result = new HttpResult();
		result.setStatus(false);
		result.setMessage(msg);
		result.setResponseCode(code);

		return result;
	}
	
	/**
	 * 失败结果集
	 * @param code
	 * @param msg
	 * @param obj
	 * @return
	 */
	public static HttpResult failure(int code, String msg, Object obj){
		FaileResult faile = new FaileResult();
		faile.setStatus(false);
		faile.setMessage(msg);
		faile.setResponseCode(code);
		faile.setEntry(obj);

		return faile;
	}
	/**
	 * 失败结果集
	 * @author chh
	 *
	 */
	public static class FaileResult extends HttpResult{
		private Object entry;

		public Object getEntry() {
			return entry;
		}

		public void setEntry(Object entry) {
			this.entry = entry;
		}
	}

	public static HttpResult success(Object obj){
		SuccessResult result = new SuccessResult();
		result.setStatus(true);
		result.setEntry(obj);

		return result;
	}
	
	
	public static HttpResult success(PageResultSet<?> obj){
		PageSuccessResult result = new PageSuccessResult();
		result.setStatus(true);
		result.setEntry(obj.getList());

		PageSetExtra pageset = new PageSetExtra();
		pageset.setCurrentPage(obj.getCurrentPage());
		pageset.setPageSize(obj.getPageSize());
		pageset.setPrePage(obj.getCurrentPage()-1);
		pageset.setNextPage(obj.getCurrentPage()+1);
		pageset.setAllPageNumber(obj.getAllPageNumber());
		pageset.setAllRow(obj.getAllRow());
		result.setPageSet(pageset);
		
		return result;
	}
	
	public static HttpResult success(){
		SuccessResult result = new SuccessResult();
		result.setStatus(true);

		return result;
	}

	public static class SuccessResult extends HttpResult{
		private Object entry;

		public Object getEntry() {
			return entry;
		}

		public void setEntry(Object entry) {
			this.entry = entry;
		}
	}
	
	public static class PageSetExtra{
		
		private int currentPage;
		
		private int nextPage;
		
		private int prePage;
		
		private int pageSize;
		
		private int allPageNumber;
		
		private int allRow;

		
		public int getAllPageNumber() {
			return allPageNumber;
		}

		public void setAllPageNumber(int allPageNumber) {
			this.allPageNumber = allPageNumber;
		}

		public int getAllRow() {
			return allRow;
		}

		public void setAllRow(int allRow) {
			this.allRow = allRow;
		}

		public int getNextPage() {
			return nextPage;
		}

		public void setNextPage(int nextPage) {
			this.nextPage = nextPage;
		}

		public int getPrePage() {
			return prePage;
		}

		public void setPrePage(int prePage) {
			
			if(prePage<=0){
				prePage = 1;
			}
			
			this.prePage = prePage;
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
	}
	
	public static class PageSuccessResult extends HttpResult{
		private Object entry;
		
		private PageSetExtra pageSet;

		public Object getEntry() {
			return entry;
		}

		public void setEntry(Object entry) {
			this.entry = entry;
		}

		public PageSetExtra getPageSet() {
			return pageSet;
		}

		public void setPageSet(PageSetExtra pageSet) {
			this.pageSet = pageSet;
		}
	}
}
