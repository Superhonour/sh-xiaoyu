package com.sh.xiaoyu.admin.api.feign.fallback;

import com.sh.xiaoyu.admin.api.feign.client.AuthorityClient;
import com.sh.xiaoyu.common.base.constants.ServiceNameConstants;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.feign.fallback
 * @ClassName: AuthorityClientFallBack
 * @Description:
 * @Version: 1.0
 */
@Component
public class AuthorityClientFallBack implements AuthorityClient {

    private final Logger logger = LoggerFactory.getLogger(AuthorityClientFallBack.class);

    @Override
    public ApiResponse getAuthorityByUserId(String id) {
        logger.error("调用xiaoyu-admin服务getAuthorityByUserId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.XIAOYU_ADMIN, "getAuthorityByUserId");
    }

    @Override
    public ApiResponse getOauthClientDetailsByClientId(String clientId) {
        logger.error("调用xiaoyu-admin服务getOauthClientDetailsByClientId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.XIAOYU_ADMIN, "getOauthClientDetailsByClientId");
    }
}
