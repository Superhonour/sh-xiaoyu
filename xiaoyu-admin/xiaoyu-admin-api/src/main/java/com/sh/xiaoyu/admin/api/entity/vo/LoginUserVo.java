package com.sh.xiaoyu.admin.api.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.entity.dto
 * @ClassName: UserDto
 * @Description:
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class LoginUserVo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户
     * */
    private UserVo sysUser;
    /**
     * 权限
     * */
    private List<String> permissions;
    /**
     * 角色
     * */
    private List<String> roles;
    /**
     * 菜单
     * */
    private List<PermissionVo> menus;
}
