package com.sh.xiaoyu.admin.api.feign.client;

import com.sh.xiaoyu.admin.api.feign.fallback.UserClientFallBack;
import com.sh.xiaoyu.common.base.constants.ServiceNameConstants;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import com.sh.xiaoyu.common.feign.config.FeignRequestInterceptorConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.feign.client
 * @ClassName: UserClient
 * @Description:
 * @Version: 1.0
 */
@FeignClient(contextId = "userClient", name = ServiceNameConstants.XIAOYU_ADMIN, configuration = FeignRequestInterceptorConfig.class, fallback = UserClientFallBack.class)
public interface UserClient {

    @GetMapping("/user/api/{username}")
    ApiResponse getUserByUserName(@PathVariable String username);

    @GetMapping("/user/info/{id}")
    ApiResponse loadUserByUserId(@PathVariable String id);
}
