package com.springcloud.zuul;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * <h1>Zuul拦截器：</h1><br>
 * 
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下： <br>
 * pre：路由之前 <br>
 * routing：路由之时 <br>
 * post： 路由之后 <br>
 * error：发送错误调用 <br>
 * filterOrder：过滤的顺序<br>
 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。<br>
 * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 * 
 * @author yuanqy
 *
 */
@Component
public class MyFilter extends ZuulFilter {
	Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public String filterType() {
		return "pre";// 路由之前
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if (accessToken == null) {
			log.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (Exception e) {
			}

			return null;
		}
		log.info("ok");
		return null;
	}

}
