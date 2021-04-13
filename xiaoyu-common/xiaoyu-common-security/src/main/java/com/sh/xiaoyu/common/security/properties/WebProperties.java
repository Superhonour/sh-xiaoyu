package com.sh.xiaoyu.common.security.properties;

import com.sh.xiaoyu.common.base.enums.LoginType;
import lombok.Getter;
import lombok.Setter;


/**
 * @author: LHL
 * @ProjectName: xiaoyu_scaffolding
 * @Package: com.sh.xiaoyu.common.security.properties
 * @ClassName: WebProperties
 * @Description:
 * @Version: 1.0
 */
@Getter
@Setter
public class WebProperties {

    private String loginPage;
    // private String loginPage = GlobalsConstants.LOGIN_PAGE_URI;

    private LoginType loginType = LoginType.JSON;

    private String[] unInterceptUris = {};
}
