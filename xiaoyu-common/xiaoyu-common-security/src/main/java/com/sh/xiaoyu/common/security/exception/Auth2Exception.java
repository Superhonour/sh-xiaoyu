package com.sh.xiaoyu.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sh.xiaoyu.common.security.component.Auth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.common.security.exception
 * @ClassName: Auth2Exception
 * @Description: 自定义OAuth2Exception
 * @Version: 1.0
 */
@JsonSerialize(using = Auth2ExceptionSerializer.class)
public class Auth2Exception extends OAuth2Exception {
	@Getter
	private String errorCode;

	public Auth2Exception(String msg) {
		super(msg);
	}

	public Auth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
}
