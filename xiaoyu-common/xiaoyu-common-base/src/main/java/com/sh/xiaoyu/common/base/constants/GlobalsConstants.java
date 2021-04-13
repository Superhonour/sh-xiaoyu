package com.sh.xiaoyu.common.base.constants;

/**
 * @author: LHL
 * @ProjectName: xiaoyu_scaffolding
 * @Package: com.sh.xiaoyu.common.base.constants
 * @ClassName: GlobalsConstants
 * @Description: 系统常量
 * @Version: 1.0
 */
public interface GlobalsConstants {

    /**
     * jwt对称加密
     */
    String OAUTH_SIGNING_KEY = "xiaoyu_oauth_key";

    /**
     * Redis Cache
     */
    String REDIS_USER_CACHE = "RedisUserCache";

    /**
     * Redis Cache
     */
    String REDIS_CLIENT_CACHE = "RedisClientCache";

    /**
     * 缓存中user的key
     */
    String USER_KEY_PREFIX = "XiaoyuUser_";

    /**
     * oauth 客户端信息
     */
    String CLIENT_DETAILS_KEY = "XiaoyuClient_";

    /**
     * Redis默认过期时长，单位：秒  5分钟
     */
    long DEFAULT_EXPIRE = 60 * 5;

    /**
     * Redis 不设置过期时长
     */
    long NOT_EXPIRE = -1;

    /**
     * Redis set 前缀
     */
    String KEY_SET_PREFIX = "_set:";

    /**
     * Redis list 前缀
     */
    String KEY_LIST_PREFIX = "_list:";

    /**
     * ip
     */
    String UNKNOWN = "unknown";

    /**
     * druid配置
     */
    String DB_PREFIX = "spring.datasource";

    /**
     * xiaoyu security配置
     */
    String XIAOYU_OAUTH_PREFIX = "xiaoyu.security";
    /**
     * oauth security配置
     */
    String OAUTH_SECURITY_PREFIX = "security.oauth2.client";

    /**
     * security  过滤url 配置
     */
    String FILTER_IGNORE = "ignore";

    /**
     * security  过滤url 配置
     */
    String XIAOYU_RESOURCE_IDS = "xiaoyu.resource";

    /**
     * 成功标记
     */
    Integer SUCCESS = 0;
    /**
     * 失败标记
     */
    Integer FAIL = 1;

    /**
     * 前缀
     */
    String PROJECT_PREFIX = "xiaoyu_";

    /**
     * oauth 相关前缀
     */
    String OAUTH_PREFIX = "oauth:";

    String CURRENT = "current";

    String SIZE = "size";


    /**
     * 内部
     */
    String FROM_IN = "Y";

    /**
     * 标志
     */
    String FROM = "from";

    String LOCAL_HOST_127 = "127.0.0.1";

    String LOCAL_HOST_1 = "0:0:0:0:0:0:0:1";

    String GET = "GET";

    String LOGIN = "/login";

    String SAVE_LOG = "/log/api/add";

    String GET_TOKEN = "/api/token";

    String PASSWORD = "123456";
}
