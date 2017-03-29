package com.common.database.pagination;

/**
 * Created by ky.chen on 2016/11/1.
 * 分页请求的信息，可以从web或者自己程序构造
 * 注意跟Live800Page的区别：这个类表示用户想按照何种方式分页，而Live800Page表示分页返回的结果
 */
public class PageRequest {

    private Integer pageNum;	    //当前页
    private Integer pageSize; 	    //每页条数

    public PageRequest(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

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
}
