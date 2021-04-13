package com.sh.xiaoyu.common.base.support;

import com.sh.xiaoyu.common.base.enums.ShHttpStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.common.base.support
 * @ClassName: ApiResponse
 * @Description: 公共的返回值
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class ApiResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    private Object data;

    public ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public ApiResponse(ShHttpStatus shHttpStatus) {
        this.code = shHttpStatus.getCode();
        this.message = shHttpStatus.getMessage();
    }


    /**
     * 调用服务的错误
     * @param serviceName 服务名
     * @param methodName 方法名
     * @return 结果视图
     */
    public static ApiResponse hystrixError(String serviceName,String methodName) {
        String msg = ShHttpStatus.HYSTRIX_ERROR.getMessage().replace("xxx", serviceName).replace("{}", methodName);
        return new ApiResponse(ShHttpStatus.HYSTRIX_ERROR.getCode(), msg);
    }
}
