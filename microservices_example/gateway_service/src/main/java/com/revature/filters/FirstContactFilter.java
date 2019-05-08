package com.revature.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class FirstContactFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		logger.info("Did this get invoked before RequestLoggingFilter?");
		
		RequestContext context = RequestContext.getCurrentContext();
		
		// Demo adding Zuul Request Headers
		context.getZuulRequestHeaders().put("Passed-First-Contact-Filter", "true");
		
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return -1;
	}

}
