package com.sh.xiaoyu.admin.api.entity.dto;

import com.sh.xiaoyu.common.base.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.entity.dto
 * @ClassName: ApiLoggerSearchDto
 * @Description:
 * @Version: 1.0
 */
@Data
@ApiModel(value = "ApiLoggerSearchDto", description = "操作日志搜索")
public class ApiLoggerSearchDto extends PageDto {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("请求方式")
    private String method;

    @ApiModelProperty("方法名")
    private String methodName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("开始时间")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("结束时间")
    private LocalDateTime endTime;
}
