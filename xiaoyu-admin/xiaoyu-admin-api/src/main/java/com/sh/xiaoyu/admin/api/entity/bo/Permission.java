package com.sh.xiaoyu.admin.api.entity.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sh.xiaoyu.admin.api.entity.dto.PermissionDto;
import com.sh.xiaoyu.common.base.bo.BaseBo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author LHL
 */
@Data
@NoArgsConstructor
@TableName("sys_permission")
@ApiModel(value = "Permission",description = "权限设置")
public class Permission extends BaseBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * */
    @TableId
    private String id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限编码
     */
    private String code;

    /**
     * 路径
     */
    private String urlPath;

    /**
     * 父级权限
     */
    private String pid;

    /**
     * 菜单类型 （0菜单 1按钮）
     */
    private Integer type;

    /**
     * 图标
     */
    private String iconPath;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否有效(0无效，1有效)
     */
    private Integer status;

    /**
     *   dto转bo
     */
    public Permission buildBo(PermissionDto permissionDto){
        BeanUtils.copyProperties(permissionDto,this);
        return this;
    }

}