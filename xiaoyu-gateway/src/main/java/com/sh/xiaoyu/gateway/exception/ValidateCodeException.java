package com.sh.xiaoyu.gateway.exception;

import lombok.Data;

/**
 * @author: LHL
 * @ProjectName: xiaoyu
 * @Package: com.sh.xiaoyu.gateway.exception
 * @ClassName: ValidateCodeException
 * @Date: 2019/11/5 19:47
 * @Description:
 * @Version: 1.0
 */
@Data
public class ValidateCodeException extends Exception {

    private static final long serialVersionUID = -7285211528095468156L;

    private Integer code;

    private String msg;

    public ValidateCodeException(String msg) {
        super(msg);
        this.code = -1;
        this.msg = msg;
    }

    public ValidateCodeException() {
    }
}
