package com.sh.xiaoyu.admin.api.feign.fallback;

import com.sh.xiaoyu.admin.api.feign.client.RoleClient;
import com.sh.xiaoyu.common.base.constants.ServiceNameConstants;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.feign.fallback
 * @ClassName: RoleClientFallBack
 * @Description:
 * @Version: 1.0
 */
@Component
public class RoleClientFallBack implements RoleClient {

    private final Logger logger = LoggerFactory.getLogger(RoleClientFallBack.class);

    @Override
    public ApiResponse getRoleByUserId(String id) {
        logger.error("调用xiaoyu-admin服务getRoleByUserId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.XIAOYU_ADMIN, "getRoleByUserId");
    }
}
