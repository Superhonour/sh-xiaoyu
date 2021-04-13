package com.sh.xiaoyu.admin.api.feign.client;

import com.sh.xiaoyu.admin.api.feign.fallback.AuthorityClientFallBack;
import com.sh.xiaoyu.common.base.constants.ServiceNameConstants;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import com.sh.xiaoyu.common.feign.config.FeignRequestInterceptorConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.feign.client
 * @ClassName: AuthorityClient
 * @Description:
 * @Version: 1.0
 */
@FeignClient(contextId = "authorityClient", name = ServiceNameConstants.XIAOYU_ADMIN, configuration = FeignRequestInterceptorConfig.class, fallback = AuthorityClientFallBack.class)
public interface AuthorityClient {

    @GetMapping("/authority/api/{id}")
    ApiResponse getAuthorityByUserId(@PathVariable String id);

    @GetMapping("/authority/api/info")
    ApiResponse getOauthClientDetailsByClientId(@RequestParam String clientId);
}
