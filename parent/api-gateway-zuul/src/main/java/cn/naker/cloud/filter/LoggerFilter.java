package cn.naker.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zhang Dingjie
 * @date 2021/8/27
 * @Description
 */
@Component
@Slf4j
public class LoggerFilter extends ZuulFilter {


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
	public Object run() throws ZuulException {
		// 通过Zuul获取当请求上下文
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		log.info("LoggerFilter----> method:{}, url: {}", request.getMethod(), request.getRequestURL().toString());

		return null;
	}

}
