package com.sh.xiaoyu.admin.api.entity.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sh.xiaoyu.admin.api.entity.dto.DictDto;
import com.sh.xiaoyu.common.base.bo.BaseBo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.entity.dict
 * @ClassName: Dict
 * @Date: 2019/11/5 10:05
 * @Description:
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@TableName("sys_dict")
@ApiModel(value = "Dict",description = "字典设置")
public class Dict extends BaseBo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    /**
     * 字典值
     */
    private Integer value;

    /**
     * 上级ID
     */
    private String pid;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 字典类型
     */
    private String type;

    /**
     * 0无效 1有效
     */
    private Integer status;


    /**
     *   dto转bo
     */
    public Dict buildBo(DictDto dictDto){
        BeanUtils.copyProperties(dictDto,this);
        return this;
    }

}
