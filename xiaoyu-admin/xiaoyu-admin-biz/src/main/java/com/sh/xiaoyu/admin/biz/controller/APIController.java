package com.sh.xiaoyu.admin.biz.controller;

import com.sh.xiaoyu.admin.api.entity.vo.UserVo;
import com.sh.xiaoyu.admin.biz.service.UserService;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import com.sh.xiaoyu.common.base.support.BaseController;
import com.sh.xiaoyu.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: LHL
 * @ProjectName sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.biz.controller
 * @ClassName: APIController
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api")
@Api(tags = "对外暴露的接口")
public class APIController extends BaseController {

    @Autowired
    private UserService userService;

    @SysLog("获取token")
    @PostMapping(value = "/token")
    @ApiOperation(value = "获取token接口")
    public ApiResponse getToken(@RequestParam String username, @RequestParam String password, @RequestParam String code, @RequestParam String randomStr){
        String result = userService.getToken(username, password,code,randomStr);
        if(StringUtils.isNotBlank(result)){
            return success("获取token成功",result);
        }
        return fail("获取token失败");
    }

    @SysLog("密码登录")
    @PostMapping(value = "/login")
    @ApiOperation(value = "登录接口")
    public ApiResponse webLogin(@RequestParam String username, @RequestParam String password, @RequestParam(required = false) String code, @RequestParam(required = false) String randomStr){
        UserVo result = userService.loginByPassword(username, password,code,randomStr);
        if(null != result){
            return success(result);
        }
        return fail("登陆失败");
    }

}
