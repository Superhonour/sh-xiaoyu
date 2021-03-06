package com.sh.xiaoyu.common.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.xiaoyu.common.base.enums.ShHttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.common.security.component
 * @ClassName: MyAccessDeniedHandler
 * @Description: 授权失败处理异常
 * @Version: 1.0
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        ShHttpStatus resultEnum = ShHttpStatus.UNAUTHORIZED;
        Map map = new HashMap();
        map.put("code", resultEnum.getCode());
        map.put("msg", resultEnum.getMessage());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(objectMapper.writeValueAsString(map));
    }
}