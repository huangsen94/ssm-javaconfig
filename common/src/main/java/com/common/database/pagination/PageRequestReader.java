package com.common.database.pagination;

import com.common.util.web.WebUtil;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by ky.chen on 2016/12/1.
 * 从http请求中读取PageRequest
 */
public class PageRequestReader {

    final private String pageSizeKey;     //从哪个request属性的key中获取页面大小
    final private Integer defPageSize;    //页面大小的默认值
    final private String pageNumKey;      //从哪个request属性的key中获取页号
    final private Integer defPageNum;     //页号的默认值

    public PageRequestReader(String pageSizeKey, Integer defPageSize, String pageNumKey, Integer defPageNum) {
        this.pageSizeKey = pageSizeKey;
        this.defPageSize = defPageSize;
        this.pageNumKey = pageNumKey;
        this.defPageNum = defPageNum;
        if (StringUtils.isAnyBlank(pageSizeKey, pageNumKey)
                || defPageSize <= 0
                || defPageNum <= 0) {
            throw new IllegalArgumentException(toString());
        }
    }

    /**
     * 读取
     * @param request
     */
    public PageRequest read(HttpServletRequest request) {
        Map<String, String> httpRequestParam = WebUtil.getParameterMap(request);
        int pageNum = MapUtils.getIntValue(httpRequestParam, pageNumKey,
                defPageNum);
        if (pageNum <= 0) {
            pageNum = defPageNum;
        }
        int pageSize = MapUtils.getIntValue(httpRequestParam, pageSizeKey,
                defPageSize);
        if (pageSize <= 0) {
            pageSize = defPageSize;
        }

        return new PageRequest(pageNum, pageSize);
    }

    public String getPageSizeKey() {
        return pageSizeKey;
    }

    public Integer getDefPageSize() {
        return defPageSize;
    }

    public String getPageNumKey() {
        return pageNumKey;
    }

    public Integer getDefPageNum() {
        return defPageNum;
    }

    @Override
    public String toString() {
        return "PageRequestReader{" +
                "pageSizeKey='" + pageSizeKey + '\'' +
                ", defPageSize=" + defPageSize +
                ", pageNumKey='" + pageNumKey + '\'' +
                ", defPageNum=" + defPageNum +
                '}';
    }
}
