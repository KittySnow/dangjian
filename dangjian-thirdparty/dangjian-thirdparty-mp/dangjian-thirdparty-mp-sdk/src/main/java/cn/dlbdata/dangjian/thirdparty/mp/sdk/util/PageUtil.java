package cn.dlbdata.dangjian.thirdparty.mp.sdk.util;

import java.util.ArrayList;
import java.util.List;


/**
 * 储存分页处理工具类 在调用此类的方法之前需设置总页数(即得先从数据库查询到相应数据的数据量)
 *
 * @author hb
 * @version 1.0
 */
public class PageUtil {

    private static final long serialVersionUID = 1L;
    public final static String FIRST_ACTION = "First"; // 执行跳到第一页操作
    public final static String NEXT_ACTION = "Next"; // 执行跳到下一页操作韩国女装
    public final static String PREVIO_ACTION = "Prev"; // 执行跳到上一页操作
    public final static String LAST_ACTION = "Last"; // 执行跳到最一页操作
    public final static String CURRENT_TAG = "currentPage"; // 当前页数
    public final static String PAGINATION_ACTION_TAG = "paginationAction"; // 缓存操作
    public final static String GOTO_PAGE_ACTION = "gotoPage"; // 执行跳到指定的某一页操作
    public final static String PAGES_GOTO = "pageSelect"; // 执行goto操作时,用户所指定的页数http://hanguonvzhuang.blogcn.com/articles/2011/09/page/2
    private int start; // start表示当前页开始的记录数,start=每页行数*(当前页数-1)
    private int end; // 当前页结束的记录行数
    private int totalCount; // 总行数
    private int numPerPage = 20; // 每页行数，默认20
    private int pageNum = 1; // 当前页数
    private int pageListSize = 9;// 页码列表大小，默认9
    private List<Integer> pageNumList = new ArrayList<Integer>();

    public PageUtil() {
        start = 0;
        end = 0;
        pageNum = 1;
        this.totalCount = 0;
    }

    public PageUtil(int totalCount) {
        start = 0;
        end = 0;
        pageNum = 1;
        this.totalCount = totalCount;
    }

    public PageUtil(int totalCount, int numPerPage) {
        start = 0;
        end = 0;
        this.totalCount = totalCount;
        pageNum = 1;
        if (numPerPage > 0) {
            this.numPerPage = numPerPage;
        }
    }

    /**
     * 执行翻页动作
     *
     * @param currentPage 要翻到的目标页码
     * @return 返回翻页对象
     */
    public PageUtil doPagination(int currentPage) {
        gotoPage(currentPage);
        return this;
    }

    // 设置起始数
    public int getStart() {
        start = numPerPage * (pageNum - 1);
        return start;
    }

    // 得到起始数
    public void setStart(int start) {
        if (start < 1) {
            this.start = 1;
        } else if (start >= this.totalCount) {
            this.start = this.totalCount;
        } else {
            this.start = start;
        }
    }

    // 设置当前页的最后一行的在总记录中的顺序(从0开始)
    public void setEnd(int end) {
        this.end = end;
    }

    // 得到当前页的最后一行的在总记录中的顺序(从0开始)
    public int getEnd() {
        if (numPerPage * pageNum > this.totalCount) {
            end = this.totalCount;
        } else {
            end = numPerPage * pageNum;
        }
        return end;
    }

    // 以下4个方法供控制器(struts)调用

    // 判断能否到第一页;只要能到上一页，肯定就有第一页
    public boolean firstEnable() {
        return previousEnable();
    }

    // 判断能否到上一页
    public boolean previousEnable() {
        return pageNum > 1;// 只要不是第一页，就能到上一页
    }

    // 判断能否到下一页
    public boolean nextEnable() {
        return pageNum * numPerPage < this.totalCount;
    }

    // 判断能否到最后一页；只要有下一页，就肯定有最后一页.
    public boolean lastEnable() {
        return nextEnable();
    }

    // 跳到第一页
    public void firstPage() {
        pageNum = 1;
    }

    // 跳到上一页
    public void previousPage(int cPage) {
        pageNum = (cPage - 1) > 0 ? (cPage - 1) : 1;
    }

    // 跳到下一页
    public void nextPage(int cPage) {
        pageNum = cPage + 1;
        if (pageNum * numPerPage > this.totalCount) {
            lastPage();
        }
    }

    // 跳到最后一页
    public void lastPage() {
        if (this.totalCount % numPerPage == 0) {
            pageNum = this.totalCount / numPerPage;
        } else {
            pageNum = this.totalCount / numPerPage + 1;
        }
    }

    // 跳到指定的某一页
    public void gotoPage(int pageNumber) {
        if (pageNumber <= 1) {
            pageNum = 1;
        } else if (getTotalCount() < this.getNumPerPage()) {
            pageNum = 1;
        } else if (pageNumber * numPerPage >= this.totalCount) {
            lastPage();
        } else {
            pageNum = pageNumber;
        }
    }

    // 设置总行数
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    // 得到总行数
    public int getTotalCount() {
        return totalCount;
    }

    // 设置每页行数
    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    // 得到每页行数
    public int getNumPerPage() {
        return numPerPage;
    }

    // 得到总页数
    public int getPages() {
        if (this.totalCount % numPerPage == 0)
            return this.totalCount / numPerPage;
        else
            return this.totalCount / numPerPage + 1;
    }

    // 得到当前页数
    public int getPageNum() {
        return pageNum;
    }

    // 设置当前页数
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageListSize() {
        return pageListSize;
    }

    // 设置页码列表大小
    public void setPageListSize(int pageListSize) {
        this.pageListSize = pageListSize;
    }

    // 得到页面列表
    public List<Integer> getPageNumList() {
        this.pageNumList.removeAll(this.pageNumList);// 设置之前先清空
        int totalPage = getPages();
        if (totalPage > this.pageListSize) {
            int halfSize = this.pageListSize / 2;
            int first = 1;
            int end = 1;
            if (this.pageNum - halfSize < 1) { // 当前页靠近最小数1
                first = 1;
                end = this.pageListSize;
            } else if (totalPage - this.pageNum < halfSize) { // 当前页靠近最大数
                first = totalPage - this.pageListSize + 1;
                end = totalPage;
            } else {
                first = this.pageNum - halfSize;
                end = this.pageNum + halfSize;
            }
            for (int i = first; i <= end; i++) {
                this.pageNumList.add(i);
            }
        } else {
            for (int i = 0; i < totalPage; i++) {
                this.pageNumList.add(i + 1);
            }
        }

        return pageNumList;
    }

}
