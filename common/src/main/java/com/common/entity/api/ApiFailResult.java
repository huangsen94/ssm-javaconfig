package com.common.entity.api;

import com.common.entity.enums.ApiResultStatusCode;

/**
 * Created by hs on 2017/3/22.
 */
public class ApiFailResult extends ApiResult {
    public ApiFailResult() {
        super();
        setCode(ApiResultStatusCode.FAIL.getCode());
        setData(ApiResultStatusCode.FAIL.getMsg());
    }
}
