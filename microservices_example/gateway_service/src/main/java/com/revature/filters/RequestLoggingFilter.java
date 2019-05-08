package com.revature.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class RequestLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean shouldFilter() {
		RequestContext context = RequestContext.getCurrentContext();
		
		// Demo to show that any logic including RequestContext can help in decision to filter
		return context.getZuulRequestHeaders().get("Passed-First-Contact-Filter").equals("true");
	}

	// Where we provide the logic that is performed by this filter
	@Override
	public Object run() throws ZuulException {
		// RequestContext object is Key-Value store that is present throughout the entire http cycle
		RequestContext context = RequestContext.getCurrentContext();
		
		HttpServletRequest request = context.getRequest();
		
		logger.info("{} request going to {}", request.getMethod(), request.getRequestURI());
		return null;
	}

	// Where we specify if this filter is a pre, route, post, error
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	// With filters, the lower the number the higher the precedence
	@Override
	public int filterOrder() {
		return 0;
	}

}
