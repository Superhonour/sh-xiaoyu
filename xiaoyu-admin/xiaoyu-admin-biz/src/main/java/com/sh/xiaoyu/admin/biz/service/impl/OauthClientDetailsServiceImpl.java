package com.sh.xiaoyu.admin.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sh.xiaoyu.admin.api.entity.bo.OauthClientDetails;
import com.sh.xiaoyu.admin.biz.mapper.OauthClientDetailsMapper;
import com.sh.xiaoyu.admin.biz.service.OauthClientDetailsService;
import com.sh.xiaoyu.common.base.constants.GlobalsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.biz.service.impl
 * @ClassName: OauthClientDetailsServiceImpl
 * @Date: 2019/11/5 09:34
 * @Description:
 * @Version: 1.0
 */
@Service("oauthClientDetailsService")
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsMapper, OauthClientDetails> implements OauthClientDetailsService {

    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    @Cacheable(value= GlobalsConstants.REDIS_CLIENT_CACHE,unless = "#result == null", key="T(com.sh.xiaoyu.common.base.constants.GlobalsConstants).CLIENT_DETAILS_KEY.concat(T(String).valueOf(#clientId))")
    public OauthClientDetails findOauthClientDetailsByClientId(String clientId) {
        return oauthClientDetailsMapper.getOauthClientDetailsByClientId(clientId);
    }
}