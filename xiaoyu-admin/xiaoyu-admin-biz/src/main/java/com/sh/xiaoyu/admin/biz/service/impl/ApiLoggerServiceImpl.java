package com.sh.xiaoyu.admin.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sh.xiaoyu.admin.api.entity.bo.ApiLogger;
import com.sh.xiaoyu.admin.api.entity.dto.ApiLoggerSearchDto;
import com.sh.xiaoyu.admin.api.entity.vo.ApiLoggerVo;
import com.sh.xiaoyu.admin.biz.mapper.ApiLoggerMapper;
import com.sh.xiaoyu.admin.biz.service.ApiLoggerService;
import com.sh.xiaoyu.common.base.exception.CommonException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.biz.service.impl
 * @ClassName: ApiLoggerServiceImpl
 * @Date: 2019/12/23 14:37
 * @Description:
 * @Version: 1.0
 */
@Service
public class ApiLoggerServiceImpl extends ServiceImpl<ApiLoggerMapper, ApiLogger> implements ApiLoggerService {

    @Override
    public IPage<ApiLoggerVo> queryApiLoggerList(ApiLoggerSearchDto param) {
        Integer currentPage = param.getCurrentPage() == null ? 1 : param.getCurrentPage();
        Integer pageSize = param.getPageSize() == null ? 10 : param.getPageSize();
        Page<ApiLoggerVo> result = new Page<>(currentPage, pageSize);
        Page<ApiLogger> page = new Page<>(currentPage, pageSize);
        QueryWrapper<ApiLogger> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(param.getUserName()), "USER_NAME", param.getUserName());
        queryWrapper.like(StringUtils.isNotBlank(param.getMethod()), "METHOD", param.getMethod());
        queryWrapper.like(StringUtils.isNotBlank(param.getMethodName()), "METHOD_NAME", param.getMethodName());
        queryWrapper.ge(null != param.getStartTime(), "CREATE_TIME", param.getStartTime());
        queryWrapper.le(null != param.getEndTime(), "CREATE_TIME", param.getEndTime());
        queryWrapper.orderByDesc("CREATE_TIME");
        IPage<ApiLogger> iPage = baseMapper.selectPage(page, queryWrapper);
        BeanUtils.copyProperties(iPage, result);
        return result.setRecords(new ApiLoggerVo().buildVoList(iPage.getRecords()));
    }

    @Transactional(rollbackFor = CommonException.class)
    @Override
    public boolean deleteApiLogger(String id) {
        return baseMapper.deleteById(id) > 0;
    }

    @Transactional(rollbackFor = CommonException.class)
    @Override
    public boolean deleteBatchApiLogger(List<String> ids) {
        return baseMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    public boolean saveLog(ApiLogger apiLogger) {
        return baseMapper.insert(apiLogger) > 0;
    }
}
