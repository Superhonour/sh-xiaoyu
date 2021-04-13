package com.sh.xiaoyu.admin.api.entity.dto;

import com.sh.xiaoyu.common.base.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.entity.dto
 * @ClassName: DictSearchDto
 * @Description:
 * @Version: 1.0
 */
@Data
@ApiModel(value = "DictSearchDto", description = "字典搜索")
public class DictSearchDto extends PageDto {


    @ApiModelProperty("字典名")
    private String name;

    @ApiModelProperty("字典类型")
    private String type;

}
