package com.sh.xiaoyu.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sh.xiaoyu.common.security.component.Auth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author: LHL
 * @ProjectName: xiaoyu_scaffolding
 * @Package: com.sh.xiaoyu.common.security.exception
 * @ClassName:  ServerErrorException
 * @Description:
 * @Version: 1.0
 */
@JsonSerialize(using = Auth2ExceptionSerializer.class)
public class ServerErrorException extends Auth2Exception {

	public ServerErrorException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "server_error";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

}
