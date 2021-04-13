package com.sh.xiaoyu.admin.api.feign.fallback;

import com.sh.xiaoyu.admin.api.entity.bo.ApiLogger;
import com.sh.xiaoyu.admin.api.feign.client.ApiLoggerClient;
import com.sh.xiaoyu.common.base.constants.GlobalsConstants;
import com.sh.xiaoyu.common.base.constants.ServiceNameConstants;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.feign.fallback
 * @ClassName: ApiLoggerClientFallBack
 * @Description:
 * @Version: 1.0
 */
@Component
public class ApiLoggerClientFallBack implements ApiLoggerClient {

    private final Logger logger = LoggerFactory.getLogger(ApiLoggerClientFallBack.class);

    @Override
    public ApiResponse saveLog(ApiLogger apiLogger, @RequestHeader(GlobalsConstants.FROM) String from) {
        logger.error("调用xiaoyu-admin服务saveLog方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.XIAOYU_ADMIN, "saveLog");
    }
}
