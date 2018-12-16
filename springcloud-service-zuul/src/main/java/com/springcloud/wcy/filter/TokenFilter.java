package com.springcloud.wcy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wanchongyang
 * @date 2018-12-16 18:05
 */
@Component
public class TokenFilter extends ZuulFilter {
    private static Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("method:{} >>> url:{}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            LOGGER.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                LOGGER.error("TokenFilter error:", e);
            }

            return null;
        }
        LOGGER.info("ok");
        return null;
    }
}
