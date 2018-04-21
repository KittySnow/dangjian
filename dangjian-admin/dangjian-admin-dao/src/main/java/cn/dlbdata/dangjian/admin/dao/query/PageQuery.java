package cn.dlbdata.dangjian.admin.dao.query;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import java.io.Serializable;

/**
 * @author July july_sky@foxmail.com
 * @version 1.0
 * @date 2018/4/21 下午9:11
 * @Copyright ©2015-2035 湘豫(北京)科技有限公司. All Rights Reserved.
 */
public class PageQuery implements Serializable {
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页记录条数
     */
    private Integer pageSize;
    /**
     * 是否分页
     */
    private Boolean pageYn = false;
    /**
     * 起始记录
     */
    private Integer start;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getPageYn() {
        return pageYn;
    }

    public void setPageYn(Boolean pageYn) {
        this.pageYn = pageYn;
    }

    public Integer getStart() {
        return !this.getPageYn() || this.pageNum == null || this.pageNum <= 0 || this.pageSize == null || this.pageSize <= 0 ? null : ((this.pageNum - 1) * this.pageSize);
    }
}
