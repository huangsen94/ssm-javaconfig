package com.common.database.pagination;

/**
 * Created by hs on 2017/3/23.
 */
public class ApiPageInfo {

    private Integer pageNum = 0;        //页码
    private Integer pageSize = 0;       //页大小
    private Integer totalSize = 0;      //总条数
    private Integer totalPage = 0;      //总页数

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

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
