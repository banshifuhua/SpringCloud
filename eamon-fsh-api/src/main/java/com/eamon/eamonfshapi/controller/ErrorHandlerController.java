package com.eamon.eamonfshapi.controller;

import com.eamon.eamonfshapi.base.ResponseCode;
import com.eamon.eamonfshapi.base.ResponseData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 异常时返回统一格式
 */
@RestController
public class ErrorHandlerController implements ErrorController {
    @Autowired
    ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public ResponseData error(HttpServletRequest request) {
        Map<String, Object> errorAttributes = getErrorAttributes(request);
        String message = (String) errorAttributes.get("message");
        String trace = (String) errorAttributes.get("trace");
        if (StringUtils.isNotBlank(trace)) {
            message += String.format(" and trace %s", trace);
        }
        return ResponseData.fail(message, ResponseCode.SERVER_ERROR_CODE.getCode());
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, true);
    }
}
