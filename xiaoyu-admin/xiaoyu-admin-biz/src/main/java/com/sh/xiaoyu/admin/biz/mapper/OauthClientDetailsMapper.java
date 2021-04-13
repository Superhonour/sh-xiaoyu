package com.sh.xiaoyu.admin.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sh.xiaoyu.admin.api.entity.bo.OauthClientDetails;
import org.springframework.stereotype.Repository;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.biz.dao.authority
 * @ClassName: OauthClientDetailsMapper
 * @Description:
 * @Version: 1.0
 */
@Repository
public interface OauthClientDetailsMapper extends BaseMapper<OauthClientDetails> {

    /**
     * 根据clientId查询OauthClientDetails
     *
     * @param clientId clientId
     * @return OauthClientDetails
     */
    OauthClientDetails getOauthClientDetailsByClientId(String clientId);

    /**
     * 根据clientId查询resourceIds
     *
     * @param clientId clientId
     * @return String
     */
    String getResourceIdsByClientId(String clientId);

}
