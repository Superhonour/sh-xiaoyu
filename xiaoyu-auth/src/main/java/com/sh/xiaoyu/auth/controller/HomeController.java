package com.sh.xiaoyu.auth.controller;

import com.sh.xiaoyu.admin.api.feign.client.UserClient;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import com.sh.xiaoyu.common.base.support.BaseController;
import com.sh.xiaoyu.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.auth.controller
 * @ClassName: ApiController
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/home")
@Api(tags = "auth")
public class HomeController extends BaseController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ClientDetailsService clientDetailsService;


    @SysLog("获取当前用户信息Principal")
    @GetMapping("/principal")
    @ApiOperation(value = "获取当前用户信息Principal")
    public Principal user(Principal member) {
        //获取当前用户信息
        return member;
    }

    @GetMapping("/test/{userId}")
    public ApiResponse loadUserByUserId(@PathVariable String userId) {
        return userClient.loadUserByUserId(userId);
    }

    @GetMapping("test/client")
    public void getClient() {
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId("xiaoyu-admin");
        System.out.println(clientDetails);
    }

    /**
     * 清除token（注销登录）
     */
    @SysLog("登出")
    @DeleteMapping("/logout")
    @ApiOperation(value = "登出")
    public ApiResponse logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader) {
        if (StringUtils.isBlank(authHeader)) {
            return fail("退出失败，token 为空");
        }
        //注销当前用户
        String tokenValue = authHeader.replace(OAuth2AccessToken.BEARER_TYPE, StringUtils.EMPTY).trim();
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
        tokenStore.removeAccessToken(accessToken);
        OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
        tokenStore.removeRefreshToken(refreshToken);
        return success("注销成功");
    }

}
