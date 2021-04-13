package com.sh.xiaoyu.admin.api.entity.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sh.xiaoyu.admin.api.entity.dto.RoleDto;
import com.sh.xiaoyu.common.base.bo.BaseBo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.entity.role.entity
 * @ClassName: Role
 * @Description:
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@TableName("sys_role")
@ApiModel(value = "Role",description = "角色设置")
public class Role extends BaseBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * */
    @TableId
    private String id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编号
     */
    private String roleCode;

    /**
     * 描述
     */
    private String description;

    /**
     * 角色类型 1:后台角色 0:前台角色
     */
    private Integer roleType;

    /**
     * 是否有效(0无效，1有效)
     */
    private Integer status;


    /**
     *   dto转bo
     */
    public Role buildBo(RoleDto roleDto){
        BeanUtils.copyProperties(roleDto,this);
        return this;
    }
}
