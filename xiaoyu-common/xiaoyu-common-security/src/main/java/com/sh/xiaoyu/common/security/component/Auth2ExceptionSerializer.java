package com.sh.xiaoyu.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sh.xiaoyu.common.base.constants.GlobalsConstants;
import com.sh.xiaoyu.common.security.exception.Auth2Exception;
import lombok.SneakyThrows;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.common.security.component
 * @ClassName: Auth2ExceptionSerializer
 * @Description: OAuth2 异常格式化
 * @Version: 1.0
 */
public class Auth2ExceptionSerializer extends StdSerializer<Auth2Exception> {


	public Auth2ExceptionSerializer() {
		super(Auth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(Auth2Exception value, JsonGenerator gen, SerializerProvider provider) {
		gen.writeStartObject();
		gen.writeObjectField("code", GlobalsConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}
}
