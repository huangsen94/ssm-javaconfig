package com.common.entity.api;

import com.common.entity.enums.ApiResultStatusCode;

/**
 * Created by hs on 2017/3/22.
 */
public class ApiEmptyResult extends ApiResult {
    public ApiEmptyResult() {
        super();
        setCode(ApiResultStatusCode.NO_RECORD.getCode());
        setData(ApiResultStatusCode.NO_RECORD.getMsg());
    }
}
