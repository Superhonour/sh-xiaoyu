package com.sh.xiaoyu.admin.api.entity.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sh.xiaoyu.admin.api.entity.dto.DeptDto;
import com.sh.xiaoyu.common.base.bo.BaseBo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.entity.dept
 * @ClassName: Dept
 * @Date: 2019/11/5 10:00
 * @Description:
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@TableName("sys_dept")
@ApiModel(value = "Dept",description = "部门设置")
public class Dept extends BaseBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * */
    @TableId
    private String id;

    /**
     * 排序
     */
    private Integer num;

    /**
     * 父部门id
     */
    private String pid;

    /**
     * 父级ids
     */
    private String pids;

    /**
     * 简称
     */
    private String simpleName;

    /**
     * 全称
     */
    private String fullName;

    /**
     * 提示
     */
    private String tips;

    /**
     * 地址
     */
    private String address;

    /**
     * 部门类型(0 公司1部门)
     */
    private Integer deptType;

    /**
     * 部门所在的公司id
     */
    private String compId;


    /**
     *   dto转bo
     */
    public Dept buildBo(DeptDto deptDto){
        BeanUtils.copyProperties(deptDto,this);
        return this;
    }
}
