package com.common.entity.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.common.database.pagination.ApiPageInfo;
import com.common.util.web.TraceUtil;

/**
 * Created by hs on 2017/3/3.
 */
public class ApiResult {

    /* 返回码 */
    @JSONField(ordinal = 0)
    private String code;

    /* 返回数据 */
    @JSONField(ordinal = 1)
    private Object data;

    /* 返回提示消息 */
    @JSONField(ordinal = 2)
    private String msg;

    /* 返回分页信息 */
    @JSONField(ordinal = 3)
    private ApiPageInfo pageInfo;

    /*  每个请求的uuid*/
    @JSONField(ordinal = 4)
    private String uuid;

    public ApiResult() {
        this.uuid = TraceUtil.getCurrentRequestTraceId();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ApiPageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(ApiPageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

