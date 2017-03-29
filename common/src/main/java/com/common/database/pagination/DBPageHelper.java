package com.common.database.pagination;

import com.common.util.web.WebUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by hs on 2017/3/23.
 */
public class DBPageHelper {

    //默认分页大小
    private static final int DEFAULT_PAGE_SIZE = 20;
    //默认的起始页码
    private static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 根据客户端请求中的参数设置分页
     * 注意：在调用这个接口以后，紧接着的query操作才会被分页
     * @param count 是否需要计算记录总条数
     */
    public static void startPageFromRequest(boolean count) {
        startPageFromRequest(count, "pageSize", DEFAULT_PAGE_SIZE, "pageNum", DEFAULT_PAGE_NUM);
    }

    /**
     * 根据客户端请求中的参数设置分页，这是用户可以调用的最底层接口
     *
     * @param count       是否计算结果总条数
     * @param pageSizeKey 从request的哪个参数获取分页大小
     * @param pageSize    默认分页大小
     * @param pageNumKey  从request的哪个参数获取当前页码
     * @param pageNum     默认的当前页码
     */
    public static void startPageFromRequest(boolean count, String pageSizeKey, int pageSize, String pageNumKey, int pageNum) {
        PageRequestReader pageRequestReader = new PageRequestReader(pageSizeKey, pageSize, pageNumKey, pageNum);
        PageRequest pageRequest = pageRequestReader.read(WebUtil.getRequest());
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize(), count);
    }

    public static <T> ApiPageInfo getPageFormResultList(List<T> list) {
        PageInfo info = new PageInfo(list);
        ApiPageInfo pageInfo = new ApiPageInfo();
        pageInfo.setPageNum(info.getPageNum());
        pageInfo.setPageSize(info.getPageSize());
        pageInfo.setTotalPage(info.getPages());
        pageInfo.setTotalSize(Long.valueOf(info.getTotal()).intValue());
        return pageInfo;
    }
}
