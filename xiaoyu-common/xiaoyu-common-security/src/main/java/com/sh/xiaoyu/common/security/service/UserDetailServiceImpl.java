package com.sh.xiaoyu.common.security.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sh.xiaoyu.admin.api.entity.bo.User;
import com.sh.xiaoyu.admin.api.entity.vo.PermissionVo;
import com.sh.xiaoyu.admin.api.feign.client.AuthorityClient;
import com.sh.xiaoyu.admin.api.feign.client.UserClient;
import com.sh.xiaoyu.common.base.constants.BizConstants;
import com.sh.xiaoyu.common.base.enums.ShHttpStatus;
import com.sh.xiaoyu.common.base.exception.CommonException;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import com.sh.xiaoyu.common.security.model.LoginUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LHL
 * @ProjectName: xiaoyu_scaffolding
 * @Package: com.sh.xiaoyu.common.security.service
 * @ClassName: UserDetailServiceImpl
 * @Description: 用户登录 查询登录用户
 * @Version: 1.0
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserClient userClient;
    @Autowired
    private AuthorityClient authorityClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isBlank(username)){
            throw new CommonException("登录名不能为空");
        }
        ApiResponse apiResponse = userClient.getUserByUserName(username);
        if (!ShHttpStatus.SUCCESS.getCode().equals(apiResponse.getCode())){
            throw new CommonException(apiResponse.getMessage());
        }
        User user = JSONObject.parseObject(JSONObject.toJSONString(apiResponse.getData(), true),User.class);
        if (user == null) {
            throw new CommonException("登录名不存在");
        } else if (BizConstants.USER_STATUS_EXPIRED.equals(user.getStatus())) {
            throw new CommonException("用户已过期");
        } else if (BizConstants.USER_STATUS_LOCKED.equals(user.getStatus())) {
            throw new CommonException("用户已锁定");
        } else if (BizConstants.USER_STATUS_UNUSED.equals(user.getStatus())) {
            throw new CommonException("用户已禁用");
        }
        ApiResponse response = authorityClient.getAuthorityByUserId(user.getId());
        List<PermissionVo> authList = JSON.parseArray(JSON.toJSONString(response.getData(), true), PermissionVo.class);
        List<GrantedAuthority> lists = new ArrayList<>();
        if(authList != null && authList.size()>0){
            for (PermissionVo auth : authList) {
                if (StringUtils.isNotBlank(auth.getCode())) {
                    lists.add(new SimpleGrantedAuthority(auth.getCode()));
                }
            }
        }
        LoginUser loginUser = new LoginUser(username,user.getPassword(),user.getNickname(),user.getStatus(), lists);
        loginUser.setId(user.getId());
        loginUser.setDeptId(user.getDeptId());
        loginUser.setCompId(user.getCompId());
        return loginUser;
    }
}
