package com.sh.xiaoyu.common.security.properties;

import com.sh.xiaoyu.common.base.constants.GlobalsConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: LHL
 * @ProjectName: xiaoyu_scaffolding
 * @Package: com.sh.xiaoyu.common.security.properties
 * @ClassName: SecurityProperties
 * @Description:
 * @Version: 1.0
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = GlobalsConstants.XIAOYU_OAUTH_PREFIX)
public class SecurityProperties {

    WebProperties web = new WebProperties();

    OAuth2Properties oauth2 = new OAuth2Properties();

}
