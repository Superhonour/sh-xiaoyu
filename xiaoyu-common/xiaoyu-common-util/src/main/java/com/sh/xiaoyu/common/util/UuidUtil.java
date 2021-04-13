package com.sh.xiaoyu.common.util;

import java.util.UUID;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.common.util
 * @ClassName: UuidUtils
 * @Date: 2019/11/20 10:17
 * @Description:
 * @Version: 1.0
 */
public class UuidUtil {

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

