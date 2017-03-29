package com.common.entity.api;

import com.common.entity.enums.ApiResultStatusCode;

/**
 * Created by hs on 2017/3/22.
 */
public class ApiSuccessResult extends ApiResult {
    public ApiSuccessResult() {
        super();
        setCode(ApiResultStatusCode.SUCCESS.getCode());
        setData(ApiResultStatusCode.SUCCESS.getMsg());
    }
}
