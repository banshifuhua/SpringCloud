package com.eamon.eamonfshapi.filter;

import com.alibaba.fastjson.JSON;
import com.eamon.eamonfshapi.base.ResponseCode;
import com.eamon.eamonfshapi.base.ResponseData;
import com.eamon.eamonfshapi.util.IpUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class IpFilter extends ZuulFilter {

    public IpFilter() {
        super();
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Object isSuccess = ctx.get("isSuccess");
        return isSuccess == null ? true : Boolean.parseBoolean(isSuccess.toString());
    }

    @Override
    public Object run() {
        System.out.println(20 / 0);
        RequestContext currentContext = RequestContext.getCurrentContext();
        currentContext.set("isSuccess", false);
        HttpServletRequest request = currentContext.getRequest();
        String ipAddr = IpUtils.getIpAddr(request);
        if (StringUtils.isNotBlank(ipAddr) && ipAddr.equals("")) {
            currentContext.setSendZuulResponse(false);
            ResponseData data = ResponseData.fail("fail", ResponseCode.NO_AUTH_CODE.getCode());
            currentContext.setResponseBody(JSON.toJSONString(data));
            currentContext.getResponse().setContentType("application/json;charset=utf-8");
            return null;
        }
        return null;
    }
}
