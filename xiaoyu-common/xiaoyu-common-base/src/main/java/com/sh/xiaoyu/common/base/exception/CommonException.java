package com.sh.xiaoyu.common.base.exception;

import com.sh.xiaoyu.common.base.enums.ShHttpStatus;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.common.base.exception
 * @ClassName: CommonException
 * @Description: 自定义公共运行时异常
 * @Version: 1.0
 */
public class CommonException extends RuntimeException {

    public Integer code;

    public String msg;

    public CommonException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String msg) {
        super(msg);
        this.code = ShHttpStatus.COMMON_FAIL.getCode();
        this.msg = msg;
    }

    public CommonException() {
        super(ShHttpStatus.COMMON_FAIL.getMessage());
        this.code = ShHttpStatus.COMMON_FAIL.getCode();
        this.msg = ShHttpStatus.COMMON_FAIL.getMessage();
    }
    public CommonException(ShHttpStatus status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.msg = status.getMessage();
    }

    public CommonException(Throwable cause) {
        super(cause);
    }


}
