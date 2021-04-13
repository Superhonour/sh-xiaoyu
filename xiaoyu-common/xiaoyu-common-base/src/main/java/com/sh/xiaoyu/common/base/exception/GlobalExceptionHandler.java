package com.sh.xiaoyu.common.base.exception;

import com.sh.xiaoyu.common.base.enums.ShHttpStatus;
import com.sh.xiaoyu.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.common.base.exception
 * @ClassName: GlobalExceptionHandler
 * @Description: 全局异常处理类
 * @Version: 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = CommonException.class)
    public ApiResponse defaultErrorHandler(CommonException e) {
        e.printStackTrace();
        return new ApiResponse(ShHttpStatus.COMMON_FAIL.getCode(),new CommonException().getMessage());
    }

    @ExceptionHandler(value = BusinessException.class)
    public ApiResponse defaultErrorHandler(BusinessException e) {
        e.printStackTrace();
        return new ApiResponse(ShHttpStatus.COMMON_FAIL.getCode(),new CommonException().getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ApiResponse defaultErrorHandler(RuntimeException e) {
        e.printStackTrace();
        createLogger(e);
        return  new ApiResponse(ShHttpStatus.SERVER_FUGUE.getCode(), ShHttpStatus.SERVER_FUGUE.getMessage());
    }

    /**
     * 打印关键log信息
     * @param e
     */
    private void createLogger(Exception e) {
        logger.info(e.getMessage());
        logger.info(e.getStackTrace()[0].toString());
        logger.error(e.getMessage());
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            logger.error(stackTraceElement.toString());
        }
    }
}
