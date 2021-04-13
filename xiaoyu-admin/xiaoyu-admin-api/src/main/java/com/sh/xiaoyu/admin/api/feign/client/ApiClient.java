package com.sh.xiaoyu.admin.api.feign.client;

import com.sh.xiaoyu.admin.api.feign.fallback.ApiClientFallBack;
import com.sh.xiaoyu.common.base.constants.ServiceNameConstants;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import com.sh.xiaoyu.common.feign.config.FeignRequestInterceptorConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.feign.client
 * @ClassName: ApiClient
 * @Description:
 * @Version: 1.0
 */
@FeignClient(contextId = "apiClient", name = ServiceNameConstants.XIAOYU_ADMIN, configuration = FeignRequestInterceptorConfig.class, fallback = ApiClientFallBack.class)
public interface ApiClient {

    @GetMapping("/api/principal")
    ApiResponse getUserInfo();

}
