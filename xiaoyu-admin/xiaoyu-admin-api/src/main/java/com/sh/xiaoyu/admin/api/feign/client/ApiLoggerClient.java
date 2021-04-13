package com.sh.xiaoyu.admin.api.feign.client;

import com.sh.xiaoyu.admin.api.entity.bo.ApiLogger;
import com.sh.xiaoyu.admin.api.feign.fallback.ApiLoggerClientFallBack;
import com.sh.xiaoyu.common.base.constants.GlobalsConstants;
import com.sh.xiaoyu.common.base.constants.ServiceNameConstants;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import com.sh.xiaoyu.common.feign.config.FeignRequestInterceptorConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.feign.client
 * @ClassName: ApiLoggerClient
 * @Description:
 * @Version: 1.0
 */
@FeignClient(contextId = "apiLoggerClient", name = ServiceNameConstants.XIAOYU_ADMIN, configuration = FeignRequestInterceptorConfig.class, fallback = ApiLoggerClientFallBack.class)
public interface ApiLoggerClient {

    /**
     * 保存日志
     * @param apiLogger 日志实体
     * @param from 内部调用
     * @return ApiResponse
     */
    @PostMapping("/log/info/add")
    ApiResponse saveLog(@RequestBody ApiLogger apiLogger, @RequestHeader(GlobalsConstants.FROM) String from);

}
