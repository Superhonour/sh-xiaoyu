package com.sh.xiaoyu.admin.biz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sh.xiaoyu.admin.api.entity.bo.ApiLogger;
import com.sh.xiaoyu.admin.api.entity.dto.ApiLoggerSearchDto;
import com.sh.xiaoyu.admin.api.entity.vo.ApiLoggerVo;

import java.util.List;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.biz.service
 * @ClassName: ApiLoggerService
 * @Date: 2019/12/23 14:36
 * @Description:
 * @Version: 1.0
 */
public interface ApiLoggerService  {


    /**
     * 分页查询日志
     *
     * @param param 分页条件
     * @return IPage<ApiLoggerVo>
     */
    IPage<ApiLoggerVo> queryApiLoggerList(ApiLoggerSearchDto param);

    /**
     * 删除日志
     *
     * @param id 日志id
     * @return boolean
     */
    boolean deleteApiLogger(String id);

    /**
     * 批量删除日志
     *
     * @param ids 日志id
     * @return boolean
     */
    boolean deleteBatchApiLogger(List<String> ids);

    /**
     * 保存日志
     *
     * @param apiLogger 日志实体类
     * @return boolean
     */
    boolean saveLog(ApiLogger apiLogger);
}
