package com.sh.xiaoyu.admin.biz.service;

import com.sh.xiaoyu.admin.api.entity.bo.OauthClientDetails;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.biz.service.authority
 * @ClassName: oauthClientDetailsService
 * @Description:
 * @Version: 1.0
 */
public interface OauthClientDetailsService{

    /**
     * 根据clientId查询OauthClientDetails
     *
     * @param clientId clientId
     * @return OauthClientDetails
     */
    OauthClientDetails findOauthClientDetailsByClientId(String clientId);

}
