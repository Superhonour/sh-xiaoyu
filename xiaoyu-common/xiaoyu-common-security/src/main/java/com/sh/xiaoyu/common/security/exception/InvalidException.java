package com.sh.xiaoyu.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sh.xiaoyu.common.security.component.Auth2ExceptionSerializer;

/**
 * @author: LHL
 * @ProjectName: xiaoyu
 * @Package: com.sh.xiaoyu.common.security.exception
 * @ClassName: InvalidException
 * @Description:
 * @Version: 1.0
 */
@JsonSerialize(using = Auth2ExceptionSerializer.class)
public class InvalidException extends Auth2Exception {

	public InvalidException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "invalid_exception";
	}

	@Override
	public int getHttpErrorCode() {
		return 426;
	}

}
