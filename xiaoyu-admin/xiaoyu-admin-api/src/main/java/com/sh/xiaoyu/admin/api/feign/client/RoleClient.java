package com.sh.xiaoyu.admin.api.feign.client;

import com.sh.xiaoyu.admin.api.feign.fallback.RoleClientFallBack;
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
 * @ClassName: RoleClient
 * @Description:
 * @Version: 1.0
 */
@FeignClient(contextId = "roleClient", name = ServiceNameConstants.XIAOYU_ADMIN, configuration = FeignRequestInterceptorConfig.class, fallback = RoleClientFallBack.class)
public interface RoleClient {

    @GetMapping("/role/web/info/user/{id}")
    ApiResponse getRoleByUserId(@PathVariable String id);
}
