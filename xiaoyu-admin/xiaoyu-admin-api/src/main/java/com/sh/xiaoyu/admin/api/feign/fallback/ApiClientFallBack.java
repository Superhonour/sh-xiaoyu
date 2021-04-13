package com.sh.xiaoyu.admin.api.feign.fallback;

import com.sh.xiaoyu.admin.api.feign.client.ApiClient;
import com.sh.xiaoyu.common.base.constants.ServiceNameConstants;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.feign.fallback
 * @ClassName: ApiClientFallBack
 * @Description:
 * @Version: 1.0
 */
@Component
public class ApiClientFallBack implements ApiClient {

    private final Logger logger = LoggerFactory.getLogger(ApiClientFallBack.class);

    @Override
    public ApiResponse getUserInfo() {
        logger.error("调用xiaoyu-admin服务getUserInfo方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.XIAOYU_ADMIN, "getUserInfo");
    }

}
