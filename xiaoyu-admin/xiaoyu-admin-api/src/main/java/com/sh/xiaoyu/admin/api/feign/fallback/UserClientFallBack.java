package com.sh.xiaoyu.admin.api.feign.fallback;

import com.sh.xiaoyu.admin.api.feign.client.UserClient;
import com.sh.xiaoyu.common.base.constants.ServiceNameConstants;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.feign.fallback
 * @ClassName: UserClientFallBack
 * @Description:
 * @Version: 1.0
 */
@Component
@Slf4j
public class UserClientFallBack implements UserClient {

    @Override
    public ApiResponse getUserByUserName(String username) {
        log.error("调用xiaoyu-admin服务getUserByUserName方法失败,参数username:{}",username);
        return ApiResponse.hystrixError(ServiceNameConstants.XIAOYU_ADMIN, "getUserByUserName");
    }

    @Override
    public ApiResponse loadUserByUserId(String id) {
        log.error("调用xiaoyu-admin服务getUserByUserId方法失败,参数id:{}",id);
        return ApiResponse.hystrixError(ServiceNameConstants.XIAOYU_ADMIN, "getUserByUserId");
    }
}
