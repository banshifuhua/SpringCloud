package com.eamon.eamonfshapi.provider;

import com.alibaba.fastjson.JSON;
import com.eamon.eamonfshapi.base.ResponseCode;
import com.eamon.eamonfshapi.base.ResponseData;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class ServiceConsumerFallbackProvider implements ZuulFallbackProvider {
    private Logger logger = LoggerFactory.getLogger(ServiceConsumerFallbackProvider.class);

    /**
     * 表示对所有服务进行回退操作，如果只想对某个服务进行回退，那么就返回需要辉瑞的服务名称，这个名称一定是注册在eureka中的名称
     *
     * @return
     */
    @Override
    public String getRoute() {
        return "*";
    }

    /**
     * 通过 此 构造回退内容
     *
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            /**
             * 返回响应的状态码
             * @return
             * @throws IOException
             */
            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            /**
             * 返回响应状态码对应的文本信息
             * @return
             * @throws IOException
             */
            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             * 通过getBody返回回退内容
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                RequestContext ctx = RequestContext.getCurrentContext();
                Throwable throwable = ctx.getThrowable();
                if (throwable != null) {
                    logger.error("", throwable.getCause());
                }
                ResponseData data = ResponseData.fail("服务器内部错误！", ResponseCode.SERVER_ERROR_CODE.getCode());

                return new ByteArrayInputStream(JSON.toJSONBytes(data));
            }

            /**
             * 通过getHeaders返回响应的请求头信息
             * @return
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mediaType = new MediaType("application", "json", Charset.forName("utf-8"));
                headers.setContentType(mediaType);

                return headers;
            }
        };
    }
}
