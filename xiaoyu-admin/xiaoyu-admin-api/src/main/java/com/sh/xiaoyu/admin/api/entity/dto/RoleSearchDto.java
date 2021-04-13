package com.sh.xiaoyu.admin.api.entity.dto;

import com.sh.xiaoyu.common.base.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.entity.dto
 * @ClassName: RoleSearchDto
 * @Description:
 * @Version: 1.0
 */
@Data
@ApiModel(value = "RoleSearchDto", description = "角色搜索")
public class RoleSearchDto extends PageDto {

    @ApiModelProperty("角色名")
    private String roleName;

}
